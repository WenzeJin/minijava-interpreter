package cn.edu.nju.cs;

import cn.edu.nju.cs.parser.MiniJavaLexer;
import cn.edu.nju.cs.parser.MiniJavaParser;
import cn.edu.nju.cs.throwables.AssertionError;
import cn.edu.nju.cs.throwables.NullPointerError;
import cn.edu.nju.cs.throwables.TypeError;
import cn.edu.nju.cs.throwables.ArrayOutOfBoundsError;
import cn.edu.nju.cs.core.Interpreter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;

public class Main {
    public static void run(File mjFile) throws Exception {
        var input = CharStreams.fromFileName(mjFile.getAbsolutePath());
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokenStream);
        ParseTree pt = parser.compilationUnit();

        try {
            new Interpreter().visit(pt);
        } catch (TypeError e) {
            e.exitLog();
            System.out.println(e.getMessage());
        } catch (AssertionError e) {
            e.exitLog();
        } catch (ArrayOutOfBoundsError e) {
            e.exitLog();
        } catch (NullPointerError e) {
            e.exitLog();
        } catch (Exception e) {
            System.out.println("Process exits with the code 34.");
            e.printStackTrace();
        }
        
    }


    public static void main(String[] args) throws Exception  {

        if(args.length != 1) {
            System.err.println("Error: Only one argument is allowed: the path of MiniJava file.");
            throw new RuntimeException();
        }

        File mjFile = new File(args[0]);
        run(mjFile);
    }
}