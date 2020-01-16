grammar Grammar;

@header {
import java.util.LinkedList;
import java.util.Collections;
import grammar.*;
}

grammarDescription returns [Grammar descr]: h=header p=parserRules s=skipWS lI=lexerInfo {$descr = new Grammar($h.headerResult, $p.parserRulesList, $s.skipRegex, $lI.tokenRules);};

header returns [String headerResult]: HEADER h=CODE {$headerResult = $h.text;};

parserRules returns [List<ParserRule> parserRulesList]: head=singleRule tail=parserRules {$parserRulesList = $tail.parserRulesList; $parserRulesList.add(0, $head.rule);}
                                                 | {$parserRulesList = new LinkedList<ParserRule>();};

singleRule returns [ParserRule rule]: name=IDENTIFIER '(' args=argumentList ')' 'returns' '[' ret=varible ']' ':' alts=optionsList ';' {$rule = new ParserRule($name.text, $args.args, $ret.var, $alts.alts);}
                                    | name=IDENTIFIER 'returns' '[' ret=varible ']' ':' alts=optionsList ';' {$rule = new ParserRule($name.text, Collections.EMPTY_LIST, $ret.var, $alts.alts);};

argumentList returns [List<Variable> args]: head=varible tail=argumentListTail {$args = $tail.args; $args.add(0, $head.var);}
                                                         | { $args = new LinkedList<Variable>(); };

varible returns [Variable var]:  type=IDENTIFIER name=IDENTIFIER {$var = new Variable($type.text, $name.text);};

optionsList returns [List<RuleOption> alts]: head=ruleOption tail=alternativeListTail{$alts = $tail.alts; $alts.add(0, $head.alt);};

argumentListTail returns [List<Variable> args]: ',' tail=argumentList {$args = $tail.args;}
                                                             | {$args = new LinkedList<Variable>();};

ruleOption returns [RuleOption alt]: init=CODE? atoms=ruleAtomList {$alt = new RuleOption($init.text, $atoms.atoms);};

ruleAtomList returns [List<RuleAtom> atoms]: head=ruleAtom tail=ruleAtomList{$atoms = $tail.atoms; $atoms.add(0, $head.atom);}
                                           | {$atoms = new LinkedList<RuleAtom>();};

ruleAtom returns [RuleAtom atom]: resT=terminal {$atom = $resT.atom;}
                                | resN=nonTerminal {$atom = $resN.atom;};

terminal returns [RuleAtom atom]: id = IDENTIFIER (code=CODE)? {$atom = new Terminal(null, $id.text, $code.text);}
                                | var=IDENTIFIER '=' id=IDENTIFIER (code=CODE)? {$atom = new Terminal($var.text, $id.text, $code.text);};


nonTerminal returns [RuleAtom atom]: var=IDENTIFIER '=' id=IDENTIFIER '(' params=paramList ')' (code=CODE)? {$atom = new NonTerminal($var.text, $id.text, $params.params, $code.text);};

paramList returns [List<String> params]: head=IDENTIFIER tail=paramListTail {$params = $tail.params; $params.add(0, $head.text);}
                                       | {$params = new LinkedList<String>();};

paramListTail returns [List<String> params]: ',' tail=paramList {$params = $tail.params;}
                                           | {$params = new LinkedList<String>();};

alternativeListTail returns [List<RuleOption> alts]: '|' tail=optionsList {$alts = $tail.alts;}
                                                        | {$alts = new LinkedList<RuleOption>();};

lexerInfo returns [List<TokenRule> tokenRules]: head=singleToken tail=lexerInfo {$tokenRules = $tail.tokenRules; $tokenRules.add(0, $head.token);}
                                              | {$tokenRules = new LinkedList<TokenRule>();};

singleToken returns [TokenRule token]: id=IDENTIFIER ':' regex=REGEX ';' {$token = new TokenRule($id.text, $regex.text);};

skipWS returns [String skipRegex]: IDENTIFIER ':' REGEX '->' 'skip' ';' {$skipRegex = $REGEX.text;}
                                 | {$skipRegex = "\" \"";};

WHITESPACE:     ([ \t\r\n]+|('\\r\\n')) -> skip;
EPS:            'EPS';
HEADER:         'header';
IGNORE:         'ignore';
TOKENS:         'tokens';
RULES:          'rules';
START:          'start';
IDENTIFIER:     [a-zA-Z]([a-zA-Z0-9_])*;
CODE :          '{' (~[{}]+ CODE?)* '}';
REGEX:          '"'(~["])+'"';
