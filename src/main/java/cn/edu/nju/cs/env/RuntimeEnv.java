package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;
import cn.edu.nju.cs.utils.PrettyOutput;

import java.util.Stack;

public class RuntimeEnv {

    final Stack<VarTable> varTableStack;

    public RuntimeEnv() {
        varTableStack = new Stack<>();
    }

    public VarTable getCurrentVarTable() {
        if (varTableStack.empty()) {
            return null;
        }
        return varTableStack.peek();
    }

    public void enterBlock() {
        varTableStack.push(new VarTable());
    }

    public void exitBlock() {
        VarTable latest = varTableStack.pop();
        PrettyOutput.print(latest);
    }

    public MiniJavaAny lookUp(String identifier) {
        Stack<VarTable> tops = new Stack<>();
        MiniJavaAny res = null;
        while (!varTableStack.empty()) {
            // Most variables are stored on the top, so first try to look up then push pop.
            res = varTableStack.peek().getValue(identifier);
            if (res != null) {
                break;
            }
            tops.push(varTableStack.pop());
        }
        while (!tops.empty()) {
            varTableStack.push(tops.pop());
        }
        return res;
    }

    public boolean assign(String identifier, MiniJavaAny value) {
        Stack<VarTable> tops = new Stack<>();
        boolean flag = false;
        while (!varTableStack.empty()) {
            flag = varTableStack.peek().assign(identifier, value);
            if (flag) {
                break;
            }
            tops.push(varTableStack.pop());
        }
        while (!tops.empty()) {
            varTableStack.push(tops.pop());
        }
        return flag;
    }

    public boolean init(String identifier, MiniJavaAny value) {
        value.setVariable();
        return varTableStack.peek().init(identifier, value);
    }

}
