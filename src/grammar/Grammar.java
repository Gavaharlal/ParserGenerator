package grammar;


import java.util.*;
import java.util.stream.Collectors;

public class Grammar {
    private String header;
    private List<TokenRule> tokenRules;
    private String skipRegex;
    private ParserRule startingRule;
    private List<ParserRule> parserRules;

    private Map<String, Set<String>> first;
    private Map<String, Set<String>> follow;

    private final static String EPS = "EPS";
    public final static String END = "_END";

    private GrammarException grammarException;

    public Grammar(String header, List<ParserRule> parserRules, String skipRegex, List<TokenRule> tokenRules) {
        try {
            this.header = header;
            this.tokenRules = tokenRules;
            this.skipRegex = skipRegex;

            Map<String, TokenRule> nameToTokenRule = new HashMap<>();
            for (TokenRule rule : tokenRules) {
                String tokenString = rule.getName();
                if (nameToTokenRule.containsKey(tokenString)) {
                    throw new GrammarException("Duplicate lexer rule definition for token \"" + tokenString + "\" found");
                }
                nameToTokenRule.put(tokenString, rule);
            }

            if (parserRules.isEmpty()) {
                throw new GrammarException("Empty grammar");
            }

            this.startingRule = parserRules.get(0);

            Set<String> nonTerminals = parserRules.stream().map(ParserRule::getName).collect(Collectors.toSet());
            Set<String> terminals = nameToTokenRule.keySet();
            Set<RuleAtom> ruleAtoms = getAtoms(parserRules);
            for (RuleAtom ruleAtom : ruleAtoms) {
                if (ruleAtom.isTerminal()) {
                    if (!terminals.contains(ruleAtom.getRuleSignature())) {
                        throw new GrammarException("Unknown terminal in grammar rules found: " + ruleAtom.getRuleSignature());
                    }
                } else {
                    if (!nonTerminals.contains(ruleAtom.getRuleSignature())) {
                        throw new GrammarException("Unknown non-terminal in grammar rules found: " + ruleAtom.getRuleSignature());
                    }
                }
            }

            Set<String> rightPartNonTerminals = ruleAtoms.stream()
                    .filter(ruleAtom -> !ruleAtom.isTerminal())
                    .map(RuleAtom::getRuleSignature)
                    .collect(Collectors.toSet());
            Set<String> leftPartNonTerminals = parserRules.stream()
                    .filter(parserRule -> parserRule != startingRule)
                    .map(ParserRule::getName)
                    .collect(Collectors.toSet());

            for (String ruleLeftPart : leftPartNonTerminals) {
                if (!rightPartNonTerminals.contains(ruleLeftPart)) {
                    throw new GrammarException("Unused non-terminal: " + ruleLeftPart);
                }
            }
            this.parserRules = parserRules;

            this.first = new HashMap<>();
            countFirst();

            this.follow = new HashMap<>();
            countFollow();

            if (!checkLL1()) {
                throw new GrammarException("Not LL1 grammar");
            }
        } catch (GrammarException e) {
            this.grammarException = e;
        }
    }

    private Set<RuleAtom> getAtoms(List<ParserRule> parserRules) {
        return parserRules.stream()
                .flatMap(rule -> rule.getAlternatives().stream())
                .filter(alternative -> !alternative.isEpsilonRule())
                .map(RuleOption::getAtoms)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<String> getFirst(final List<RuleAtom> atoms) {
        if (atoms.isEmpty()) {
            return Collections.singleton(EPS);
        }
        final RuleAtom begin = atoms.get(0);
        if (begin.isTerminal()) {
            return Collections.singleton(begin.getRuleSignature());
        } else {
            first.putIfAbsent(begin.getRuleSignature(), new HashSet<>());
            final Set<String> res = first.get(begin.getRuleSignature());
            if (res.contains(EPS)) {
                res.remove(EPS);
                res.addAll(getFirst(atoms.subList(1, atoms.size())));
            }
            return res;
        }
    }

    private void countFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (final ParserRule rule : parserRules) {
                for (final RuleOption alternative : rule.getAlternatives()) {
                    first.putIfAbsent(rule.getName(), new HashSet<>());
                    final Set<String> prevSet = first.get(rule.getName());
                    final int prevSize = prevSet.size();
                    prevSet.addAll(getFirst(alternative.getAtoms()));
                    if (prevSet.size() != prevSize) {
                        changed = true;
                    }
                }
            }
        }
    }

    private void countFollow() {
        follow.put(startingRule.getName(), new HashSet<>());
        follow.get(startingRule.getName()).add(END);
        boolean changed = true;
        while (changed) {
            changed = false;
            for (final ParserRule rule : parserRules) {
                for (final RuleOption alternative : rule.getAlternatives()) {
                    if (alternative.isEpsilonRule()) {
                        continue;
                    }
                    final List<RuleAtom> atoms = alternative.getAtoms();
                    for (int i = 0; i < atoms.size(); ++i) {
                        if (atoms.get(i).isTerminal()) {
                            continue;
                        }
                        final Set<String> tmp = getFirst(atoms.subList(i + 1, atoms.size()));
                        boolean hadEps = tmp.contains(EPS);
                        follow.putIfAbsent(atoms.get(i).getRuleSignature(), new HashSet<>());
                        final Set<String> prevSet = follow.get(atoms.get(i).getRuleSignature());
                        int prevSize = prevSet.size();
                        prevSet.addAll(tmp);
                        prevSet.remove(EPS);
                        if (hadEps) {
                            follow.putIfAbsent(rule.getName(), new HashSet<>());
                            final Set<String> tmp2 = follow.get(rule.getName());
                            prevSet.addAll(tmp2);
                        }
                        if (prevSet.size() != prevSize) {
                            changed = true;
                        }
                    }
                }
            }
        }
    }

    private boolean checkRule(final ParserRule rule) {
        for (int i = 0; i < rule.getAlternatives().size(); ++i) {
            for (int j = 0; j < rule.getAlternatives().size(); ++j) {
                if (i == j) {
                    continue;
                }
                final Set<String> firstA = getFirst(rule.getAlternatives().get(i).getAtoms());
                final Set<String> firstB = getFirst(rule.getAlternatives().get(j).getAtoms());
                boolean intersect = firstB.stream().anyMatch(firstA::contains);
                if (intersect) {
                    return false;
                }
                if (firstA.contains(EPS)) {
                    intersect = follow.get(rule.getName()).stream().anyMatch(firstA::contains);
                    if (intersect) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkLL1() {
        return parserRules.stream().allMatch(this::checkRule);
    }

    public Set<String> getMarkers(final ParserRule rule, int altInd) {
        final Set<String> res = new HashSet<>(getFirst(rule.getAlternatives().get(altInd).getAtoms()));
        if (res.contains(EPS)) {
            res.addAll(follow.get(rule.getName()));
        }
        res.remove(EPS);
        return res;
    }

    public GrammarException getGrammarException() {
        return grammarException;
    }

    public String getHeader() {
        return header;
    }

    public List<TokenRule> getTokenRules() {
        return tokenRules;
    }

    public String getSkipRegex() {
        return skipRegex;
    }

    public List<ParserRule> getParserRules() {
        return parserRules;
    }

    public ParserRule getStartingRule() {
        return startingRule;
    }
}
