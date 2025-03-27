package cn.edu.nju.cs.core;

import cn.edu.nju.cs.parser.MiniJavaParserBaseVisitor;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

import cn.edu.nju.cs.parser.MiniJavaParser;


/**
 * The TypeChecker class extends MiniJavaParserBaseVisitor to perform type checking
 * on a MiniJava program. It uses a stack-based symbol table to manage variable
 * scopes and their associated types during the parsing process.
 */
public class TypeChecker extends MiniJavaParserBaseVisitor<String> {

    Stack<Map<String, String>> symbolTable = new Stack<>();
    
    private void enterScope() {
        symbolTable.push(new HashMap<>());
    }

    private void exitScope() {
        symbolTable.pop();
    }

    private String lookup(String id) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(id)) {
                return symbolTable.get(i).get(id);
            }
        }
        return null;
    }


    @Override
    public String visitLiteral(MiniJavaParser.LiteralContext ctx) {
        if (ctx.NULL_LITERAL() != null) {
            return "null";
        }

        
    }
}
