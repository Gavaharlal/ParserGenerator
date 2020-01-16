package generators;

import grammar.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator {
    private final Path output;
    private final String name;
    private final Grammar grammar;
    private final String tokensName;
    private final Map<String, String> nonTermToType;

    public ParserGenerator(final Path output, final String name, final Grammar grammar) {
        this.output = output;
        this.name = name;
        this.grammar = grammar;
        this.tokensName = name + "Tokens";
        this.nonTermToType = new HashMap<>();
        for (ParserRule rule : grammar.getParserRules()) {
            nonTermToType.put(rule.getName(), rule.getReturnValue().getType());
        }
    }

    public void generate() throws IOException {
        try (final TabbedWriter writer = new TabbedWriter(output.resolve(name + "Parser.java"))) {
            writer.writeHeader(grammar.getHeader());
            writer.println(0, "public class " + name + "Parser {");
            writer.println(1, "private final " + name + "Lexer lexer;\n");
            writer.println(1, "public " + name + "Parser(final " + name + "Lexer lexer) {");
            writer.println(2, "this.lexer = lexer;");
            writer.println(1, "}\n");
            ParserRule mainRule = grammar.getStartingRule();
            String mainRuleArgs = getArgs(mainRule);
            writer.writeFunctionHead("public", mainRule.getReturnValue().getType(), "mainRule", mainRuleArgs);
            writer.println(2, "lexer.nextToken();");

            String mainRuleReturnValueType = grammar.getStartingRule().getReturnValue().getType();
            String mainRuleReturnValueName = grammar.getStartingRule().getReturnValue().getName();
            String mainRuleName = grammar.getStartingRule().getName();
            String mainRuleParams = grammar.getStartingRule().getArguments().stream()
                    .map(Variable::getName)
                    .collect(Collectors.joining(", "));

            writer.println(2, mainRuleReturnValueType + " " + mainRuleReturnValueName + " = parse" + mainRuleName + "(" + mainRuleParams + ");");
            writer.println(2, "if (lexer.getCurrentToken().type != " + tokensName + "._END) {");
            writer.println(3, "throw new ParsingException(\"Expected end of input but found \" + lexer.getCurrentToken().getText());");
            writer.println(2, "}");
            writer.println(2, "return " + mainRule.getReturnValue().getName() + ";");
            writer.println(1, "}\n");

            for (final ParserRule rule : grammar.getParserRules()) {
                generateRule(rule, writer);
            }

            writer.println(0, "}");
        }
    }

    private void generateRule(final ParserRule rule, final TabbedWriter writer) throws IOException {
        writer.writeFunctionHead("private", rule.getReturnValue().getType(), "parse" + rule.getName(), getArgs(rule));
        writer.println(2, rule.getReturnValue().getType() + " " + rule.getReturnValue().getName() + ";");
        writer.println(2, "switch (lexer.getCurrentToken().type) {");
        final List<Set<String>> allMarkers = new ArrayList<>();
        for (int i = 0; i < rule.getAlternatives().size(); ++i) {
            generateRuleOptions(rule, i, writer);
            allMarkers.add(grammar.getMarkers(rule, i));
        }
        writer.println(3, "default: {");
        final String wanted = allMarkers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining(", "));
        writer.println(4, "throw new ParsingException(\"Expected " + wanted + " but found \" + lexer.getCurrentToken().type.name());");
        writer.println(3, "}");
        writer.println(2, "}");
        writer.println(2, "return " + rule.getReturnValue().getName() + ";");
        writer.println(1, "}\n");

    }

    private String getArgs(final ParserRule rule) {
        return rule.getArguments().stream()
                .map(arg -> arg.getType() + " " + arg.getName())
                .collect(Collectors.joining(", "));
    }

    private void generateRuleOptions(final ParserRule rule, final int ind, final TabbedWriter writer) throws IOException {
        RuleOption alternative = rule.getAlternatives().get(ind);
        String markers = grammar.getMarkers(rule, ind).stream().map(s -> "            case " + s + ":").collect(Collectors.joining("\n"));
        writer.print(0, markers);
        writer.println(0, " {");
        writer.println(4, alternative.getInitCode() + "");
        if (!alternative.isEpsilonRule()) {
            for (RuleAtom atom : alternative.getAtoms()) {
                writeAtom(atom, writer);
            }
        }
        writer.println(4, "break;");
        writer.println(3, "}");
    }

    private void writeAtom(final RuleAtom atom, final TabbedWriter writer) throws IOException {
        if (atom.isTerminal()) {
            if (atom.getVar() != null) {
                writer.println(4, "Token " + atom.getVar() + " = lexer.getCurrentToken();");
            }
            writer.println(4, atom.getCode() + "");
            writer.println(4, "lexer.nextToken();");
        } else {
            NonTerminal nonTerm = (NonTerminal) atom;
            String params = String.join(", ", nonTerm.getParams());
            writer.println(4, nonTermToType.get(nonTerm.getRuleSignature()) + " " + nonTerm.getVar() + " = parse" + nonTerm.getRuleSignature() + "(" + params + ");");
            writer.println(4, nonTerm.getCode() + "");
        }
    }
}
