package cn.edu.nju.cs.throwables;

import cn.edu.nju.cs.value.MiniJavaAny;

public class Return extends Throwable {

    final MiniJavaAny returnValue;

    public Return(MiniJavaAny value) {
        super();
        this.returnValue = value;
    }

    public MiniJavaAny getReturnValue() {
        return returnValue;
    }
    
}
