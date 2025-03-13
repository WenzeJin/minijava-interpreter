// Generated from MiniJavaParser.g4 by ANTLR 4.13.2
package cn.edu.nju.cs.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, STRING=28, INTERFACE=29, 
		LONG=30, NATIVE=31, NEW=32, PACKAGE=33, PRIVATE=34, PROTECTED=35, PUBLIC=36, 
		RETURN=37, SHORT=38, STATIC=39, STRICTFP=40, SUPER=41, SWITCH=42, SYNCHRONIZED=43, 
		THIS=44, THROW=45, THROWS=46, TRANSIENT=47, TRY=48, VOID=49, VOLATILE=50, 
		WHILE=51, MODULE=52, OPEN=53, REQUIRES=54, EXPORTS=55, OPENS=56, TO=57, 
		USES=58, PROVIDES=59, WITH=60, TRANSITIVE=61, VAR=62, YIELD=63, RECORD=64, 
		SEALED=65, PERMITS=66, NON_SEALED=67, DECIMAL_LITERAL=68, HEX_LITERAL=69, 
		OCT_LITERAL=70, BINARY_LITERAL=71, FLOAT_LITERAL=72, HEX_FLOAT_LITERAL=73, 
		BOOL_LITERAL=74, CHAR_LITERAL=75, STRING_LITERAL=76, TEXT_BLOCK=77, NULL_LITERAL=78, 
		LPAREN=79, RPAREN=80, LBRACE=81, RBRACE=82, LBRACK=83, RBRACK=84, SEMI=85, 
		COMMA=86, DOT=87, ASSIGN=88, GT=89, LT=90, BANG=91, TILDE=92, QUESTION=93, 
		COLON=94, EQUAL=95, LE=96, GE=97, NOTEQUAL=98, AND=99, OR=100, INC=101, 
		DEC=102, ADD=103, SUB=104, MUL=105, DIV=106, BITAND=107, BITOR=108, CARET=109, 
		MOD=110, LSHIFT=111, RSHIFT=112, URSHIFT=113, ADD_ASSIGN=114, SUB_ASSIGN=115, 
		MUL_ASSIGN=116, DIV_ASSIGN=117, AND_ASSIGN=118, OR_ASSIGN=119, XOR_ASSIGN=120, 
		MOD_ASSIGN=121, LSHIFT_ASSIGN=122, RSHIFT_ASSIGN=123, URSHIFT_ASSIGN=124, 
		ARROW=125, COLONCOLON=126, AT=127, ELLIPSIS=128, WS=129, COMMENT=130, 
		LINE_COMMENT=131, IDENTIFIER=132;
	public static final int
		RULE_compilationUnit = 0, RULE_block = 1, RULE_blockStatement = 2, RULE_localVariableDeclaration = 3, 
		RULE_statement = 4, RULE_expression = 5, RULE_primary = 6, RULE_literal = 7, 
		RULE_identifier = 8, RULE_primitiveType = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "block", "blockStatement", "localVariableDeclaration", 
			"statement", "expression", "primary", "literal", "identifier", "primitiveType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
			"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
			"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
			"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
			"'int'", "'string'", "'interface'", "'long'", "'native'", "'new'", "'package'", 
			"'private'", "'protected'", "'public'", "'return'", "'short'", "'static'", 
			"'strictfp'", "'super'", "'switch'", "'synchronized'", "'this'", "'throw'", 
			"'throws'", "'transient'", "'try'", "'void'", "'volatile'", "'while'", 
			"'module'", "'open'", "'requires'", "'exports'", "'opens'", "'to'", "'uses'", 
			"'provides'", "'with'", "'transitive'", "'var'", "'yield'", "'record'", 
			"'sealed'", "'permits'", "'non-sealed'", null, null, null, null, null, 
			null, null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'not'", "'~'", "'?'", 
			"':'", "'=='", "'<='", "'>='", "'!='", "'and'", "'or'", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'<<'", "'>>'", 
			"'>>>'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", 
			"'<<='", "'>>='", "'>>>='", "'->'", "'::'", "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", 
			"CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", 
			"ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
			"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "STRING", "INTERFACE", "LONG", 
			"NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", 
			"SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", 
			"THROW", "THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MODULE", 
			"OPEN", "REQUIRES", "EXPORTS", "OPENS", "TO", "USES", "PROVIDES", "WITH", 
			"TRANSITIVE", "VAR", "YIELD", "RECORD", "SEALED", "PERMITS", "NON_SEALED", 
			"DECIMAL_LITERAL", "HEX_LITERAL", "OCT_LITERAL", "BINARY_LITERAL", "FLOAT_LITERAL", 
			"HEX_FLOAT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", 
			"TEXT_BLOCK", "NULL_LITERAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
			"TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", 
			"OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", 
			"MOD", "LSHIFT", "RSHIFT", "URSHIFT", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
			"DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", 
			"LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "ARROW", "COLONCOLON", 
			"AT", "ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT", "IDENTIFIER"
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
	public String getGrammarFileName() { return "MiniJavaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			block();
			setState(21);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MiniJavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(LBRACE);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4503599224717044L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2061989239831L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(24);
				blockStatement();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(RBRACE);
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
	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				localVariableDeclaration();
				setState(33);
				match(SEMI);
				}
				break;
			case ASSERT:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case LBRACE:
			case SEMI:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				statement();
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
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_localVariableDeclaration);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				primitiveType();
				setState(39);
				identifier();
				setState(40);
				match(ASSIGN);
				setState(41);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				primitiveType();
				setState(44);
				identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(SEMI);
				}
				break;
			case ASSERT:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				expression(0);
				setState(51);
				match(SEMI);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Token prefix;
		public Token bop;
		public Token postfix;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MiniJavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public TerminalNode INC() { return getToken(MiniJavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(MiniJavaParser.DEC, 0); }
		public TerminalNode TILDE() { return getToken(MiniJavaParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(MiniJavaParser.BANG, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public TerminalNode MUL() { return getToken(MiniJavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiniJavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiniJavaParser.MOD, 0); }
		public TerminalNode LSHIFT() { return getToken(MiniJavaParser.LSHIFT, 0); }
		public TerminalNode URSHIFT() { return getToken(MiniJavaParser.URSHIFT, 0); }
		public TerminalNode RSHIFT() { return getToken(MiniJavaParser.RSHIFT, 0); }
		public TerminalNode LE() { return getToken(MiniJavaParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniJavaParser.GE, 0); }
		public TerminalNode GT() { return getToken(MiniJavaParser.GT, 0); }
		public TerminalNode LT() { return getToken(MiniJavaParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(MiniJavaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(MiniJavaParser.NOTEQUAL, 0); }
		public TerminalNode BITAND() { return getToken(MiniJavaParser.BITAND, 0); }
		public TerminalNode CARET() { return getToken(MiniJavaParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(MiniJavaParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(MiniJavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniJavaParser.OR, 0); }
		public TerminalNode COLON() { return getToken(MiniJavaParser.COLON, 0); }
		public TerminalNode QUESTION() { return getToken(MiniJavaParser.QUESTION, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(MiniJavaParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(MiniJavaParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(MiniJavaParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(MiniJavaParser.DIV_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(MiniJavaParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(MiniJavaParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(MiniJavaParser.XOR_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(MiniJavaParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(MiniJavaParser.URSHIFT_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(MiniJavaParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(MiniJavaParser.MOD_ASSIGN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(56);
				primary();
				}
				break;
			case 2:
				{
				setState(57);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 15363L) != 0)) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(58);
				expression(14);
				}
				break;
			case 3:
				{
				setState(59);
				match(LPAREN);
				setState(60);
				primitiveType();
				setState(61);
				match(RPAREN);
				setState(62);
				expression(13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(107);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(66);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(67);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 35L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(68);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(70);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(71);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(72);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(73);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & 7L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(74);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(75);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(76);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 387L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(78);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(79);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(82);
						((ExpressionContext)_localctx).bop = match(BITAND);
						setState(83);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(85);
						((ExpressionContext)_localctx).bop = match(CARET);
						setState(86);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(88);
						((ExpressionContext)_localctx).bop = match(BITOR);
						setState(89);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(91);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(92);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(94);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(95);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(97);
						((ExpressionContext)_localctx).bop = match(QUESTION);
						setState(98);
						expression(0);
						setState(99);
						match(COLON);
						setState(100);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(103);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 137371844609L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(106);
						((ExpressionContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((ExpressionContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MiniJavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaParser.RPAREN, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(LPAREN);
				setState(113);
				expression(0);
				setState(114);
				match(RPAREN);
				}
				break;
			case DECIMAL_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				literal();
				}
				break;
			case ASSERT:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				identifier();
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(MiniJavaParser.DECIMAL_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(MiniJavaParser.CHAR_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MiniJavaParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(MiniJavaParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(MiniJavaParser.NULL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 1473L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniJavaParser.IDENTIFIER, 0); }
		public TerminalNode MODULE() { return getToken(MiniJavaParser.MODULE, 0); }
		public TerminalNode OPEN() { return getToken(MiniJavaParser.OPEN, 0); }
		public TerminalNode REQUIRES() { return getToken(MiniJavaParser.REQUIRES, 0); }
		public TerminalNode EXPORTS() { return getToken(MiniJavaParser.EXPORTS, 0); }
		public TerminalNode OPENS() { return getToken(MiniJavaParser.OPENS, 0); }
		public TerminalNode TO() { return getToken(MiniJavaParser.TO, 0); }
		public TerminalNode USES() { return getToken(MiniJavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(MiniJavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(MiniJavaParser.WITH, 0); }
		public TerminalNode TRANSITIVE() { return getToken(MiniJavaParser.TRANSITIVE, 0); }
		public TerminalNode YIELD() { return getToken(MiniJavaParser.YIELD, 0); }
		public TerminalNode SEALED() { return getToken(MiniJavaParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(MiniJavaParser.PERMITS, 0); }
		public TerminalNode RECORD() { return getToken(MiniJavaParser.RECORD, 0); }
		public TerminalNode VAR() { return getToken(MiniJavaParser.VAR, 0); }
		public TerminalNode ASSERT() { return getToken(MiniJavaParser.ASSERT, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -4503599627370492L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0) || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(MiniJavaParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaParserListener ) ((MiniJavaParserListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaParserVisitor ) return ((MiniJavaParserVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 402653448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0084\u007f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u001a\b\u0001\n\u0001\f\u0001\u001d\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002%\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003/\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"6\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005A\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"l\b\u0005\n\u0005\f\u0005o\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006w\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0000\u0001\n\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u000b\u0002\u0000[\\"+
		"eh\u0002\u0000ijnn\u0001\u0000gh\u0001\u0000oq\u0002\u0000YZ`a\u0002\u0000"+
		"__bb\u0002\u0000XXr|\u0001\u0000ef\u0003\u0000DDJLNN\u0003\u0000\u0002"+
		"\u00024B\u0084\u0084\u0003\u0000\u0003\u0003\b\b\u001b\u001c\u008a\u0000"+
		"\u0014\u0001\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000\u0004"+
		"$\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000\u0000\b5\u0001\u0000"+
		"\u0000\u0000\n@\u0001\u0000\u0000\u0000\fv\u0001\u0000\u0000\u0000\u000e"+
		"x\u0001\u0000\u0000\u0000\u0010z\u0001\u0000\u0000\u0000\u0012|\u0001"+
		"\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005"+
		"\u0000\u0000\u0001\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u001b\u0005"+
		"Q\u0000\u0000\u0018\u001a\u0003\u0004\u0002\u0000\u0019\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001e\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e\u001f\u0005R\u0000"+
		"\u0000\u001f\u0003\u0001\u0000\u0000\u0000 !\u0003\u0006\u0003\u0000!"+
		"\"\u0005U\u0000\u0000\"%\u0001\u0000\u0000\u0000#%\u0003\b\u0004\u0000"+
		"$ \u0001\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%\u0005\u0001\u0000"+
		"\u0000\u0000&\'\u0003\u0012\t\u0000\'(\u0003\u0010\b\u0000()\u0005X\u0000"+
		"\u0000)*\u0003\n\u0005\u0000*/\u0001\u0000\u0000\u0000+,\u0003\u0012\t"+
		"\u0000,-\u0003\u0010\b\u0000-/\u0001\u0000\u0000\u0000.&\u0001\u0000\u0000"+
		"\u0000.+\u0001\u0000\u0000\u0000/\u0007\u0001\u0000\u0000\u000006\u0003"+
		"\u0002\u0001\u000016\u0005U\u0000\u000023\u0003\n\u0005\u000034\u0005"+
		"U\u0000\u000046\u0001\u0000\u0000\u000050\u0001\u0000\u0000\u000051\u0001"+
		"\u0000\u0000\u000052\u0001\u0000\u0000\u00006\t\u0001\u0000\u0000\u0000"+
		"78\u0006\u0005\uffff\uffff\u00008A\u0003\f\u0006\u00009:\u0007\u0000\u0000"+
		"\u0000:A\u0003\n\u0005\u000e;<\u0005O\u0000\u0000<=\u0003\u0012\t\u0000"+
		"=>\u0005P\u0000\u0000>?\u0003\n\u0005\r?A\u0001\u0000\u0000\u0000@7\u0001"+
		"\u0000\u0000\u0000@9\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000\u0000"+
		"Am\u0001\u0000\u0000\u0000BC\n\f\u0000\u0000CD\u0007\u0001\u0000\u0000"+
		"Dl\u0003\n\u0005\rEF\n\u000b\u0000\u0000FG\u0007\u0002\u0000\u0000Gl\u0003"+
		"\n\u0005\fHI\n\n\u0000\u0000IJ\u0007\u0003\u0000\u0000Jl\u0003\n\u0005"+
		"\u000bKL\n\t\u0000\u0000LM\u0007\u0004\u0000\u0000Ml\u0003\n\u0005\nN"+
		"O\n\b\u0000\u0000OP\u0007\u0005\u0000\u0000Pl\u0003\n\u0005\tQR\n\u0007"+
		"\u0000\u0000RS\u0005k\u0000\u0000Sl\u0003\n\u0005\bTU\n\u0006\u0000\u0000"+
		"UV\u0005m\u0000\u0000Vl\u0003\n\u0005\u0007WX\n\u0005\u0000\u0000XY\u0005"+
		"l\u0000\u0000Yl\u0003\n\u0005\u0006Z[\n\u0004\u0000\u0000[\\\u0005c\u0000"+
		"\u0000\\l\u0003\n\u0005\u0005]^\n\u0003\u0000\u0000^_\u0005d\u0000\u0000"+
		"_l\u0003\n\u0005\u0004`a\n\u0002\u0000\u0000ab\u0005]\u0000\u0000bc\u0003"+
		"\n\u0005\u0000cd\u0005^\u0000\u0000de\u0003\n\u0005\u0002el\u0001\u0000"+
		"\u0000\u0000fg\n\u0001\u0000\u0000gh\u0007\u0006\u0000\u0000hl\u0003\n"+
		"\u0005\u0001ij\n\u000f\u0000\u0000jl\u0007\u0007\u0000\u0000kB\u0001\u0000"+
		"\u0000\u0000kE\u0001\u0000\u0000\u0000kH\u0001\u0000\u0000\u0000kK\u0001"+
		"\u0000\u0000\u0000kN\u0001\u0000\u0000\u0000kQ\u0001\u0000\u0000\u0000"+
		"kT\u0001\u0000\u0000\u0000kW\u0001\u0000\u0000\u0000kZ\u0001\u0000\u0000"+
		"\u0000k]\u0001\u0000\u0000\u0000k`\u0001\u0000\u0000\u0000kf\u0001\u0000"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u000b\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000pq\u0005O\u0000\u0000qr\u0003\n\u0005"+
		"\u0000rs\u0005P\u0000\u0000sw\u0001\u0000\u0000\u0000tw\u0003\u000e\u0007"+
		"\u0000uw\u0003\u0010\b\u0000vp\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000"+
		"\u0000vu\u0001\u0000\u0000\u0000w\r\u0001\u0000\u0000\u0000xy\u0007\b"+
		"\u0000\u0000y\u000f\u0001\u0000\u0000\u0000z{\u0007\t\u0000\u0000{\u0011"+
		"\u0001\u0000\u0000\u0000|}\u0007\n\u0000\u0000}\u0013\u0001\u0000\u0000"+
		"\u0000\b\u001b$.5@kmv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}