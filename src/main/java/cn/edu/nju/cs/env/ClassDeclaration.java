package cn.edu.nju.cs.env;

import java.util.Map;
import java.util.HashMap;
import cn.edu.nju.cs.value.MiniJavaAny;

public class ClassDeclaration {
    
    private final String className;
    private final String superClassName;
    private ClassDeclaration superClass;

    private final Map<String, String> fields;
    private final Map<String, CustomMethod> methods;

    // caches to accelerate the process of method call and field store
    private final Map<String, ClassDeclaration> superClassEntryCache;
    private final Map<String, CustomMethod> methodCallCache;
    
    public ClassDeclaration(String className, String superClassName) {
        this.className = className;
        this.superClassName = superClassName;
        fields = new HashMap<>();
        methods = new HashMap<>();
        superClassEntryCache = new HashMap<>();
        methodCallCache = new HashMap<>();
    }

    public void bindSuperClass(ClassDeclaration superClass) {
        this.superClass = superClass;
    }

    public void declField(String fieldName, String fieldType) {
        fields.put(fieldName, fieldType);
    }

    public void declMethod(String methodName, CustomMethod method) {
        methods.put(methodName, method);
    }

    public Map<String, MiniJavaAny> initInstance() {
        Map<String, MiniJavaAny> instance;
        if (superClass != null) {
            instance = superClass.initInstance();
        } else {
            instance = new HashMap<>();
        }
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            String fieldType = entry.getValue();
            var value = new MiniJavaAny(fieldType, null);
            value.initializeDefaultValue();
            instance.put(fieldName, value);
        }
        return instance;
    }

    public boolean isSubClassOf(String className) {
        if (this.className.equals(className)) {
            return true;
        }
        if (superClass != null) {
            return superClass.isSubClassOf(className);
        }
        return false;
    }

    public MiniJavaAny invokeMethod(MiniJavaAny instance, String methodName, MiniJavaAny... args) {
        String declType = instance.getType();

        // not implemented
        return null;
    }

    

    public String getClassName() {
        return className;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    private ClassDeclaration getClassIf(String className) {
        if (this.className.equals(className)) {
            return this;
        }
        if (superClass != null) {
            return superClass.getClassIf(className);
        }
        return null;
    }

    private ClassDeclaration getSuperClass(String className) {
        // first check the cache, then check the super class
        if (superClassEntryCache.containsKey(className)) {
            return superClassEntryCache.get(className);
        } else {
            ClassDeclaration superClass = getClassIf(className);
            if (superClass != null) {
                superClassEntryCache.put(className, superClass);
            } else {
                // TODO: not a super class
            }
            return superClass;
        }
    }

}
