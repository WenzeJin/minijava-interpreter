package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;

public interface MiniJavaMethodImpl {
    
    String[] getParameterTypes();

    MiniJavaAny apply(RuntimeEnv env, MiniJavaAny... args);
    
}
