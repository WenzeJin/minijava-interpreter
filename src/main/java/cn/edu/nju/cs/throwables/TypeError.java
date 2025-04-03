package cn.edu.nju.cs.throwables;

public class TypeError extends RuntimeException {
    
    public TypeError(String got, String expected) {
        super("Type error: expected " + expected + ", but got " + got);
    }

    public TypeError(String got, String expected, String message) {
        super("Type error: expected " + expected + ", but got " + got + ". " + message);
    }

    public TypeError(String message) {
        super(message);
    }

    public void exitLog() {
        System.out.println("Process exits with the code 34.");
    }

    @Override
    public String toString() {
        return "TypeError: " + getMessage();
    }
    
}
