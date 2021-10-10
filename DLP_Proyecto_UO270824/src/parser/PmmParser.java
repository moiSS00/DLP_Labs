// Generated from C:/Users/Moises/Desktop/UNIVERSIDAD/TERCERO/2 CUATRIMESTRE/DLP/Laboratorio/DLP_Proyecto_UO270824/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

import ast.*;
import errorhandler.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_mainFunction = 2, RULE_functionDefinition = 3, 
		RULE_parameters = 4, RULE_variableDefinition = 5, RULE_ids = 6, RULE_functionInvocation = 7, 
		RULE_expressions = 8, RULE_statement = 9, RULE_body = 10, RULE_expression = 11, 
		RULE_type = 12, RULE_builtIntype = 13, RULE_complexType = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "mainFunction", "functionDefinition", "parameters", 
			"variableDefinition", "ids", "functionInvocation", "expressions", "statement", 
			"body", "expression", "type", "builtIntype", "complexType"
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

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionContext df;
		public MainFunctionContext mf;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			            List<Definition> definitions = new ArrayList<Definition>();
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					((ProgramContext)_localctx).df = definition();
					definitions.addAll(((ProgramContext)_localctx).df.ast);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(39);
			((ProgramContext)_localctx).mf = mainFunction();
			definitions.add(((ProgramContext)_localctx).mf.ast);
			setState(41);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(0,0,definitions);
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

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast;
		public FunctionDefinitionContext fd;
		public VariableDefinitionContext vd;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{

			            List<Definition> definitions = new ArrayList<Definition>();
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(45);
				((DefinitionContext)_localctx).fd = functionDefinition();
				definitions.add(((DefinitionContext)_localctx).fd.ast);
				}
				break;
			case ID:
				{
				setState(48);
				((DefinitionContext)_localctx).vd = variableDefinition();
				definitions.addAll(((DefinitionContext)_localctx).vd.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((DefinitionContext)_localctx).ast =  definitions;
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

	public static class MainFunctionContext extends ParserRuleContext {
		public FunctDefinition ast;
		public Token MAIN;
		public VariableDefinitionContext vd;
		public StatementContext st;
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterMainFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitMainFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitMainFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainFunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__0);
			setState(56);
			((MainFunctionContext)_localctx).MAIN = match(T__1);
			setState(57);
			match(T__2);
			setState(58);
			match(T__3);
			setState(59);
			match(T__4);
			setState(60);
			match(T__5);

			            List<Statement> body = new ArrayList<Statement>();
			            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
			            Type returnType = new VoidType();
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					((MainFunctionContext)_localctx).vd = variableDefinition();
					 body.addAll(((MainFunctionContext)_localctx).vd.ast); 
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(70);
				((MainFunctionContext)_localctx).st = statement();
				 body.add(((MainFunctionContext)_localctx).st.ast); 
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__6);
			 ((MainFunctionContext)_localctx).ast =  new FunctDefinition(((MainFunctionContext)_localctx).MAIN.getLine(), ((MainFunctionContext)_localctx).MAIN.getCharPositionInLine() + 1,
			            new FunctType(((MainFunctionContext)_localctx).MAIN.getLine(), ((MainFunctionContext)_localctx).MAIN.getCharPositionInLine() + 1, parameters, returnType),
			            (((MainFunctionContext)_localctx).MAIN!=null?((MainFunctionContext)_localctx).MAIN.getText():null), body); 
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctDefinition ast;
		public Token ID;
		public ParametersContext param;
		public BuiltIntypeContext returnType;
		public VariableDefinitionContext vd;
		public StatementContext st;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public BuiltIntypeContext builtIntype() {
			return getRuleContext(BuiltIntypeContext.class,0);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__0);
			setState(82);
			((FunctionDefinitionContext)_localctx).ID = match(ID);

			            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
			            List<Statement> body = new ArrayList<Statement>();
			            Type returnType = new VoidType(); 
			setState(84);
			match(T__2);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(85);
				((FunctionDefinitionContext)_localctx).param = parameters();
				parameters.addAll(((FunctionDefinitionContext)_localctx).param.ast);
				}
			}

			setState(90);
			match(T__3);
			setState(91);
			match(T__4);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				setState(92);
				((FunctionDefinitionContext)_localctx).returnType = builtIntype();
				returnType = ((FunctionDefinitionContext)_localctx).returnType.ast;
				}
			}

			setState(97);
			match(T__5);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					((FunctionDefinitionContext)_localctx).vd = variableDefinition();
					 body.addAll(((FunctionDefinitionContext)_localctx).vd.ast); 
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(106);
				((FunctionDefinitionContext)_localctx).st = statement();
				body.add(((FunctionDefinitionContext)_localctx).st.ast); 
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__6);
			 ((FunctionDefinitionContext)_localctx).ast =  new FunctDefinition(
			            ((FunctionDefinitionContext)_localctx).ID.getLine(), ((FunctionDefinitionContext)_localctx).ID.getCharPositionInLine() + 1,
			            new FunctType(((FunctionDefinitionContext)_localctx).ID.getLine(), ((FunctionDefinitionContext)_localctx).ID.getCharPositionInLine() + 1, parameters, returnType),
			            (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null),body);
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

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast;
		public Token id1;
		public BuiltIntypeContext bt1;
		public Token id2;
		public BuiltIntypeContext bt2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<BuiltIntypeContext> builtIntype() {
			return getRuleContexts(BuiltIntypeContext.class);
		}
		public BuiltIntypeContext builtIntype(int i) {
			return getRuleContext(BuiltIntypeContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((ParametersContext)_localctx).id1 = match(ID);
			setState(118);
			match(T__4);
			setState(119);
			((ParametersContext)_localctx).bt1 = builtIntype();

			            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
			            parameters.add(new VarDefinition(((ParametersContext)_localctx).id1.getLine(), ((ParametersContext)_localctx).id1.getCharPositionInLine() + 1,
			            ((ParametersContext)_localctx).bt1.ast, (((ParametersContext)_localctx).id1!=null?((ParametersContext)_localctx).id1.getText():null)));
			            
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(121);
				match(T__7);
				setState(122);
				((ParametersContext)_localctx).id2 = match(ID);
				setState(123);
				match(T__4);
				setState(124);
				((ParametersContext)_localctx).bt2 = builtIntype();

				            parameters.add(new VarDefinition(((ParametersContext)_localctx).id2.getLine(), ((ParametersContext)_localctx).id2.getCharPositionInLine() + 1,
				            ((ParametersContext)_localctx).bt2.ast, (((ParametersContext)_localctx).id2!=null?((ParametersContext)_localctx).id2.getText():null)));
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((ParametersContext)_localctx).ast =  parameters;
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

	public static class VariableDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast;
		public IdsContext ids;
		public TypeContext tp;
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((VariableDefinitionContext)_localctx).ids = ids();
			setState(135);
			match(T__4);
			setState(136);
			((VariableDefinitionContext)_localctx).tp = type();
			setState(137);
			match(T__8);

			            List<VarDefinition> definitions = new ArrayList<VarDefinition>();
			            for(Variable var : ((VariableDefinitionContext)_localctx).ids.ast) {
			                definitions.add(new VarDefinition(var.getLine(), var.getColumn(), ((VariableDefinitionContext)_localctx).tp.ast, var.getName()));
			            } ((VariableDefinitionContext)_localctx).ast =  definitions;
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

	public static class IdsContext extends ParserRuleContext {
		public List<Variable> ast;
		public Token id1;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitIds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((IdsContext)_localctx).id1 = match(ID);

			             List<Variable> variables = new ArrayList<Variable>();
			            variables.add(new Variable(((IdsContext)_localctx).id1.getLine(), ((IdsContext)_localctx).id1.getCharPositionInLine() + 1, (((IdsContext)_localctx).id1!=null?((IdsContext)_localctx).id1.getText():null)));
			            
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(142);
				match(T__7);
				setState(143);
				((IdsContext)_localctx).id2 = match(ID);

				            variables.add(new Variable(((IdsContext)_localctx).id2.getLine(), ((IdsContext)_localctx).id2.getCharPositionInLine() + 1, (((IdsContext)_localctx).id2!=null?((IdsContext)_localctx).id2.getText():null)));
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((IdsContext)_localctx).ast =  variables; 
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

	public static class FunctionInvocationContext extends ParserRuleContext {
		public FunctInvocation ast;
		public Token ID;
		public ExpressionsContext arg;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((FunctionInvocationContext)_localctx).ID = match(ID);
			 List<Expression> expressions =
			            new ArrayList<Expression>(); 
			setState(154);
			match(T__2);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__19) | (1L << T__20) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				setState(155);
				((FunctionInvocationContext)_localctx).arg = expressions();
				 expressions = ((FunctionInvocationContext)_localctx).arg.ast;
				}
			}

			setState(160);
			match(T__3);

			            Variable name = new Variable(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine(), (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null));
			            ((FunctionInvocationContext)_localctx).ast =  new FunctInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine() + 1,
			            name, expressions);
			            
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

	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((ExpressionsContext)_localctx).exp1 = expression(0);

			            List<Expression> expressions = new ArrayList<Expression>();
			            expressions.add(((ExpressionsContext)_localctx).exp1.ast); 
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(165);
				match(T__7);
				setState(166);
				((ExpressionsContext)_localctx).exp2 = expression(0);

				            expressions.add(((ExpressionsContext)_localctx).exp2.ast);
				            
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((ExpressionsContext)_localctx).ast =  expressions;
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

	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public Token PRINT;
		public ExpressionsContext exps;
		public Token INPUT;
		public Token RETURN;
		public ExpressionContext exp;
		public Token IF;
		public ExpressionContext condition;
		public BodyContext bd1;
		public BodyContext bd2;
		public Token WHILE;
		public BodyContext bd;
		public FunctionInvocationContext fi;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((StatementContext)_localctx).left = expression(0);
				setState(177);
				match(T__9);
				setState(178);
				((StatementContext)_localctx).right = expression(0);
				setState(179);
				match(T__8);

				            ((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).left.ast.getLine(),((StatementContext)_localctx).left.ast.getColumn(),
				            ((StatementContext)_localctx).left.ast,((StatementContext)_localctx).right.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				((StatementContext)_localctx).PRINT = match(T__10);
				setState(183);
				((StatementContext)_localctx).exps = expressions();
				setState(184);
				match(T__8);

				            ((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).PRINT.getLine(), ((StatementContext)_localctx).PRINT.getCharPositionInLine(), ((StatementContext)_localctx).exps.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				((StatementContext)_localctx).INPUT = match(T__11);
				setState(188);
				((StatementContext)_localctx).exps = expressions();
				setState(189);
				match(T__8);

				            ((StatementContext)_localctx).ast =  new Input(((StatementContext)_localctx).INPUT.getLine(), ((StatementContext)_localctx).INPUT.getCharPositionInLine(), ((StatementContext)_localctx).exps.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				((StatementContext)_localctx).RETURN = match(T__12);
				setState(193);
				((StatementContext)_localctx).exp = expression(0);
				setState(194);
				match(T__8);

				            ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).RETURN.getLine(), ((StatementContext)_localctx).RETURN.getCharPositionInLine() + 1, ((StatementContext)_localctx).exp.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				List<Statement> elseBody = new ArrayList<Statement>();
				setState(198);
				((StatementContext)_localctx).IF = match(T__13);
				setState(199);
				((StatementContext)_localctx).condition = expression(0);
				setState(200);
				match(T__4);
				setState(201);
				((StatementContext)_localctx).bd1 = body();
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(202);
					match(T__14);
					setState(203);
					((StatementContext)_localctx).bd2 = body();
					elseBody = ((StatementContext)_localctx).bd2.ast;
					}
					break;
				}

				            ((StatementContext)_localctx).ast =  new Conditional(((StatementContext)_localctx).IF.getLine(), ((StatementContext)_localctx).IF.getCharPositionInLine() + 1,
				            ((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).bd1.ast, elseBody); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(210);
				((StatementContext)_localctx).WHILE = match(T__15);
				setState(211);
				((StatementContext)_localctx).condition = expression(0);
				setState(212);
				match(T__4);
				setState(213);
				((StatementContext)_localctx).bd = body();

				            ((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).WHILE.getLine(), ((StatementContext)_localctx).WHILE.getCharPositionInLine() + 1,
				            ((StatementContext)_localctx).condition.ast, ((StatementContext)_localctx).bd.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(216);
				((StatementContext)_localctx).fi = functionInvocation();
				setState(217);
				match(T__8);
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).fi.ast; 
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

	public static class BodyContext extends ParserRuleContext {
		public List<Statement> ast;
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		int _la;
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(T__5);
				List<Statement> body = new ArrayList<Statement>();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
					{
					{
					setState(224);
					((BodyContext)_localctx).st1 = statement();
					body.add(((BodyContext)_localctx).st1.ast);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(T__6);
				((BodyContext)_localctx).ast =  body;
				}
				break;
			case T__2:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
			case T__19:
			case T__20:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				((BodyContext)_localctx).st2 = statement();
				List<Statement> body = new ArrayList<Statement>();
				            body.add(((BodyContext)_localctx).st2.ast);((BodyContext)_localctx).ast =  body;
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp;
		public ExpressionContext left;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token ID;
		public FunctionInvocationContext fi;
		public BuiltIntypeContext castTo;
		public Token OP;
		public ExpressionContext right;
		public ExpressionContext index;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BuiltIntypeContext builtIntype() {
			return getRuleContext(BuiltIntypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(240);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 2:
				{
				setState(242);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			case 3:
				{
				setState(244);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				            ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			case 4:
				{
				setState(246);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 5:
				{
				setState(248);
				((ExpressionContext)_localctx).fi = functionInvocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast; 
				}
				break;
			case 6:
				{
				setState(251);
				match(T__2);
				setState(252);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(253);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast;
				}
				break;
			case 7:
				{
				setState(256);
				match(T__2);
				setState(257);
				((ExpressionContext)_localctx).castTo = builtIntype();
				setState(258);
				match(T__3);
				setState(259);
				((ExpressionContext)_localctx).exp = expression(7);

				            ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).castTo.ast.getLine(), ((ExpressionContext)_localctx).castTo.ast.getColumn(),
				            ((ExpressionContext)_localctx).castTo.ast, ((ExpressionContext)_localctx).exp.ast);
				}
				break;
			case 8:
				{
				setState(262);
				match(T__19);
				setState(263);
				((ExpressionContext)_localctx).exp = expression(6);

				            ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(),
				            ((ExpressionContext)_localctx).exp.ast);
				}
				break;
			case 9:
				{
				setState(266);
				match(T__20);
				setState(267);
				((ExpressionContext)_localctx).exp = expression(5);

				            ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(),
				            ((ExpressionContext)_localctx).exp.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(302);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(273);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(274);
						((ExpressionContext)_localctx).right = expression(5);

						                      ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(),
						                      ((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__24) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(279);
						((ExpressionContext)_localctx).right = expression(4);

						                      ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(),
						                      ((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(283);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						((ExpressionContext)_localctx).right = expression(3);

						                      ((ExpressionContext)_localctx).ast =  new LogicalCondition(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(),
						                      ((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(287);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(288);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(289);
						((ExpressionContext)_localctx).right = expression(2);

						                      ((ExpressionContext)_localctx).ast =  new BooleanCondition(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(),
						                      ((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(293);
						match(T__16);
						setState(294);
						((ExpressionContext)_localctx).index = expression(0);
						setState(295);
						match(T__17);

						                      ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(),
						                      ((ExpressionContext)_localctx).exp.ast, ((ExpressionContext)_localctx).index.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(299);
						match(T__18);
						setState(300);
						((ExpressionContext)_localctx).ID = match(ID);

						                      ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(),
						                      ((ExpressionContext)_localctx).exp.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public BuiltIntypeContext bt;
		public ComplexTypeContext ct;
		public BuiltIntypeContext builtIntype() {
			return getRuleContext(BuiltIntypeContext.class,0);
		}
		public ComplexTypeContext complexType() {
			return getRuleContext(ComplexTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(307);
				((TypeContext)_localctx).bt = builtIntype();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bt.ast;
				}
				break;
			case T__16:
			case T__36:
				{
				setState(310);
				((TypeContext)_localctx).ct = complexType();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).ct.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class BuiltIntypeContext extends ParserRuleContext {
		public Type ast;
		public Token INT;
		public Token DOUBLE;
		public Token CHAR;
		public BuiltIntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtIntype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBuiltIntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBuiltIntype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBuiltIntype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltIntypeContext builtIntype() throws RecognitionException {
		BuiltIntypeContext _localctx = new BuiltIntypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_builtIntype);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				((BuiltIntypeContext)_localctx).INT = match(T__33);
				 ((BuiltIntypeContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				((BuiltIntypeContext)_localctx).DOUBLE = match(T__34);
				 ((BuiltIntypeContext)_localctx).ast =  new DoubleType(); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				((BuiltIntypeContext)_localctx).CHAR = match(T__35);
				 ((BuiltIntypeContext)_localctx).ast =  new CharType(); 
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

	public static class ComplexTypeContext extends ParserRuleContext {
		public Type ast;
		public Token STRUCT;
		public VariableDefinitionContext fds;
		public Token INT_CONSTANT;
		public TypeContext tp;
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ComplexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterComplexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitComplexType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitComplexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexTypeContext complexType() throws RecognitionException {
		ComplexTypeContext _localctx = new ComplexTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_complexType);
		int _la;
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((ComplexTypeContext)_localctx).STRUCT = match(T__36);
				setState(324);
				match(T__5);

				            List<RecordField> fields = new ArrayList<RecordField>(); 
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(326);
					((ComplexTypeContext)_localctx).fds = variableDefinition();

					            for(VarDefinition vr : ((ComplexTypeContext)_localctx).fds.ast) {
					                for (RecordField rf : fields) {
					                    if (rf.getName().equals(vr.getName())) {
					                        new ErrorType(vr.getLine(),vr.getColumn(),
					                        "Campo '" + rf.getName() + "' duplicado en el struct.");
					                        break;
					                    }
					                }
					                RecordField field = new RecordField(vr.getLine(), vr.getColumn(),
					                    vr.getName(), vr.getType());
					                fields.add(field);
					            }
					            
					}
					}
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				((ComplexTypeContext)_localctx).ast =  new StructType(
				            ((ComplexTypeContext)_localctx).STRUCT.getLine(), ((ComplexTypeContext)_localctx).STRUCT.getCharPositionInLine() + 1, fields);
				setState(335);
				match(T__6);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				match(T__16);
				setState(337);
				((ComplexTypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(338);
				match(T__17);
				setState(339);
				((ComplexTypeContext)_localctx).tp = type();
				 ((ComplexTypeContext)_localctx).ast =  new ArrayType(
				            ((ComplexTypeContext)_localctx).INT_CONSTANT.getLine(), ((ComplexTypeContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1,
				            ((ComplexTypeContext)_localctx).tp.ast,  LexerHelper.lexemeToInt((((ComplexTypeContext)_localctx).INT_CONSTANT!=null?((ComplexTypeContext)_localctx).INT_CONSTANT.getText():null)));
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u015b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\7\2"+
		"%\n\2\f\2\16\2(\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\66\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4D\n\4\f\4"+
		"\16\4G\13\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5[\n\5\3\5\3\5\3\5\3\5\3\5\5\5b\n\5\3\5\3\5\3\5\3"+
		"\5\7\5h\n\5\f\5\16\5k\13\5\3\5\3\5\3\5\7\5p\n\5\f\5\16\5s\13\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u0094\n"+
		"\b\f\b\16\b\u0097\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a1\n\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ac\n\n\f\n\16\n\u00af\13\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00d1\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00df\n\13\3\f\3\f\3\f\3\f\3\f\7\f\u00e6\n\f"+
		"\f\f\16\f\u00e9\13\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f0\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0111\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0131\n\r\f\r\16\r\u0134\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u013c\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0144\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u014c\n\20\f\20\16"+
		"\20\u014f\13\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0159\n\20"+
		"\3\20\2\3\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3\2\30\32\4"+
		"\2\26\26\33\33\3\2\34!\3\2\"#\2\u0173\2 \3\2\2\2\4.\3\2\2\2\69\3\2\2\2"+
		"\bS\3\2\2\2\nw\3\2\2\2\f\u0088\3\2\2\2\16\u008e\3\2\2\2\20\u009a\3\2\2"+
		"\2\22\u00a5\3\2\2\2\24\u00de\3\2\2\2\26\u00ef\3\2\2\2\30\u0110\3\2\2\2"+
		"\32\u013b\3\2\2\2\34\u0143\3\2\2\2\36\u0158\3\2\2\2 &\b\2\1\2!\"\5\4\3"+
		"\2\"#\b\2\1\2#%\3\2\2\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3"+
		"\2\2\2(&\3\2\2\2)*\5\6\4\2*+\b\2\1\2+,\7\2\2\3,-\b\2\1\2-\3\3\2\2\2.\65"+
		"\b\3\1\2/\60\5\b\5\2\60\61\b\3\1\2\61\66\3\2\2\2\62\63\5\f\7\2\63\64\b"+
		"\3\1\2\64\66\3\2\2\2\65/\3\2\2\2\65\62\3\2\2\2\66\67\3\2\2\2\678\b\3\1"+
		"\28\5\3\2\2\29:\7\3\2\2:;\7\4\2\2;<\7\5\2\2<=\7\6\2\2=>\7\7\2\2>?\7\b"+
		"\2\2?E\b\4\1\2@A\5\f\7\2AB\b\4\1\2BD\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2FM\3\2\2\2GE\3\2\2\2HI\5\24\13\2IJ\b\4\1\2JL\3\2\2\2KH\3"+
		"\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\t\2\2QR\b"+
		"\4\1\2R\7\3\2\2\2ST\7\3\2\2TU\7.\2\2UV\b\5\1\2VZ\7\5\2\2WX\5\n\6\2XY\b"+
		"\5\1\2Y[\3\2\2\2ZW\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\6\2\2]a\7\7\2\2^"+
		"_\5\34\17\2_`\b\5\1\2`b\3\2\2\2a^\3\2\2\2ab\3\2\2\2bc\3\2\2\2ci\7\b\2"+
		"\2de\5\f\7\2ef\b\5\1\2fh\3\2\2\2gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2"+
		"\2jq\3\2\2\2ki\3\2\2\2lm\5\24\13\2mn\b\5\1\2np\3\2\2\2ol\3\2\2\2ps\3\2"+
		"\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\t\2\2uv\b\5\1\2v\t\3"+
		"\2\2\2wx\7.\2\2xy\7\7\2\2yz\5\34\17\2z\u0083\b\6\1\2{|\7\n\2\2|}\7.\2"+
		"\2}~\7\7\2\2~\177\5\34\17\2\177\u0080\b\6\1\2\u0080\u0082\3\2\2\2\u0081"+
		"{\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2"+
		"\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\b\6\1\2\u0087\13"+
		"\3\2\2\2\u0088\u0089\5\16\b\2\u0089\u008a\7\7\2\2\u008a\u008b\5\32\16"+
		"\2\u008b\u008c\7\13\2\2\u008c\u008d\b\7\1\2\u008d\r\3\2\2\2\u008e\u008f"+
		"\7.\2\2\u008f\u0095\b\b\1\2\u0090\u0091\7\n\2\2\u0091\u0092\7.\2\2\u0092"+
		"\u0094\b\b\1\2\u0093\u0090\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\b\b\1\2\u0099\17\3\2\2\2\u009a\u009b\7.\2\2\u009b\u009c\b\t\1\2"+
		"\u009c\u00a0\7\5\2\2\u009d\u009e\5\22\n\2\u009e\u009f\b\t\1\2\u009f\u00a1"+
		"\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\7\6\2\2\u00a3\u00a4\b\t\1\2\u00a4\21\3\2\2\2\u00a5\u00a6\5\30\r"+
		"\2\u00a6\u00ad\b\n\1\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\5\30\r\2\u00a9"+
		"\u00aa\b\n\1\2\u00aa\u00ac\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\u00af\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\b\n\1\2\u00b1\23\3\2\2\2\u00b2\u00b3\5\30\r"+
		"\2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\5\30\r\2\u00b5\u00b6\7\13\2\2\u00b6"+
		"\u00b7\b\13\1\2\u00b7\u00df\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9\u00ba\5"+
		"\22\n\2\u00ba\u00bb\7\13\2\2\u00bb\u00bc\b\13\1\2\u00bc\u00df\3\2\2\2"+
		"\u00bd\u00be\7\16\2\2\u00be\u00bf\5\22\n\2\u00bf\u00c0\7\13\2\2\u00c0"+
		"\u00c1\b\13\1\2\u00c1\u00df\3\2\2\2\u00c2\u00c3\7\17\2\2\u00c3\u00c4\5"+
		"\30\r\2\u00c4\u00c5\7\13\2\2\u00c5\u00c6\b\13\1\2\u00c6\u00df\3\2\2\2"+
		"\u00c7\u00c8\b\13\1\2\u00c8\u00c9\7\20\2\2\u00c9\u00ca\5\30\r\2\u00ca"+
		"\u00cb\7\7\2\2\u00cb\u00d0\5\26\f\2\u00cc\u00cd\7\21\2\2\u00cd\u00ce\5"+
		"\26\f\2\u00ce\u00cf\b\13\1\2\u00cf\u00d1\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\13\1\2\u00d3\u00df\3"+
		"\2\2\2\u00d4\u00d5\7\22\2\2\u00d5\u00d6\5\30\r\2\u00d6\u00d7\7\7\2\2\u00d7"+
		"\u00d8\5\26\f\2\u00d8\u00d9\b\13\1\2\u00d9\u00df\3\2\2\2\u00da\u00db\5"+
		"\20\t\2\u00db\u00dc\7\13\2\2\u00dc\u00dd\b\13\1\2\u00dd\u00df\3\2\2\2"+
		"\u00de\u00b2\3\2\2\2\u00de\u00b8\3\2\2\2\u00de\u00bd\3\2\2\2\u00de\u00c2"+
		"\3\2\2\2\u00de\u00c7\3\2\2\2\u00de\u00d4\3\2\2\2\u00de\u00da\3\2\2\2\u00df"+
		"\25\3\2\2\2\u00e0\u00e1\7\b\2\2\u00e1\u00e7\b\f\1\2\u00e2\u00e3\5\24\13"+
		"\2\u00e3\u00e4\b\f\1\2\u00e4\u00e6\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\u00e9"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00eb\7\t\2\2\u00eb\u00f0\b\f\1\2\u00ec\u00ed\5\24"+
		"\13\2\u00ed\u00ee\b\f\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00e0\3\2\2\2\u00ef"+
		"\u00ec\3\2\2\2\u00f0\27\3\2\2\2\u00f1\u00f2\b\r\1\2\u00f2\u00f3\7+\2\2"+
		"\u00f3\u0111\b\r\1\2\u00f4\u00f5\7,\2\2\u00f5\u0111\b\r\1\2\u00f6\u00f7"+
		"\7-\2\2\u00f7\u0111\b\r\1\2\u00f8\u00f9\7.\2\2\u00f9\u0111\b\r\1\2\u00fa"+
		"\u00fb\5\20\t\2\u00fb\u00fc\b\r\1\2\u00fc\u0111\3\2\2\2\u00fd\u00fe\7"+
		"\5\2\2\u00fe\u00ff\5\30\r\2\u00ff\u0100\7\6\2\2\u0100\u0101\b\r\1\2\u0101"+
		"\u0111\3\2\2\2\u0102\u0103\7\5\2\2\u0103\u0104\5\34\17\2\u0104\u0105\7"+
		"\6\2\2\u0105\u0106\5\30\r\t\u0106\u0107\b\r\1\2\u0107\u0111\3\2\2\2\u0108"+
		"\u0109\7\26\2\2\u0109\u010a\5\30\r\b\u010a\u010b\b\r\1\2\u010b\u0111\3"+
		"\2\2\2\u010c\u010d\7\27\2\2\u010d\u010e\5\30\r\7\u010e\u010f\b\r\1\2\u010f"+
		"\u0111\3\2\2\2\u0110\u00f1\3\2\2\2\u0110\u00f4\3\2\2\2\u0110\u00f6\3\2"+
		"\2\2\u0110\u00f8\3\2\2\2\u0110\u00fa\3\2\2\2\u0110\u00fd\3\2\2\2\u0110"+
		"\u0102\3\2\2\2\u0110\u0108\3\2\2\2\u0110\u010c\3\2\2\2\u0111\u0132\3\2"+
		"\2\2\u0112\u0113\f\6\2\2\u0113\u0114\t\2\2\2\u0114\u0115\5\30\r\7\u0115"+
		"\u0116\b\r\1\2\u0116\u0131\3\2\2\2\u0117\u0118\f\5\2\2\u0118\u0119\t\3"+
		"\2\2\u0119\u011a\5\30\r\6\u011a\u011b\b\r\1\2\u011b\u0131\3\2\2\2\u011c"+
		"\u011d\f\4\2\2\u011d\u011e\t\4\2\2\u011e\u011f\5\30\r\5\u011f\u0120\b"+
		"\r\1\2\u0120\u0131\3\2\2\2\u0121\u0122\f\3\2\2\u0122\u0123\t\5\2\2\u0123"+
		"\u0124\5\30\r\4\u0124\u0125\b\r\1\2\u0125\u0131\3\2\2\2\u0126\u0127\f"+
		"\13\2\2\u0127\u0128\7\23\2\2\u0128\u0129\5\30\r\2\u0129\u012a\7\24\2\2"+
		"\u012a\u012b\b\r\1\2\u012b\u0131\3\2\2\2\u012c\u012d\f\n\2\2\u012d\u012e"+
		"\7\25\2\2\u012e\u012f\7.\2\2\u012f\u0131\b\r\1\2\u0130\u0112\3\2\2\2\u0130"+
		"\u0117\3\2\2\2\u0130\u011c\3\2\2\2\u0130\u0121\3\2\2\2\u0130\u0126\3\2"+
		"\2\2\u0130\u012c\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\31\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5\34\17"+
		"\2\u0136\u0137\b\16\1\2\u0137\u013c\3\2\2\2\u0138\u0139\5\36\20\2\u0139"+
		"\u013a\b\16\1\2\u013a\u013c\3\2\2\2\u013b\u0135\3\2\2\2\u013b\u0138\3"+
		"\2\2\2\u013c\33\3\2\2\2\u013d\u013e\7$\2\2\u013e\u0144\b\17\1\2\u013f"+
		"\u0140\7%\2\2\u0140\u0144\b\17\1\2\u0141\u0142\7&\2\2\u0142\u0144\b\17"+
		"\1\2\u0143\u013d\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0141\3\2\2\2\u0144"+
		"\35\3\2\2\2\u0145\u0146\7\'\2\2\u0146\u0147\7\b\2\2\u0147\u014d\b\20\1"+
		"\2\u0148\u0149\5\f\7\2\u0149\u014a\b\20\1\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0148\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\b\20\1\2\u0151"+
		"\u0159\7\t\2\2\u0152\u0153\7\23\2\2\u0153\u0154\7+\2\2\u0154\u0155\7\24"+
		"\2\2\u0155\u0156\5\32\16\2\u0156\u0157\b\20\1\2\u0157\u0159\3\2\2\2\u0158"+
		"\u0145\3\2\2\2\u0158\u0152\3\2\2\2\u0159\37\3\2\2\2\31&\65EMZaiq\u0083"+
		"\u0095\u00a0\u00ad\u00d0\u00de\u00e7\u00ef\u0110\u0130\u0132\u013b\u0143"+
		"\u014d\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}