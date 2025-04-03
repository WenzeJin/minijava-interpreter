package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RuntimeEnv {

    final Stack<VarTable> varTableStack;
    final Stack<Integer> methodBoundary;
    final Stack<String> scopeName;

    final Map<MethodSignature, MethodBody> methodTable;
    // this cache is used to store the method signature which is not same as those in methodTable, but can be called by implicit cast;
    final Map<MethodSignature, MethodBody> cacheTable;

    boolean createdNewScope; // tell the interpreter whether we have already created a new scope for a block content

    public RuntimeEnv() {
        varTableStack = new Stack<>();
        methodTable = new HashMap<>();
        cacheTable = new HashMap<>();
        methodBoundary = new Stack<>();
        scopeName = new Stack<>();
        createdNewScope = false;
    }

    public VarTable getCurrentVarTable() {
        if (varTableStack.empty()) {
            return null;
        }
        return varTableStack.peek();
    }

    public boolean isCreatedNewScope() {
        return createdNewScope;
    }
    
    /**
     * Set the flag to indicate that a new scope has been created.
     * 
     */
    public void setCreatedNewScope() {
        createdNewScope = true;
    }

    public void useNewScope() {
        createdNewScope = false;
    }

    public MethodBody getMethod(MethodSignature methodSignature) {
        MethodBody methodBody = methodTable.get(methodSignature);
        if (methodBody == null) {
            methodBody = cacheTable.get(methodSignature);
        }
        if (methodBody == null) {
            // try to find the method with minimum cast operhead
            int minimumCost = Integer.MAX_VALUE;
            int candidate = 0;
            MethodBody method = null;
            for (MethodSignature signature : methodTable.keySet()) {
                int cost = signature.canBeCalled(methodSignature);
                if (cost >= 0 && cost < minimumCost) {
                    minimumCost = cost;
                    candidate = 1;
                    method = methodTable.get(signature);
                } else if (cost >= 0 && cost == minimumCost) {
                    candidate++;
                }
            }
            if (candidate == 1) {
                methodBody = method;
                cacheTable.put(methodSignature, methodBody);
            }
        }
        return methodBody;
    }

    public void registerMethod(MethodSignature methodSignature, MethodBody methodBody) {
        if (methodTable.containsKey(methodSignature)) {
            throw new RuntimeException("Method " + methodSignature.getMethodName() + " already exists");
        }
        methodTable.put(methodSignature, methodBody);
    }

    public void registerBuiltInMethod() {
        BuiltInMethod.initialize();
        BuiltInMethod.getBuildInMethodsRegistry().forEach((methodSignature, methodBody) -> {
            if (methodTable.containsKey(methodSignature)) {
                throw new RuntimeException("Method " + methodSignature.getMethodName() + " already exists");
            }
            methodTable.put(methodSignature, methodBody);
        });
    }

    public void enterBlock() {
        varTableStack.push(new VarTable());
    }

    public void enterFunction(String functionName) {
        scopeName.push(functionName);
        methodBoundary.push(varTableStack.size());
        varTableStack.push(new VarTable());
        createdNewScope = true;
    }

    public void exitBlock() {
        varTableStack.pop();
    }

    public void exitFunction() {
        int size = methodBoundary.pop();
        while (varTableStack.size() > size) {
            varTableStack.pop();
        }
        scopeName.pop();
    }

    public MiniJavaAny lookUp(String identifier) {
        Stack<VarTable> tops = new Stack<>();
        MiniJavaAny res = null;
        int boundary = methodBoundary.empty() ? 0 : methodBoundary.peek();
        while (!varTableStack.empty() && varTableStack.size() > boundary) {
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------\n");
        sb.append("RuntimeEnv: \n");
        for (int i = 0; i < varTableStack.size(); i++) {
            sb.append("VarTable " + i + ": \n" + varTableStack.get(i).toString());
        }
        sb.append("MethodTable: \n");
        for (MethodSignature methodSignature : methodTable.keySet()) {
            sb.append(methodSignature.toString() + "\n");
        }
        sb.append("CacheTable: \n");
        for (MethodSignature methodSignature : cacheTable.keySet()) {
            var body = cacheTable.get(methodSignature);
            String bodyString = body instanceof BuiltInMethod ? ((BuiltInMethod)body).getFunction().getClass().getSimpleName()
                    : ((CustomMethod) body).getMethodSignature().toString();
            sb.append(methodSignature.toString() + " -> " + bodyString + "\n");
        }
        sb.append("--------------------");
        return sb.toString();
    }
}
