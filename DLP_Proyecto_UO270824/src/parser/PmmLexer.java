// Generated from C:/Users/Moises/Desktop/UNIVERSIDAD/TERCERO/2 CUATRIMESTRE/DLP/Laboratorio/DLP_Proyecto_UO270824/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

import ast.*;
import errorhandler.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, WHITE_SPACE=38, 
		ONE_LINE_COMMENT=39, MULTIPLE_LINE_COMMENT=40, INT_CONSTANT=41, REAL_CONSTANT=42, 
		CHAR_CONSTANT=43, ID=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "EXPONENT", "LETTER", "WHITE_SPACE", 
			"ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", "INT_CONSTANT", "REAL_CONSTANT", 
			"CHAR_CONSTANT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "','", "';'", 
			"'='", "'print'", "'input'", "'return'", "'if'", "'else'", "'while'", 
			"'['", "']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", 
			"'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "'int'", "'double'", 
			"'char'", "'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WHITE_SPACE", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", 
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u013a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\5\'\u00db\n\'\3\'"+
		"\3\'\3(\3(\3)\6)\u00e2\n)\r)\16)\u00e3\3)\3)\3*\3*\7*\u00ea\n*\f*\16*"+
		"\u00ed\13*\3*\5*\u00f0\n*\3*\3*\3+\3+\3+\3+\3+\7+\u00f9\n+\f+\16+\u00fc"+
		"\13+\3+\3+\3+\3+\3+\3+\3,\3,\3,\7,\u0107\n,\f,\16,\u010a\13,\5,\u010c"+
		"\n,\3-\3-\3-\3-\5-\u0112\n-\3-\3-\3-\3-\3-\3-\5-\u011a\n-\3-\3-\5-\u011e"+
		"\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u012e\n.\3/\3/\5/\u0132"+
		"\n/\3/\3/\7/\u0136\n/\f/\16/\u0139\13/\4\u00eb\u00fa\2\60\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M\2O\2Q(S)U*W+Y,[-].\3\2\n\4\2GGgg\4\2C\\c|\5\2\13\f\17\17\"\"\3"+
		"\3\f\f\3\2\63;\3\2\62;\4\2ppvv\4\2\62;aa\2\u0147\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2"+
		"]\3\2\2\2\3_\3\2\2\2\5c\3\2\2\2\7h\3\2\2\2\tj\3\2\2\2\13l\3\2\2\2\rn\3"+
		"\2\2\2\17p\3\2\2\2\21r\3\2\2\2\23t\3\2\2\2\25v\3\2\2\2\27x\3\2\2\2\31"+
		"~\3\2\2\2\33\u0084\3\2\2\2\35\u008b\3\2\2\2\37\u008e\3\2\2\2!\u0093\3"+
		"\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2\'\u009d\3\2\2\2)\u009f\3\2\2\2+\u00a1"+
		"\3\2\2\2-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61\u00a7\3\2\2\2\63\u00a9\3\2\2"+
		"\2\65\u00ab\3\2\2\2\67\u00ad\3\2\2\29\u00b0\3\2\2\2;\u00b2\3\2\2\2=\u00b5"+
		"\3\2\2\2?\u00b8\3\2\2\2A\u00bb\3\2\2\2C\u00be\3\2\2\2E\u00c1\3\2\2\2G"+
		"\u00c5\3\2\2\2I\u00cc\3\2\2\2K\u00d1\3\2\2\2M\u00d8\3\2\2\2O\u00de\3\2"+
		"\2\2Q\u00e1\3\2\2\2S\u00e7\3\2\2\2U\u00f3\3\2\2\2W\u010b\3\2\2\2Y\u011d"+
		"\3\2\2\2[\u012d\3\2\2\2]\u0131\3\2\2\2_`\7f\2\2`a\7g\2\2ab\7h\2\2b\4\3"+
		"\2\2\2cd\7o\2\2de\7c\2\2ef\7k\2\2fg\7p\2\2g\6\3\2\2\2hi\7*\2\2i\b\3\2"+
		"\2\2jk\7+\2\2k\n\3\2\2\2lm\7<\2\2m\f\3\2\2\2no\7}\2\2o\16\3\2\2\2pq\7"+
		"\177\2\2q\20\3\2\2\2rs\7.\2\2s\22\3\2\2\2tu\7=\2\2u\24\3\2\2\2vw\7?\2"+
		"\2w\26\3\2\2\2xy\7r\2\2yz\7t\2\2z{\7k\2\2{|\7p\2\2|}\7v\2\2}\30\3\2\2"+
		"\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7r\2\2\u0081\u0082\7w\2\2"+
		"\u0082\u0083\7v\2\2\u0083\32\3\2\2\2\u0084\u0085\7t\2\2\u0085\u0086\7"+
		"g\2\2\u0086\u0087\7v\2\2\u0087\u0088\7w\2\2\u0088\u0089\7t\2\2\u0089\u008a"+
		"\7p\2\2\u008a\34\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7h\2\2\u008d\36"+
		"\3\2\2\2\u008e\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091"+
		"\u0092\7g\2\2\u0092 \3\2\2\2\u0093\u0094\7y\2\2\u0094\u0095\7j\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098\"\3\2\2\2\u0099"+
		"\u009a\7]\2\2\u009a$\3\2\2\2\u009b\u009c\7_\2\2\u009c&\3\2\2\2\u009d\u009e"+
		"\7\60\2\2\u009e(\3\2\2\2\u009f\u00a0\7/\2\2\u00a0*\3\2\2\2\u00a1\u00a2"+
		"\7#\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7,\2\2\u00a4.\3\2\2\2\u00a5\u00a6\7"+
		"\61\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7\'\2\2\u00a8\62\3\2\2\2\u00a9\u00aa"+
		"\7-\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac\66\3\2\2\2\u00ad\u00ae"+
		"\7@\2\2\u00ae\u00af\7?\2\2\u00af8\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1:\3"+
		"\2\2\2\u00b2\u00b3\7>\2\2\u00b3\u00b4\7?\2\2\u00b4<\3\2\2\2\u00b5\u00b6"+
		"\7#\2\2\u00b6\u00b7\7?\2\2\u00b7>\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9\u00ba"+
		"\7?\2\2\u00ba@\3\2\2\2\u00bb\u00bc\7(\2\2\u00bc\u00bd\7(\2\2\u00bdB\3"+
		"\2\2\2\u00be\u00bf\7~\2\2\u00bf\u00c0\7~\2\2\u00c0D\3\2\2\2\u00c1\u00c2"+
		"\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7v\2\2\u00c4F\3\2\2\2\u00c5\u00c6"+
		"\7f\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7d\2\2\u00c9"+
		"\u00ca\7n\2\2\u00ca\u00cb\7g\2\2\u00cbH\3\2\2\2\u00cc\u00cd\7e\2\2\u00cd"+
		"\u00ce\7j\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7t\2\2\u00d0J\3\2\2\2\u00d1"+
		"\u00d2\7u\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7w\2\2"+
		"\u00d5\u00d6\7e\2\2\u00d6\u00d7\7v\2\2\u00d7L\3\2\2\2\u00d8\u00da\t\2"+
		"\2\2\u00d9\u00db\7/\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\5W,\2\u00ddN\3\2\2\2\u00de\u00df\t\3\2\2\u00df"+
		"P\3\2\2\2\u00e0\u00e2\t\4\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\b)\2\2\u00e6R\3\2\2\2\u00e7\u00eb\7%\2\2\u00e8\u00ea\13\2\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\t\5\2\2\u00ef\u00ee\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b*\2\2\u00f2T\3\2\2\2\u00f3\u00f4"+
		"\7$\2\2\u00f4\u00f5\7$\2\2\u00f5\u00f6\7$\2\2\u00f6\u00fa\3\2\2\2\u00f7"+
		"\u00f9\13\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00fb\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\7$\2\2\u00fe\u00ff\7$\2\2\u00ff\u0100\7$\2\2\u0100\u0101\3\2\2"+
		"\2\u0101\u0102\b+\2\2\u0102V\3\2\2\2\u0103\u010c\7\62\2\2\u0104\u0108"+
		"\t\6\2\2\u0105\u0107\t\7\2\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u0103\3\2\2\2\u010b\u0104\3\2\2\2\u010cX\3\2\2\2\u010d\u010e"+
		"\5W,\2\u010e\u010f\7\60\2\2\u010f\u0111\5W,\2\u0110\u0112\5M\'\2\u0111"+
		"\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u011e\3\2\2\2\u0113\u0114\5W"+
		",\2\u0114\u0115\5M\'\2\u0115\u011e\3\2\2\2\u0116\u0117\5W,\2\u0117\u0119"+
		"\7\60\2\2\u0118\u011a\5M\'\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011e\3\2\2\2\u011b\u011c\7\60\2\2\u011c\u011e\5W,\2\u011d\u010d\3\2"+
		"\2\2\u011d\u0113\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u011b\3\2\2\2\u011e"+
		"Z\3\2\2\2\u011f\u0120\7)\2\2\u0120\u0121\13\2\2\2\u0121\u012e\7)\2\2\u0122"+
		"\u0123\7)\2\2\u0123\u0124\7^\2\2\u0124\u0125\3\2\2\2\u0125\u0126\t\b\2"+
		"\2\u0126\u012e\7)\2\2\u0127\u0128\7)\2\2\u0128\u0129\7^\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012b\5W,\2\u012b\u012c\7)\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u011f\3\2\2\2\u012d\u0122\3\2\2\2\u012d\u0127\3\2\2\2\u012e\\\3\2\2\2"+
		"\u012f\u0132\5O(\2\u0130\u0132\7a\2\2\u0131\u012f\3\2\2\2\u0131\u0130"+
		"\3\2\2\2\u0132\u0137\3\2\2\2\u0133\u0136\5O(\2\u0134\u0136\t\t\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138^\3\2\2\2\u0139\u0137\3\2\2\2\21\2\u00da"+
		"\u00e3\u00eb\u00ef\u00fa\u0108\u010b\u0111\u0119\u011d\u012d\u0131\u0135"+
		"\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}