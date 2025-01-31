// Generated from C:/Users/Computer/IdeaProjects/ParserGenerator/src/grammarparsing\Grammar.g4 by ANTLR 4.7.2
package grammarparsing;

import java.util.LinkedList;
import java.util.Collections;
import grammar.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, WHITESPACE=13, EPS=14, HEADER=15, IGNORE=16, 
		TOKENS=17, RULES=18, START=19, IDENTIFIER=20, CODE=21, REGEX=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "WHITESPACE", "EPS", "HEADER", "IGNORE", "TOKENS", 
			"RULES", "START", "IDENTIFIER", "CODE", "REGEX"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\6\16S\n\16"+
		"\r\16\16\16T\3\16\3\16\3\16\3\16\5\16[\n\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u0086\n\25\f\25\16\25\u0089"+
		"\13\25\3\26\3\26\6\26\u008d\n\26\r\26\16\26\u008e\3\26\5\26\u0092\n\26"+
		"\7\26\u0094\n\26\f\26\16\26\u0097\13\26\3\26\3\26\3\27\3\27\6\27\u009d"+
		"\n\27\r\27\16\27\u009e\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30\3\2\7\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\4\2}}\177\177\3"+
		"\2$$\2\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?\3\2"+
		"\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31L\3"+
		"\2\2\2\33Z\3\2\2\2\35^\3\2\2\2\37b\3\2\2\2!i\3\2\2\2#p\3\2\2\2%w\3\2\2"+
		"\2\'}\3\2\2\2)\u0083\3\2\2\2+\u008a\3\2\2\2-\u009a\3\2\2\2/\60\7*\2\2"+
		"\60\4\3\2\2\2\61\62\7+\2\2\62\6\3\2\2\2\63\64\7t\2\2\64\65\7g\2\2\65\66"+
		"\7v\2\2\66\67\7w\2\2\678\7t\2\289\7p\2\29:\7u\2\2:\b\3\2\2\2;<\7]\2\2"+
		"<\n\3\2\2\2=>\7_\2\2>\f\3\2\2\2?@\7<\2\2@\16\3\2\2\2AB\7=\2\2B\20\3\2"+
		"\2\2CD\7.\2\2D\22\3\2\2\2EF\7?\2\2F\24\3\2\2\2GH\7~\2\2H\26\3\2\2\2IJ"+
		"\7/\2\2JK\7@\2\2K\30\3\2\2\2LM\7u\2\2MN\7m\2\2NO\7k\2\2OP\7r\2\2P\32\3"+
		"\2\2\2QS\t\2\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U[\3\2\2\2VW\7"+
		"^\2\2WX\7t\2\2XY\7^\2\2Y[\7p\2\2ZR\3\2\2\2ZV\3\2\2\2[\\\3\2\2\2\\]\b\16"+
		"\2\2]\34\3\2\2\2^_\7G\2\2_`\7R\2\2`a\7U\2\2a\36\3\2\2\2bc\7j\2\2cd\7g"+
		"\2\2de\7c\2\2ef\7f\2\2fg\7g\2\2gh\7t\2\2h \3\2\2\2ij\7k\2\2jk\7i\2\2k"+
		"l\7p\2\2lm\7q\2\2mn\7t\2\2no\7g\2\2o\"\3\2\2\2pq\7v\2\2qr\7q\2\2rs\7m"+
		"\2\2st\7g\2\2tu\7p\2\2uv\7u\2\2v$\3\2\2\2wx\7t\2\2xy\7w\2\2yz\7n\2\2z"+
		"{\7g\2\2{|\7u\2\2|&\3\2\2\2}~\7u\2\2~\177\7v\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7v\2\2\u0082(\3\2\2\2\u0083\u0087\t\3\2\2\u0084"+
		"\u0086\t\4\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088*\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0095"+
		"\7}\2\2\u008b\u008d\n\5\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0092\5+"+
		"\26\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u008c\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\177\2\2\u0099"+
		",\3\2\2\2\u009a\u009c\7$\2\2\u009b\u009d\n\6\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\7$\2\2\u00a1.\3\2\2\2\n\2TZ\u0087\u008e\u0091\u0095\u009e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}