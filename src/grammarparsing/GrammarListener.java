// Generated from C:/Users/Computer/IdeaProjects/ParserGenerator/src/grammarparsing\Grammar.g4 by ANTLR 4.7.2
package grammarparsing;

import java.util.LinkedList;
import java.util.Collections;
import grammar.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#grammarDescription}.
	 * @param ctx the parse tree
	 */
	void enterGrammarDescription(GrammarParser.GrammarDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#grammarDescription}.
	 * @param ctx the parse tree
	 */
	void exitGrammarDescription(GrammarParser.GrammarDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(GrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(GrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parserRules}.
	 * @param ctx the parse tree
	 */
	void enterParserRules(GrammarParser.ParserRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parserRules}.
	 * @param ctx the parse tree
	 */
	void exitParserRules(GrammarParser.ParserRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#singleRule}.
	 * @param ctx the parse tree
	 */
	void enterSingleRule(GrammarParser.SingleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#singleRule}.
	 * @param ctx the parse tree
	 */
	void exitSingleRule(GrammarParser.SingleRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(GrammarParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(GrammarParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varible}.
	 * @param ctx the parse tree
	 */
	void enterVarible(GrammarParser.VaribleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varible}.
	 * @param ctx the parse tree
	 */
	void exitVarible(GrammarParser.VaribleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#optionsList}.
	 * @param ctx the parse tree
	 */
	void enterOptionsList(GrammarParser.OptionsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#optionsList}.
	 * @param ctx the parse tree
	 */
	void exitOptionsList(GrammarParser.OptionsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argumentListTail}.
	 * @param ctx the parse tree
	 */
	void enterArgumentListTail(GrammarParser.ArgumentListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argumentListTail}.
	 * @param ctx the parse tree
	 */
	void exitArgumentListTail(GrammarParser.ArgumentListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleOption}.
	 * @param ctx the parse tree
	 */
	void enterRuleOption(GrammarParser.RuleOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleOption}.
	 * @param ctx the parse tree
	 */
	void exitRuleOption(GrammarParser.RuleOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleAtomList}.
	 * @param ctx the parse tree
	 */
	void enterRuleAtomList(GrammarParser.RuleAtomListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleAtomList}.
	 * @param ctx the parse tree
	 */
	void exitRuleAtomList(GrammarParser.RuleAtomListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleAtom}.
	 * @param ctx the parse tree
	 */
	void enterRuleAtom(GrammarParser.RuleAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleAtom}.
	 * @param ctx the parse tree
	 */
	void exitRuleAtom(GrammarParser.RuleAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(GrammarParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(GrammarParser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#nonTerminal}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminal(GrammarParser.NonTerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nonTerminal}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminal(GrammarParser.NonTerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(GrammarParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(GrammarParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#paramListTail}.
	 * @param ctx the parse tree
	 */
	void enterParamListTail(GrammarParser.ParamListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#paramListTail}.
	 * @param ctx the parse tree
	 */
	void exitParamListTail(GrammarParser.ParamListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#alternativeListTail}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeListTail(GrammarParser.AlternativeListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#alternativeListTail}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeListTail(GrammarParser.AlternativeListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lexerInfo}.
	 * @param ctx the parse tree
	 */
	void enterLexerInfo(GrammarParser.LexerInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lexerInfo}.
	 * @param ctx the parse tree
	 */
	void exitLexerInfo(GrammarParser.LexerInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#singleToken}.
	 * @param ctx the parse tree
	 */
	void enterSingleToken(GrammarParser.SingleTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#singleToken}.
	 * @param ctx the parse tree
	 */
	void exitSingleToken(GrammarParser.SingleTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#skipWS}.
	 * @param ctx the parse tree
	 */
	void enterSkipWS(GrammarParser.SkipWSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#skipWS}.
	 * @param ctx the parse tree
	 */
	void exitSkipWS(GrammarParser.SkipWSContext ctx);
}