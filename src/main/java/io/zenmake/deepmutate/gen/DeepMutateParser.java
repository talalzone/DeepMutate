// Generated from java-escape by ANTLR 4.11.1
package io.zenmake.deepmutate.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DeepMutateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FROM=1, MUTATE=2, MATCH=3, WHERE=4, SET=5, INSERT=6, REPLACE=7, DEFINE=8, 
		TYPE=9, ANALYZE=10, REPORT=11, CONSOLE=12, URI=13, LANG=14, DIR=15, PATH=16, 
		FILE=17, CODE=18, OUTPUT=19, DATASTORE=20, DB=21, USER=22, PASS=23, ACTIVE=24, 
		BUILD=25, RIGHT_ARROW=26, SEMICOLON=27, PIPE=28, QM=29, COLON=30, RANGE=31, 
		COMMA=32, LRB=33, RRB=34, LSB=35, RSB=36, LCB=37, RCB=38, AND=39, OR=40, 
		NOT=41, EQ=42, NE=43, LT=44, LTE=45, GT=46, GTE=47, PLUS=48, MINUS=49, 
		MUL=50, DIV=51, MOD=52, BIT_AND=53, SHIFT_LEFT=54, SHIFT_RIGHT=55, ASSIGN=56, 
		SCOPE=57, ACCESS=58, REGEX_MATCH=59, REGEX_NON_MATCH=60, IDENTIFIER=61, 
		TEXT=62, STRING_LITERAL=63, DOUBLE_QUOTED_STRING_LITERAL=64, BACKSTICK_STRING_LITERAL=65, 
		BLOCK_COMMENT=66, LINE_COMMENT=67, WHITE_SPACE=68;
	public static final int
		RULE_parse = 0, RULE_projectDecl = 1, RULE_functionDecl = 2, RULE_mutationDecl = 3, 
		RULE_matchStmt = 4, RULE_whereStmt = 5, RULE_setStmt = 6, RULE_insertStmt = 7, 
		RULE_functionId = 8, RULE_mutationId = 9, RULE_pattern = 10, RULE_inputConf = 11, 
		RULE_projectConf = 12, RULE_outputConf = 13, RULE_mutationConf = 14, RULE_conf = 15, 
		RULE_strList = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "projectDecl", "functionDecl", "mutationDecl", "matchStmt", 
			"whereStmt", "setStmt", "insertStmt", "functionId", "mutationId", "pattern", 
			"inputConf", "projectConf", "outputConf", "mutationConf", "conf", "strList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'FROM'", "'MUTATE'", "'MATCH'", "'WHERE'", "'SET'", "'INSERT'", 
			"'REPLACE'", null, "'TYPE'", "'ANALYZE'", "'REPORT'", "'CONSOLE'", "'URI'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'->'", "';'", "'|'", "'?'", "':'", "'..'", "','", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'&&'", "'||'", "'!'", "'=='", "'!='", "'<'", "'<='", 
			"'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'&'", "'<<'", "'>>'", 
			"'='", "'::'", "'.'", "'=~'", "'!~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FROM", "MUTATE", "MATCH", "WHERE", "SET", "INSERT", "REPLACE", 
			"DEFINE", "TYPE", "ANALYZE", "REPORT", "CONSOLE", "URI", "LANG", "DIR", 
			"PATH", "FILE", "CODE", "OUTPUT", "DATASTORE", "DB", "USER", "PASS", 
			"ACTIVE", "BUILD", "RIGHT_ARROW", "SEMICOLON", "PIPE", "QM", "COLON", 
			"RANGE", "COMMA", "LRB", "RRB", "LSB", "RSB", "LCB", "RCB", "AND", "OR", 
			"NOT", "EQ", "NE", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "MUL", 
			"DIV", "MOD", "BIT_AND", "SHIFT_LEFT", "SHIFT_RIGHT", "ASSIGN", "SCOPE", 
			"ACCESS", "REGEX_MATCH", "REGEX_NON_MATCH", "IDENTIFIER", "TEXT", "STRING_LITERAL", 
			"DOUBLE_QUOTED_STRING_LITERAL", "BACKSTICK_STRING_LITERAL", "BLOCK_COMMENT", 
			"LINE_COMMENT", "WHITE_SPACE"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DeepMutateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DeepMutateParser.EOF, 0); }
		public List<ProjectDeclContext> projectDecl() {
			return getRuleContexts(ProjectDeclContext.class);
		}
		public ProjectDeclContext projectDecl(int i) {
			return getRuleContext(ProjectDeclContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(34);
				projectDecl();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProjectDeclContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(DeepMutateParser.FROM, 0); }
		public List<TerminalNode> LRB() { return getTokens(DeepMutateParser.LRB); }
		public TerminalNode LRB(int i) {
			return getToken(DeepMutateParser.LRB, i);
		}
		public InputConfContext inputConf() {
			return getRuleContext(InputConfContext.class,0);
		}
		public List<TerminalNode> RRB() { return getTokens(DeepMutateParser.RRB); }
		public TerminalNode RRB(int i) {
			return getToken(DeepMutateParser.RRB, i);
		}
		public TerminalNode MUTATE() { return getToken(DeepMutateParser.MUTATE, 0); }
		public ProjectConfContext projectConf() {
			return getRuleContext(ProjectConfContext.class,0);
		}
		public TerminalNode OUTPUT() { return getToken(DeepMutateParser.OUTPUT, 0); }
		public OutputConfContext outputConf() {
			return getRuleContext(OutputConfContext.class,0);
		}
		public TerminalNode LCB() { return getToken(DeepMutateParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(DeepMutateParser.RCB, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public ProjectDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterProjectDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitProjectDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitProjectDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectDeclContext projectDecl() throws RecognitionException {
		ProjectDeclContext _localctx = new ProjectDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_projectDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(FROM);
			setState(43);
			match(LRB);
			setState(44);
			inputConf();
			setState(45);
			match(RRB);
			setState(46);
			match(MUTATE);
			setState(47);
			match(LRB);
			setState(48);
			projectConf();
			setState(49);
			match(RRB);
			setState(50);
			match(OUTPUT);
			setState(51);
			match(LRB);
			setState(52);
			outputConf();
			setState(53);
			match(RRB);
			setState(54);
			match(LCB);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				{
				setState(55);
				functionDecl();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(RCB);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(DeepMutateParser.DEFINE, 0); }
		public FunctionIdContext functionId() {
			return getRuleContext(FunctionIdContext.class,0);
		}
		public TerminalNode LCB() { return getToken(DeepMutateParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(DeepMutateParser.RCB, 0); }
		public List<MutationDeclContext> mutationDecl() {
			return getRuleContexts(MutationDeclContext.class);
		}
		public MutationDeclContext mutationDecl(int i) {
			return getRuleContext(MutationDeclContext.class,i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(DEFINE);
			setState(64);
			functionId();
			setState(65);
			match(LCB);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATCH || _la==LSB) {
				{
				{
				setState(66);
				mutationDecl();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(RCB);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MutationDeclContext extends ParserRuleContext {
		public MatchStmtContext matchStmt() {
			return getRuleContext(MatchStmtContext.class,0);
		}
		public List<TerminalNode> LSB() { return getTokens(DeepMutateParser.LSB); }
		public TerminalNode LSB(int i) {
			return getToken(DeepMutateParser.LSB, i);
		}
		public MutationIdContext mutationId() {
			return getRuleContext(MutationIdContext.class,0);
		}
		public List<TerminalNode> RSB() { return getTokens(DeepMutateParser.RSB); }
		public TerminalNode RSB(int i) {
			return getToken(DeepMutateParser.RSB, i);
		}
		public MutationConfContext mutationConf() {
			return getRuleContext(MutationConfContext.class,0);
		}
		public WhereStmtContext whereStmt() {
			return getRuleContext(WhereStmtContext.class,0);
		}
		public List<SetStmtContext> setStmt() {
			return getRuleContexts(SetStmtContext.class);
		}
		public SetStmtContext setStmt(int i) {
			return getRuleContext(SetStmtContext.class,i);
		}
		public List<InsertStmtContext> insertStmt() {
			return getRuleContexts(InsertStmtContext.class);
		}
		public InsertStmtContext insertStmt(int i) {
			return getRuleContext(InsertStmtContext.class,i);
		}
		public MutationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterMutationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitMutationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitMutationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MutationDeclContext mutationDecl() throws RecognitionException {
		MutationDeclContext _localctx = new MutationDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mutationDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(74);
				match(LSB);
				setState(75);
				mutationId();
				setState(76);
				match(RSB);
				}
				break;
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(80);
				match(LSB);
				setState(81);
				mutationConf();
				setState(82);
				match(RSB);
				}
			}

			setState(86);
			matchStmt();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(87);
				whereStmt();
				}
			}

			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					setStmt();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SET );
				}
				break;
			case INSERT:
				{
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					insertStmt();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INSERT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class MatchStmtContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(DeepMutateParser.MATCH, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode COLON() { return getToken(DeepMutateParser.COLON, 0); }
		public TerminalNode LRB() { return getToken(DeepMutateParser.LRB, 0); }
		public TerminalNode RRB() { return getToken(DeepMutateParser.RRB, 0); }
		public MatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterMatchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitMatchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitMatchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchStmtContext matchStmt() throws RecognitionException {
		MatchStmtContext _localctx = new MatchStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(MATCH);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(103);
				match(COLON);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LRB) {
				{
				setState(106);
				match(LRB);
				}
			}

			setState(109);
			pattern();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RRB) {
				{
				setState(110);
				match(RRB);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereStmtContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(DeepMutateParser.WHERE, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode COLON() { return getToken(DeepMutateParser.COLON, 0); }
		public TerminalNode LRB() { return getToken(DeepMutateParser.LRB, 0); }
		public TerminalNode RRB() { return getToken(DeepMutateParser.RRB, 0); }
		public WhereStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterWhereStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitWhereStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitWhereStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereStmtContext whereStmt() throws RecognitionException {
		WhereStmtContext _localctx = new WhereStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(WHERE);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(114);
				match(COLON);
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LRB) {
				{
				setState(117);
				match(LRB);
				}
			}

			setState(120);
			pattern();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RRB) {
				{
				setState(121);
				match(RRB);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class SetStmtContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(DeepMutateParser.SET, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode COLON() { return getToken(DeepMutateParser.COLON, 0); }
		public TerminalNode LRB() { return getToken(DeepMutateParser.LRB, 0); }
		public TerminalNode RRB() { return getToken(DeepMutateParser.RRB, 0); }
		public SetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterSetStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitSetStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitSetStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetStmtContext setStmt() throws RecognitionException {
		SetStmtContext _localctx = new SetStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_setStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(SET);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(125);
				match(COLON);
				}
			}

			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LRB) {
				{
				setState(128);
				match(LRB);
				}
			}

			setState(131);
			pattern();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RRB) {
				{
				setState(132);
				match(RRB);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class InsertStmtContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(DeepMutateParser.INSERT, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode COLON() { return getToken(DeepMutateParser.COLON, 0); }
		public TerminalNode LRB() { return getToken(DeepMutateParser.LRB, 0); }
		public TerminalNode RRB() { return getToken(DeepMutateParser.RRB, 0); }
		public InsertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterInsertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitInsertStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitInsertStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStmtContext insertStmt() throws RecognitionException {
		InsertStmtContext _localctx = new InsertStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(INSERT);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(136);
				match(COLON);
				}
			}

			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LRB) {
				{
				setState(139);
				match(LRB);
				}
			}

			setState(142);
			pattern();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RRB) {
				{
				setState(143);
				match(RRB);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DeepMutateParser.IDENTIFIER, 0); }
		public FunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterFunctionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitFunctionId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitFunctionId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdContext functionId() throws RecognitionException {
		FunctionIdContext _localctx = new FunctionIdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MutationIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DeepMutateParser.IDENTIFIER, 0); }
		public MutationIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutationId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterMutationId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitMutationId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitMutationId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MutationIdContext mutationId() throws RecognitionException {
		MutationIdContext _localctx = new MutationIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mutationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(DeepMutateParser.STRING_LITERAL, 0); }
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(STRING_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputConfContext extends ParserRuleContext {
		public InputConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputConf; }
	 
		public InputConfContext() { }
		public void copyFrom(InputConfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeInputConfContext extends InputConfContext {
		public Token type;
		public Token val;
		public StrListContext list;
		public TerminalNode ASSIGN() { return getToken(DeepMutateParser.ASSIGN, 0); }
		public TerminalNode CODE() { return getToken(DeepMutateParser.CODE, 0); }
		public TerminalNode LSB() { return getToken(DeepMutateParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(DeepMutateParser.RSB, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DeepMutateParser.STRING_LITERAL, 0); }
		public StrListContext strList() {
			return getRuleContext(StrListContext.class,0);
		}
		public CodeInputConfContext(InputConfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterCodeInputConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitCodeInputConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitCodeInputConf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FileInputConfContext extends InputConfContext {
		public Token type;
		public Token val;
		public StrListContext list;
		public TerminalNode ASSIGN() { return getToken(DeepMutateParser.ASSIGN, 0); }
		public TerminalNode FILE() { return getToken(DeepMutateParser.FILE, 0); }
		public TerminalNode LSB() { return getToken(DeepMutateParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(DeepMutateParser.RSB, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DeepMutateParser.STRING_LITERAL, 0); }
		public StrListContext strList() {
			return getRuleContext(StrListContext.class,0);
		}
		public FileInputConfContext(InputConfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterFileInputConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitFileInputConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitFileInputConf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConsoleInputConfContext extends InputConfContext {
		public Token type;
		public Token val;
		public TerminalNode CONSOLE() { return getToken(DeepMutateParser.CONSOLE, 0); }
		public TerminalNode ASSIGN() { return getToken(DeepMutateParser.ASSIGN, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DeepMutateParser.STRING_LITERAL, 0); }
		public ConsoleInputConfContext(InputConfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterConsoleInputConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitConsoleInputConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitConsoleInputConf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DirInputConfContext extends InputConfContext {
		public Token type;
		public Token val;
		public StrListContext list;
		public Token build;
		public List<TerminalNode> ASSIGN() { return getTokens(DeepMutateParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(DeepMutateParser.ASSIGN, i);
		}
		public TerminalNode COMMA() { return getToken(DeepMutateParser.COMMA, 0); }
		public TerminalNode DIR() { return getToken(DeepMutateParser.DIR, 0); }
		public TerminalNode LSB() { return getToken(DeepMutateParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(DeepMutateParser.RSB, 0); }
		public TerminalNode BUILD() { return getToken(DeepMutateParser.BUILD, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(DeepMutateParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(DeepMutateParser.STRING_LITERAL, i);
		}
		public StrListContext strList() {
			return getRuleContext(StrListContext.class,0);
		}
		public DirInputConfContext(InputConfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterDirInputConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitDirInputConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitDirInputConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputConfContext inputConf() throws RecognitionException {
		InputConfContext _localctx = new InputConfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_inputConf);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSOLE:
				_localctx = new ConsoleInputConfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((ConsoleInputConfContext)_localctx).type = match(CONSOLE);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(153);
					match(ASSIGN);
					setState(154);
					((ConsoleInputConfContext)_localctx).val = match(STRING_LITERAL);
					}
				}

				}
				break;
			case CODE:
				_localctx = new CodeInputConfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((CodeInputConfContext)_localctx).type = match(CODE);
				setState(158);
				match(ASSIGN);
				setState(164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(159);
					((CodeInputConfContext)_localctx).val = match(STRING_LITERAL);
					}
					break;
				case LSB:
					{
					setState(160);
					match(LSB);
					setState(161);
					((CodeInputConfContext)_localctx).list = strList();
					setState(162);
					match(RSB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case FILE:
				_localctx = new FileInputConfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				((FileInputConfContext)_localctx).type = match(FILE);
				setState(167);
				match(ASSIGN);
				setState(173);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(168);
					((FileInputConfContext)_localctx).val = match(STRING_LITERAL);
					}
					break;
				case LSB:
					{
					setState(169);
					match(LSB);
					setState(170);
					((FileInputConfContext)_localctx).list = strList();
					setState(171);
					match(RSB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case DIR:
				_localctx = new DirInputConfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				((DirInputConfContext)_localctx).type = match(DIR);
				setState(176);
				match(ASSIGN);
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(177);
					((DirInputConfContext)_localctx).val = match(STRING_LITERAL);
					}
					break;
				case LSB:
					{
					setState(178);
					match(LSB);
					setState(179);
					((DirInputConfContext)_localctx).list = strList();
					setState(180);
					match(RSB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(184);
				match(COMMA);
				{
				setState(185);
				match(BUILD);
				setState(186);
				match(ASSIGN);
				setState(187);
				((DirInputConfContext)_localctx).build = match(STRING_LITERAL);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProjectConfContext extends ParserRuleContext {
		public List<ConfContext> conf() {
			return getRuleContexts(ConfContext.class);
		}
		public ConfContext conf(int i) {
			return getRuleContext(ConfContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DeepMutateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DeepMutateParser.COMMA, i);
		}
		public ProjectConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectConf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterProjectConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitProjectConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitProjectConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectConfContext projectConf() throws RecognitionException {
		ProjectConfContext _localctx = new ProjectConfContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_projectConf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			conf();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(191);
				match(COMMA);
				setState(192);
				conf();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OutputConfContext extends ParserRuleContext {
		public List<ConfContext> conf() {
			return getRuleContexts(ConfContext.class);
		}
		public ConfContext conf(int i) {
			return getRuleContext(ConfContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DeepMutateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DeepMutateParser.COMMA, i);
		}
		public OutputConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputConf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterOutputConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitOutputConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitOutputConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputConfContext outputConf() throws RecognitionException {
		OutputConfContext _localctx = new OutputConfContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_outputConf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			conf();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(199);
				match(COMMA);
				setState(200);
				conf();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MutationConfContext extends ParserRuleContext {
		public List<ConfContext> conf() {
			return getRuleContexts(ConfContext.class);
		}
		public ConfContext conf(int i) {
			return getRuleContext(ConfContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DeepMutateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DeepMutateParser.COMMA, i);
		}
		public MutationConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutationConf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterMutationConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitMutationConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitMutationConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MutationConfContext mutationConf() throws RecognitionException {
		MutationConfContext _localctx = new MutationConfContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mutationConf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			conf();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(207);
				match(COMMA);
				setState(208);
				conf();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConfContext extends ParserRuleContext {
		public Token key;
		public Token val;
		public TerminalNode ASSIGN() { return getToken(DeepMutateParser.ASSIGN, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DeepMutateParser.STRING_LITERAL, 0); }
		public TerminalNode LANG() { return getToken(DeepMutateParser.LANG, 0); }
		public TerminalNode TYPE() { return getToken(DeepMutateParser.TYPE, 0); }
		public TerminalNode ANALYZE() { return getToken(DeepMutateParser.ANALYZE, 0); }
		public TerminalNode DATASTORE() { return getToken(DeepMutateParser.DATASTORE, 0); }
		public TerminalNode URI() { return getToken(DeepMutateParser.URI, 0); }
		public TerminalNode DB() { return getToken(DeepMutateParser.DB, 0); }
		public TerminalNode USER() { return getToken(DeepMutateParser.USER, 0); }
		public TerminalNode PASS() { return getToken(DeepMutateParser.PASS, 0); }
		public TerminalNode REPORT() { return getToken(DeepMutateParser.REPORT, 0); }
		public TerminalNode ACTIVE() { return getToken(DeepMutateParser.ACTIVE, 0); }
		public ConfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterConf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitConf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitConf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfContext conf() throws RecognitionException {
		ConfContext _localctx = new ConfContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conf);
		int _la;
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
			case ANALYZE:
			case LANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				((ConfContext)_localctx).key = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 17920L) != 0) ) {
					((ConfContext)_localctx).key = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				match(ASSIGN);
				setState(216);
				((ConfContext)_localctx).val = match(STRING_LITERAL);
				}
				break;
			case REPORT:
			case URI:
			case DATASTORE:
			case DB:
			case USER:
			case PASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				((ConfContext)_localctx).key = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 15738880L) != 0) ) {
					((ConfContext)_localctx).key = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				match(ASSIGN);
				setState(219);
				((ConfContext)_localctx).val = match(STRING_LITERAL);
				}
				break;
			case ACTIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				((ConfContext)_localctx).key = match(ACTIVE);
				setState(221);
				match(ASSIGN);
				setState(222);
				((ConfContext)_localctx).val = match(STRING_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StrListContext extends ParserRuleContext {
		public Token STRING_LITERAL;
		public List<Token> list = new ArrayList<Token>();
		public List<TerminalNode> STRING_LITERAL() { return getTokens(DeepMutateParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(DeepMutateParser.STRING_LITERAL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DeepMutateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DeepMutateParser.COMMA, i);
		}
		public StrListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).enterStrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeepMutateParserListener ) ((DeepMutateParserListener)listener).exitStrList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepMutateParserVisitor ) return ((DeepMutateParserVisitor<? extends T>)visitor).visitStrList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrListContext strList() throws RecognitionException {
		StrListContext _localctx = new StrListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_strList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			((StrListContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			((StrListContext)_localctx).list.add(((StrListContext)_localctx).STRING_LITERAL);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(226);
				match(COMMA);
				setState(227);
				((StrListContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				((StrListContext)_localctx).list.add(((StrListContext)_localctx).STRING_LITERAL);
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static final String _serializedATN =
		"\u0004\u0001D\u00ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"9\b\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002D\b\u0002\n\u0002\f\u0002"+
		"G\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"Y\b\u0003\u0001\u0003\u0004\u0003\\\b\u0003\u000b\u0003\f\u0003]\u0001"+
		"\u0003\u0004\u0003a\b\u0003\u000b\u0003\f\u0003b\u0003\u0003e\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001\u0004\u0003\u0004"+
		"l\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004p\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0003\u0005t\b\u0005\u0001\u0005\u0003\u0005w\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005{\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u007f\b\u0006\u0001\u0006\u0003\u0006\u0082\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0086\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u008a"+
		"\b\u0007\u0001\u0007\u0003\u0007\u008d\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0091\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009c\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00a5\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00ae\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00b7\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00bd\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00c2"+
		"\b\f\n\f\f\f\u00c5\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u00ca\b\r\n\r\f"+
		"\r\u00cd\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00d2\b\u000e"+
		"\n\u000e\f\u000e\u00d5\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00e0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00e5"+
		"\b\u0010\n\u0010\f\u0010\u00e8\t\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0002\u0002\u0000\t\n\u000e\u000e\u0003\u0000\u000b\u000b"+
		"\r\r\u0014\u0017\u00fa\u0000%\u0001\u0000\u0000\u0000\u0002*\u0001\u0000"+
		"\u0000\u0000\u0004?\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000\u0000"+
		"\bf\u0001\u0000\u0000\u0000\nq\u0001\u0000\u0000\u0000\f|\u0001\u0000"+
		"\u0000\u0000\u000e\u0087\u0001\u0000\u0000\u0000\u0010\u0092\u0001\u0000"+
		"\u0000\u0000\u0012\u0094\u0001\u0000\u0000\u0000\u0014\u0096\u0001\u0000"+
		"\u0000\u0000\u0016\u00bc\u0001\u0000\u0000\u0000\u0018\u00be\u0001\u0000"+
		"\u0000\u0000\u001a\u00c6\u0001\u0000\u0000\u0000\u001c\u00ce\u0001\u0000"+
		"\u0000\u0000\u001e\u00df\u0001\u0000\u0000\u0000 \u00e1\u0001\u0000\u0000"+
		"\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0000\u0000"+
		"\u0001)\u0001\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000+,\u0005"+
		"!\u0000\u0000,-\u0003\u0016\u000b\u0000-.\u0005\"\u0000\u0000./\u0005"+
		"\u0002\u0000\u0000/0\u0005!\u0000\u000001\u0003\u0018\f\u000012\u0005"+
		"\"\u0000\u000023\u0005\u0013\u0000\u000034\u0005!\u0000\u000045\u0003"+
		"\u001a\r\u000056\u0005\"\u0000\u00006:\u0005%\u0000\u000079\u0003\u0004"+
		"\u0002\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000=>\u0005&\u0000\u0000>\u0003\u0001\u0000\u0000"+
		"\u0000?@\u0005\b\u0000\u0000@A\u0003\u0010\b\u0000AE\u0005%\u0000\u0000"+
		"BD\u0003\u0006\u0003\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005&\u0000\u0000I\u0005\u0001"+
		"\u0000\u0000\u0000JK\u0005#\u0000\u0000KL\u0003\u0012\t\u0000LM\u0005"+
		"$\u0000\u0000MO\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OT\u0001\u0000\u0000\u0000PQ\u0005#\u0000\u0000QR\u0003"+
		"\u001c\u000e\u0000RS\u0005$\u0000\u0000SU\u0001\u0000\u0000\u0000TP\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VX\u0003\b\u0004\u0000WY\u0003\n\u0005\u0000XW\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Yd\u0001\u0000\u0000\u0000Z\\\u0003\f\u0006"+
		"\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^e\u0001\u0000\u0000\u0000_a\u0003"+
		"\u000e\u0007\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000"+
		"\u0000d[\u0001\u0000\u0000\u0000d`\u0001\u0000\u0000\u0000e\u0007\u0001"+
		"\u0000\u0000\u0000fh\u0005\u0003\u0000\u0000gi\u0005\u001e\u0000\u0000"+
		"hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000"+
		"\u0000jl\u0005!\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mo\u0003\u0014\n\u0000np\u0005\"\u0000"+
		"\u0000on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\t\u0001\u0000"+
		"\u0000\u0000qs\u0005\u0004\u0000\u0000rt\u0005\u001e\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000"+
		"uw\u0005!\u0000\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xz\u0003\u0014\n\u0000y{\u0005\"\u0000\u0000"+
		"zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u000b\u0001\u0000"+
		"\u0000\u0000|~\u0005\u0005\u0000\u0000}\u007f\u0005\u001e\u0000\u0000"+
		"~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0005!\u0000\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0085\u0003\u0014\n\u0000\u0084\u0086\u0005\""+
		"\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\r\u0001\u0000\u0000\u0000\u0087\u0089\u0005\u0006\u0000"+
		"\u0000\u0088\u008a\u0005\u001e\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0005!\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0003\u0014\n\u0000\u008f\u0091\u0005\"\u0000\u0000\u0090"+
		"\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u000f\u0001\u0000\u0000\u0000\u0092\u0093\u0005=\u0000\u0000\u0093\u0011"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005=\u0000\u0000\u0095\u0013\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005?\u0000\u0000\u0097\u0015\u0001\u0000"+
		"\u0000\u0000\u0098\u009b\u0005\f\u0000\u0000\u0099\u009a\u00058\u0000"+
		"\u0000\u009a\u009c\u0005?\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u00bd\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0005\u0012\u0000\u0000\u009e\u00a4\u00058\u0000\u0000\u009f"+
		"\u00a5\u0005?\u0000\u0000\u00a0\u00a1\u0005#\u0000\u0000\u00a1\u00a2\u0003"+
		" \u0010\u0000\u00a2\u00a3\u0005$\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a5\u00bd\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0011\u0000"+
		"\u0000\u00a7\u00ad\u00058\u0000\u0000\u00a8\u00ae\u0005?\u0000\u0000\u00a9"+
		"\u00aa\u0005#\u0000\u0000\u00aa\u00ab\u0003 \u0010\u0000\u00ab\u00ac\u0005"+
		"$\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00a8\u0001\u0000"+
		"\u0000\u0000\u00ad\u00a9\u0001\u0000\u0000\u0000\u00ae\u00bd\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0005\u000f\u0000\u0000\u00b0\u00b6\u00058\u0000"+
		"\u0000\u00b1\u00b7\u0005?\u0000\u0000\u00b2\u00b3\u0005#\u0000\u0000\u00b3"+
		"\u00b4\u0003 \u0010\u0000\u00b4\u00b5\u0005$\u0000\u0000\u00b5\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005"+
		" \u0000\u0000\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bb\u00058\u0000"+
		"\u0000\u00bb\u00bd\u0005?\u0000\u0000\u00bc\u0098\u0001\u0000\u0000\u0000"+
		"\u00bc\u009d\u0001\u0000\u0000\u0000\u00bc\u00a6\u0001\u0000\u0000\u0000"+
		"\u00bc\u00af\u0001\u0000\u0000\u0000\u00bd\u0017\u0001\u0000\u0000\u0000"+
		"\u00be\u00c3\u0003\u001e\u000f\u0000\u00bf\u00c0\u0005 \u0000\u0000\u00c0"+
		"\u00c2\u0003\u001e\u000f\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u0019\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c6\u00cb\u0003\u001e\u000f\u0000\u00c7"+
		"\u00c8\u0005 \u0000\u0000\u00c8\u00ca\u0003\u001e\u000f\u0000\u00c9\u00c7"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u001b"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d3"+
		"\u0003\u001e\u000f\u0000\u00cf\u00d0\u0005 \u0000\u0000\u00d0\u00d2\u0003"+
		"\u001e\u000f\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u001d\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0007\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"8\u0000\u0000\u00d8\u00e0\u0005?\u0000\u0000\u00d9\u00da\u0007\u0001\u0000"+
		"\u0000\u00da\u00db\u00058\u0000\u0000\u00db\u00e0\u0005?\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0018\u0000\u0000\u00dd\u00de\u00058\u0000\u0000\u00de\u00e0"+
		"\u0005?\u0000\u0000\u00df\u00d6\u0001\u0000\u0000\u0000\u00df\u00d9\u0001"+
		"\u0000\u0000\u0000\u00df\u00dc\u0001\u0000\u0000\u0000\u00e0\u001f\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e6\u0005?\u0000\u0000\u00e2\u00e3\u0005 \u0000"+
		"\u0000\u00e3\u00e5\u0005?\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7!\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u001f%:ENTX]bdhkosvz~\u0081\u0085\u0089"+
		"\u008c\u0090\u009b\u00a4\u00ad\u00b6\u00bc\u00c3\u00cb\u00d3\u00df\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}