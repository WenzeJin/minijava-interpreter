package cn.edu.nju.cs.utils;

import cn.edu.nju.cs.env.VarTable;
import cn.edu.nju.cs.value.MiniJavaAny;

import java.util.ArrayList;
import java.util.List;
public class PrettyOutput {

    public static void print(VarTable table) {
        List<String> keys = new ArrayList<>(table.getTable().keySet());
        keys.sort(String::compareTo);
        for (String key : keys) {
            MiniJavaAny value = table.getValue(key);
            System.out.println(key + " : " + value);
        }
    }

}
