package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;

import java.util.HashMap;
import java.util.Map;

public class VarTable {

    private final Map<String, MiniJavaAny> table;

    public VarTable() {
        table = new HashMap<>();
    }

    public Map<String, MiniJavaAny> getTable() {
        return table;
    }

    public boolean assign(String identifier, MiniJavaAny value) {
        if (table.containsKey(identifier)) {
            table.put(identifier, value);
            return true;
        } else {
            return false;
        }
    }

    public boolean init(String identifier, MiniJavaAny value) {
        if (table.containsKey(identifier)) {
            return false;
        } else {
            table.put(identifier, value);
            return true;
        }
    }

    public MiniJavaAny getValue(String identifier) {
        return table.get(identifier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, MiniJavaAny> entry : table.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
