// Generated from C:/Users/Computer/IdeaProjects/ParserGenerator/src/grammarparsing\Grammar.g4 by ANTLR 4.7.2
package grammarparsing;

import java.util.LinkedList;
import java.util.Collections;
import grammar.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, WHITESPACE=13, EPS=14, HEADER=15, IGNORE=16, 
		TOKENS=17, RULES=18, START=19, IDENTIFIER=20, CODE=21, REGEX=22;
	public static final int
		RULE_grammarDescription = 0, RULE_header = 1, RULE_parserRules = 2, RULE_singleRule = 3, 
		RULE_argumentList = 4, RULE_varible = 5, RULE_optionsList = 6, RULE_argumentListTail = 7, 
		RULE_ruleOption = 8, RULE_ruleAtomList = 9, RULE_ruleAtom = 10, RULE_terminal = 11, 
		RULE_nonTerminal = 12, RULE_paramList = 13, RULE_paramListTail = 14, RULE_alternativeListTail = 15, 
		RULE_lexerInfo = 16, RULE_singleToken = 17, RULE_skipWS = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"grammarDescription", "header", "parserRules", "singleRule", "argumentList", 
			"varible", "optionsList", "argumentListTail", "ruleOption", "ruleAtomList", 
			"ruleAtom", "terminal", "nonTerminal", "paramList", "paramListTail", 
			"alternativeListTail", "lexerInfo", "singleToken", "skipWS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'returns'", "'['", "']'", "':'", "';'", "','", "'='", 
			"'|'", "'->'", "'skip'", null, "'EPS'", "'header'", "'ignore'", "'tokens'", 
			"'rules'", "'start'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "WHITESPACE", "EPS", "HEADER", "IGNORE", "TOKENS", "RULES", "START", 
			"IDENTIFIER", "CODE", "REGEX"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GrammarDescriptionContext extends ParserRuleContext {
		public Grammar descr;
		public HeaderContext h;
		public ParserRulesContext p;
		public SkipWSContext s;
		public LexerInfoContext lI;
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public ParserRulesContext parserRules() {
			return getRuleContext(ParserRulesContext.class,0);
		}
		public SkipWSContext skipWS() {
			return getRuleContext(SkipWSContext.class,0);
		}
		public LexerInfoContext lexerInfo() {
			return getRuleContext(LexerInfoContext.class,0);
		}
		public GrammarDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGrammarDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGrammarDescription(this);
		}
	}

	public final GrammarDescriptionContext grammarDescription() throws RecognitionException {
		GrammarDescriptionContext _localctx = new GrammarDescriptionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammarDescription);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((GrammarDescriptionContext)_localctx).h = header();
			setState(39);
			((GrammarDescriptionContext)_localctx).p = parserRules();
			setState(40);
			((GrammarDescriptionContext)_localctx).s = skipWS();
			setState(41);
			((GrammarDescriptionContext)_localctx).lI = lexerInfo();
			((GrammarDescriptionContext)_localctx).descr =  new Grammar(((GrammarDescriptionContext)_localctx).h.headerResult, ((GrammarDescriptionContext)_localctx).p.parserRulesList, ((GrammarDescriptionContext)_localctx).s.skipRegex, ((GrammarDescriptionContext)_localctx).lI.tokenRules);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public String headerResult;
		public Token h;
		public TerminalNode HEADER() { return getToken(GrammarParser.HEADER, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(HEADER);
			setState(45);
			((HeaderContext)_localctx).h = match(CODE);
			((HeaderContext)_localctx).headerResult =  (((HeaderContext)_localctx).h!=null?((HeaderContext)_localctx).h.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRulesContext extends ParserRuleContext {
		public List<ParserRule> parserRulesList;
		public SingleRuleContext head;
		public ParserRulesContext tail;
		public SingleRuleContext singleRule() {
			return getRuleContext(SingleRuleContext.class,0);
		}
		public ParserRulesContext parserRules() {
			return getRuleContext(ParserRulesContext.class,0);
		}
		public ParserRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParserRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParserRules(this);
		}
	}

	public final ParserRulesContext parserRules() throws RecognitionException {
		ParserRulesContext _localctx = new ParserRulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parserRules);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				((ParserRulesContext)_localctx).head = singleRule();
				setState(49);
				((ParserRulesContext)_localctx).tail = parserRules();
				((ParserRulesContext)_localctx).parserRulesList =  ((ParserRulesContext)_localctx).tail.parserRulesList; _localctx.parserRulesList.add(0, ((ParserRulesContext)_localctx).head.rule);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				((ParserRulesContext)_localctx).parserRulesList =  new LinkedList<ParserRule>();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleRuleContext extends ParserRuleContext {
		public ParserRule rule;
		public Token name;
		public ArgumentListContext args;
		public VaribleContext ret;
		public OptionsListContext alts;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public VaribleContext varible() {
			return getRuleContext(VaribleContext.class,0);
		}
		public OptionsListContext optionsList() {
			return getRuleContext(OptionsListContext.class,0);
		}
		public SingleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSingleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSingleRule(this);
		}
	}

	public final SingleRuleContext singleRule() throws RecognitionException {
		SingleRuleContext _localctx = new SingleRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_singleRule);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((SingleRuleContext)_localctx).name = match(IDENTIFIER);
				setState(56);
				match(T__0);
				setState(57);
				((SingleRuleContext)_localctx).args = argumentList();
				setState(58);
				match(T__1);
				setState(59);
				match(T__2);
				setState(60);
				match(T__3);
				setState(61);
				((SingleRuleContext)_localctx).ret = varible();
				setState(62);
				match(T__4);
				setState(63);
				match(T__5);
				setState(64);
				((SingleRuleContext)_localctx).alts = optionsList();
				setState(65);
				match(T__6);
				((SingleRuleContext)_localctx).rule =  new ParserRule((((SingleRuleContext)_localctx).name!=null?((SingleRuleContext)_localctx).name.getText():null), ((SingleRuleContext)_localctx).args.args, ((SingleRuleContext)_localctx).ret.var, ((SingleRuleContext)_localctx).alts.alts);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((SingleRuleContext)_localctx).name = match(IDENTIFIER);
				setState(69);
				match(T__2);
				setState(70);
				match(T__3);
				setState(71);
				((SingleRuleContext)_localctx).ret = varible();
				setState(72);
				match(T__4);
				setState(73);
				match(T__5);
				setState(74);
				((SingleRuleContext)_localctx).alts = optionsList();
				setState(75);
				match(T__6);
				((SingleRuleContext)_localctx).rule =  new ParserRule((((SingleRuleContext)_localctx).name!=null?((SingleRuleContext)_localctx).name.getText():null), Collections.EMPTY_LIST, ((SingleRuleContext)_localctx).ret.var, ((SingleRuleContext)_localctx).alts.alts);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public List<Variable> args;
		public VaribleContext head;
		public ArgumentListTailContext tail;
		public VaribleContext varible() {
			return getRuleContext(VaribleContext.class,0);
		}
		public ArgumentListTailContext argumentListTail() {
			return getRuleContext(ArgumentListTailContext.class,0);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argumentList);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((ArgumentListContext)_localctx).head = varible();
				setState(81);
				((ArgumentListContext)_localctx).tail = argumentListTail();
				((ArgumentListContext)_localctx).args =  ((ArgumentListContext)_localctx).tail.args; _localctx.args.add(0, ((ArgumentListContext)_localctx).head.var);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 ((ArgumentListContext)_localctx).args =  new LinkedList<Variable>(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VaribleContext extends ParserRuleContext {
		public Variable var;
		public Token type;
		public Token name;
		public List<TerminalNode> IDENTIFIER() { return getTokens(GrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GrammarParser.IDENTIFIER, i);
		}
		public VaribleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varible; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarible(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarible(this);
		}
	}

	public final VaribleContext varible() throws RecognitionException {
		VaribleContext _localctx = new VaribleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varible);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((VaribleContext)_localctx).type = match(IDENTIFIER);
			setState(88);
			((VaribleContext)_localctx).name = match(IDENTIFIER);
			((VaribleContext)_localctx).var =  new Variable((((VaribleContext)_localctx).type!=null?((VaribleContext)_localctx).type.getText():null), (((VaribleContext)_localctx).name!=null?((VaribleContext)_localctx).name.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionsListContext extends ParserRuleContext {
		public List<RuleOption> alts;
		public RuleOptionContext head;
		public AlternativeListTailContext tail;
		public RuleOptionContext ruleOption() {
			return getRuleContext(RuleOptionContext.class,0);
		}
		public AlternativeListTailContext alternativeListTail() {
			return getRuleContext(AlternativeListTailContext.class,0);
		}
		public OptionsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOptionsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOptionsList(this);
		}
	}

	public final OptionsListContext optionsList() throws RecognitionException {
		OptionsListContext _localctx = new OptionsListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_optionsList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((OptionsListContext)_localctx).head = ruleOption();
			setState(92);
			((OptionsListContext)_localctx).tail = alternativeListTail();
			((OptionsListContext)_localctx).alts =  ((OptionsListContext)_localctx).tail.alts; _localctx.alts.add(0, ((OptionsListContext)_localctx).head.alt);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListTailContext extends ParserRuleContext {
		public List<Variable> args;
		public ArgumentListContext tail;
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArgumentListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgumentListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgumentListTail(this);
		}
	}

	public final ArgumentListTailContext argumentListTail() throws RecognitionException {
		ArgumentListTailContext _localctx = new ArgumentListTailContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argumentListTail);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(T__7);
				setState(96);
				((ArgumentListTailContext)_localctx).tail = argumentList();
				((ArgumentListTailContext)_localctx).args =  ((ArgumentListTailContext)_localctx).tail.args;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				((ArgumentListTailContext)_localctx).args =  new LinkedList<Variable>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleOptionContext extends ParserRuleContext {
		public RuleOption alt;
		public Token init;
		public RuleAtomListContext atoms;
		public RuleAtomListContext ruleAtomList() {
			return getRuleContext(RuleAtomListContext.class,0);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public RuleOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRuleOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRuleOption(this);
		}
	}

	public final RuleOptionContext ruleOption() throws RecognitionException {
		RuleOptionContext _localctx = new RuleOptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ruleOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(102);
				((RuleOptionContext)_localctx).init = match(CODE);
				}
			}

			setState(105);
			((RuleOptionContext)_localctx).atoms = ruleAtomList();
			((RuleOptionContext)_localctx).alt =  new RuleOption((((RuleOptionContext)_localctx).init!=null?((RuleOptionContext)_localctx).init.getText():null), ((RuleOptionContext)_localctx).atoms.atoms);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleAtomListContext extends ParserRuleContext {
		public List<RuleAtom> atoms;
		public RuleAtomContext head;
		public RuleAtomListContext tail;
		public RuleAtomContext ruleAtom() {
			return getRuleContext(RuleAtomContext.class,0);
		}
		public RuleAtomListContext ruleAtomList() {
			return getRuleContext(RuleAtomListContext.class,0);
		}
		public RuleAtomListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleAtomList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRuleAtomList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRuleAtomList(this);
		}
	}

	public final RuleAtomListContext ruleAtomList() throws RecognitionException {
		RuleAtomListContext _localctx = new RuleAtomListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ruleAtomList);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((RuleAtomListContext)_localctx).head = ruleAtom();
				setState(109);
				((RuleAtomListContext)_localctx).tail = ruleAtomList();
				((RuleAtomListContext)_localctx).atoms =  ((RuleAtomListContext)_localctx).tail.atoms; _localctx.atoms.add(0, ((RuleAtomListContext)_localctx).head.atom);
				}
				break;
			case T__6:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				((RuleAtomListContext)_localctx).atoms =  new LinkedList<RuleAtom>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleAtomContext extends ParserRuleContext {
		public RuleAtom atom;
		public TerminalContext resT;
		public NonTerminalContext resN;
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public NonTerminalContext nonTerminal() {
			return getRuleContext(NonTerminalContext.class,0);
		}
		public RuleAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRuleAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRuleAtom(this);
		}
	}

	public final RuleAtomContext ruleAtom() throws RecognitionException {
		RuleAtomContext _localctx = new RuleAtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ruleAtom);
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((RuleAtomContext)_localctx).resT = terminal();
				((RuleAtomContext)_localctx).atom =  ((RuleAtomContext)_localctx).resT.atom;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((RuleAtomContext)_localctx).resN = nonTerminal();
				((RuleAtomContext)_localctx).atom =  ((RuleAtomContext)_localctx).resN.atom;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalContext extends ParserRuleContext {
		public RuleAtom atom;
		public Token id;
		public Token code;
		public Token var;
		public List<TerminalNode> IDENTIFIER() { return getTokens(GrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GrammarParser.IDENTIFIER, i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerminal(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_terminal);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((TerminalContext)_localctx).id = match(IDENTIFIER);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(124);
					((TerminalContext)_localctx).code = match(CODE);
					}
				}

				((TerminalContext)_localctx).atom =  new Terminal(null, (((TerminalContext)_localctx).id!=null?((TerminalContext)_localctx).id.getText():null), (((TerminalContext)_localctx).code!=null?((TerminalContext)_localctx).code.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((TerminalContext)_localctx).var = match(IDENTIFIER);
				setState(129);
				match(T__8);
				setState(130);
				((TerminalContext)_localctx).id = match(IDENTIFIER);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(131);
					((TerminalContext)_localctx).code = match(CODE);
					}
				}

				((TerminalContext)_localctx).atom =  new Terminal((((TerminalContext)_localctx).var!=null?((TerminalContext)_localctx).var.getText():null), (((TerminalContext)_localctx).id!=null?((TerminalContext)_localctx).id.getText():null), (((TerminalContext)_localctx).code!=null?((TerminalContext)_localctx).code.getText():null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonTerminalContext extends ParserRuleContext {
		public RuleAtom atom;
		public Token var;
		public Token id;
		public ParamListContext params;
		public Token code;
		public List<TerminalNode> IDENTIFIER() { return getTokens(GrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GrammarParser.IDENTIFIER, i);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public NonTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonTerminal(this);
		}
	}

	public final NonTerminalContext nonTerminal() throws RecognitionException {
		NonTerminalContext _localctx = new NonTerminalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nonTerminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((NonTerminalContext)_localctx).var = match(IDENTIFIER);
			setState(138);
			match(T__8);
			setState(139);
			((NonTerminalContext)_localctx).id = match(IDENTIFIER);
			setState(140);
			match(T__0);
			setState(141);
			((NonTerminalContext)_localctx).params = paramList();
			setState(142);
			match(T__1);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(143);
				((NonTerminalContext)_localctx).code = match(CODE);
				}
			}

			((NonTerminalContext)_localctx).atom =  new NonTerminal((((NonTerminalContext)_localctx).var!=null?((NonTerminalContext)_localctx).var.getText():null), (((NonTerminalContext)_localctx).id!=null?((NonTerminalContext)_localctx).id.getText():null), ((NonTerminalContext)_localctx).params.params, (((NonTerminalContext)_localctx).code!=null?((NonTerminalContext)_localctx).code.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<String> params;
		public Token head;
		public ParamListTailContext tail;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public ParamListTailContext paramListTail() {
			return getRuleContext(ParamListTailContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_paramList);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				((ParamListContext)_localctx).head = match(IDENTIFIER);
				setState(149);
				((ParamListContext)_localctx).tail = paramListTail();
				((ParamListContext)_localctx).params =  ((ParamListContext)_localctx).tail.params; _localctx.params.add(0, (((ParamListContext)_localctx).head!=null?((ParamListContext)_localctx).head.getText():null));
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				((ParamListContext)_localctx).params =  new LinkedList<String>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListTailContext extends ParserRuleContext {
		public List<String> params;
		public ParamListContext tail;
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ParamListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParamListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParamListTail(this);
		}
	}

	public final ParamListTailContext paramListTail() throws RecognitionException {
		ParamListTailContext _localctx = new ParamListTailContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_paramListTail);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__7);
				setState(156);
				((ParamListTailContext)_localctx).tail = paramList();
				((ParamListTailContext)_localctx).params =  ((ParamListTailContext)_localctx).tail.params;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				((ParamListTailContext)_localctx).params =  new LinkedList<String>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeListTailContext extends ParserRuleContext {
		public List<RuleOption> alts;
		public OptionsListContext tail;
		public OptionsListContext optionsList() {
			return getRuleContext(OptionsListContext.class,0);
		}
		public AlternativeListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAlternativeListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAlternativeListTail(this);
		}
	}

	public final AlternativeListTailContext alternativeListTail() throws RecognitionException {
		AlternativeListTailContext _localctx = new AlternativeListTailContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_alternativeListTail);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__9);
				setState(163);
				((AlternativeListTailContext)_localctx).tail = optionsList();
				((AlternativeListTailContext)_localctx).alts =  ((AlternativeListTailContext)_localctx).tail.alts;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				((AlternativeListTailContext)_localctx).alts =  new LinkedList<RuleOption>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerInfoContext extends ParserRuleContext {
		public List<TokenRule> tokenRules;
		public SingleTokenContext head;
		public LexerInfoContext tail;
		public SingleTokenContext singleToken() {
			return getRuleContext(SingleTokenContext.class,0);
		}
		public LexerInfoContext lexerInfo() {
			return getRuleContext(LexerInfoContext.class,0);
		}
		public LexerInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLexerInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLexerInfo(this);
		}
	}

	public final LexerInfoContext lexerInfo() throws RecognitionException {
		LexerInfoContext _localctx = new LexerInfoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lexerInfo);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((LexerInfoContext)_localctx).head = singleToken();
				setState(170);
				((LexerInfoContext)_localctx).tail = lexerInfo();
				((LexerInfoContext)_localctx).tokenRules =  ((LexerInfoContext)_localctx).tail.tokenRules; _localctx.tokenRules.add(0, ((LexerInfoContext)_localctx).head.token);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				((LexerInfoContext)_localctx).tokenRules =  new LinkedList<TokenRule>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTokenContext extends ParserRuleContext {
		public TokenRule token;
		public Token id;
		public Token regex;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public SingleTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSingleToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSingleToken(this);
		}
	}

	public final SingleTokenContext singleToken() throws RecognitionException {
		SingleTokenContext _localctx = new SingleTokenContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_singleToken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			((SingleTokenContext)_localctx).id = match(IDENTIFIER);
			setState(177);
			match(T__5);
			setState(178);
			((SingleTokenContext)_localctx).regex = match(REGEX);
			setState(179);
			match(T__6);
			((SingleTokenContext)_localctx).token =  new TokenRule((((SingleTokenContext)_localctx).id!=null?((SingleTokenContext)_localctx).id.getText():null), (((SingleTokenContext)_localctx).regex!=null?((SingleTokenContext)_localctx).regex.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipWSContext extends ParserRuleContext {
		public String skipRegex;
		public Token REGEX;
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public SkipWSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipWS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSkipWS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSkipWS(this);
		}
	}

	public final SkipWSContext skipWS() throws RecognitionException {
		SkipWSContext _localctx = new SkipWSContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_skipWS);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(IDENTIFIER);
				setState(183);
				match(T__5);
				setState(184);
				((SkipWSContext)_localctx).REGEX = match(REGEX);
				setState(185);
				match(T__10);
				setState(186);
				match(T__11);
				setState(187);
				match(T__6);
				((SkipWSContext)_localctx).skipRegex =  (((SkipWSContext)_localctx).REGEX!=null?((SkipWSContext)_localctx).REGEX.getText():null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				((SkipWSContext)_localctx).skipRegex =  "\" \"";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00c3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5Q\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tg\n"+
		"\t\3\n\5\nj\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13t\n\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f|\n\f\3\r\3\r\5\r\u0080\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u0087\n\r\3\r\5\r\u008a\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0093\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u009c\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00a3\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00aa"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00b1\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00c1\n\24\3\24\2\2"+
		"\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\2\2\u00bf\2(\3\2\2\2"+
		"\4.\3\2\2\2\6\67\3\2\2\2\bP\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16]\3\2\2\2"+
		"\20f\3\2\2\2\22i\3\2\2\2\24s\3\2\2\2\26{\3\2\2\2\30\u0089\3\2\2\2\32\u008b"+
		"\3\2\2\2\34\u009b\3\2\2\2\36\u00a2\3\2\2\2 \u00a9\3\2\2\2\"\u00b0\3\2"+
		"\2\2$\u00b2\3\2\2\2&\u00c0\3\2\2\2()\5\4\3\2)*\5\6\4\2*+\5&\24\2+,\5\""+
		"\22\2,-\b\2\1\2-\3\3\2\2\2./\7\21\2\2/\60\7\27\2\2\60\61\b\3\1\2\61\5"+
		"\3\2\2\2\62\63\5\b\5\2\63\64\5\6\4\2\64\65\b\4\1\2\658\3\2\2\2\668\b\4"+
		"\1\2\67\62\3\2\2\2\67\66\3\2\2\28\7\3\2\2\29:\7\26\2\2:;\7\3\2\2;<\5\n"+
		"\6\2<=\7\4\2\2=>\7\5\2\2>?\7\6\2\2?@\5\f\7\2@A\7\7\2\2AB\7\b\2\2BC\5\16"+
		"\b\2CD\7\t\2\2DE\b\5\1\2EQ\3\2\2\2FG\7\26\2\2GH\7\5\2\2HI\7\6\2\2IJ\5"+
		"\f\7\2JK\7\7\2\2KL\7\b\2\2LM\5\16\b\2MN\7\t\2\2NO\b\5\1\2OQ\3\2\2\2P9"+
		"\3\2\2\2PF\3\2\2\2Q\t\3\2\2\2RS\5\f\7\2ST\5\20\t\2TU\b\6\1\2UX\3\2\2\2"+
		"VX\b\6\1\2WR\3\2\2\2WV\3\2\2\2X\13\3\2\2\2YZ\7\26\2\2Z[\7\26\2\2[\\\b"+
		"\7\1\2\\\r\3\2\2\2]^\5\22\n\2^_\5 \21\2_`\b\b\1\2`\17\3\2\2\2ab\7\n\2"+
		"\2bc\5\n\6\2cd\b\t\1\2dg\3\2\2\2eg\b\t\1\2fa\3\2\2\2fe\3\2\2\2g\21\3\2"+
		"\2\2hj\7\27\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\5\24\13\2lm\b\n\1\2m\23"+
		"\3\2\2\2no\5\26\f\2op\5\24\13\2pq\b\13\1\2qt\3\2\2\2rt\b\13\1\2sn\3\2"+
		"\2\2sr\3\2\2\2t\25\3\2\2\2uv\5\30\r\2vw\b\f\1\2w|\3\2\2\2xy\5\32\16\2"+
		"yz\b\f\1\2z|\3\2\2\2{u\3\2\2\2{x\3\2\2\2|\27\3\2\2\2}\177\7\26\2\2~\u0080"+
		"\7\27\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u008a"+
		"\b\r\1\2\u0082\u0083\7\26\2\2\u0083\u0084\7\13\2\2\u0084\u0086\7\26\2"+
		"\2\u0085\u0087\7\27\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\b\r\1\2\u0089}\3\2\2\2\u0089\u0082\3\2\2\2"+
		"\u008a\31\3\2\2\2\u008b\u008c\7\26\2\2\u008c\u008d\7\13\2\2\u008d\u008e"+
		"\7\26\2\2\u008e\u008f\7\3\2\2\u008f\u0090\5\34\17\2\u0090\u0092\7\4\2"+
		"\2\u0091\u0093\7\27\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\b\16\1\2\u0095\33\3\2\2\2\u0096\u0097\7\26"+
		"\2\2\u0097\u0098\5\36\20\2\u0098\u0099\b\17\1\2\u0099\u009c\3\2\2\2\u009a"+
		"\u009c\b\17\1\2\u009b\u0096\3\2\2\2\u009b\u009a\3\2\2\2\u009c\35\3\2\2"+
		"\2\u009d\u009e\7\n\2\2\u009e\u009f\5\34\17\2\u009f\u00a0\b\20\1\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u00a3\b\20\1\2\u00a2\u009d\3\2\2\2\u00a2\u00a1\3"+
		"\2\2\2\u00a3\37\3\2\2\2\u00a4\u00a5\7\f\2\2\u00a5\u00a6\5\16\b\2\u00a6"+
		"\u00a7\b\21\1\2\u00a7\u00aa\3\2\2\2\u00a8\u00aa\b\21\1\2\u00a9\u00a4\3"+
		"\2\2\2\u00a9\u00a8\3\2\2\2\u00aa!\3\2\2\2\u00ab\u00ac\5$\23\2\u00ac\u00ad"+
		"\5\"\22\2\u00ad\u00ae\b\22\1\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\b\22\1"+
		"\2\u00b0\u00ab\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1#\3\2\2\2\u00b2\u00b3"+
		"\7\26\2\2\u00b3\u00b4\7\b\2\2\u00b4\u00b5\7\30\2\2\u00b5\u00b6\7\t\2\2"+
		"\u00b6\u00b7\b\23\1\2\u00b7%\3\2\2\2\u00b8\u00b9\7\26\2\2\u00b9\u00ba"+
		"\7\b\2\2\u00ba\u00bb\7\30\2\2\u00bb\u00bc\7\r\2\2\u00bc\u00bd\7\16\2\2"+
		"\u00bd\u00be\7\t\2\2\u00be\u00c1\b\24\1\2\u00bf\u00c1\b\24\1\2\u00c0\u00b8"+
		"\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\'\3\2\2\2\22\67PWfis{\177\u0086\u0089"+
		"\u0092\u009b\u00a2\u00a9\u00b0\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}