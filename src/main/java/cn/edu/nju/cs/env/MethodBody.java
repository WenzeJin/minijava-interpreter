package cn.edu.nju.cs.env;

import cn.edu.nju.cs.value.MiniJavaAny;

public interface MethodBody {
    public MiniJavaAny invoke(RuntimeEnv env, MiniJavaAny[] args);
}
