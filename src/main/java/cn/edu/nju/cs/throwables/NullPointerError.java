package cn.edu.nju.cs.throwables;

public class NullPointerError extends RuntimeException {
    
    public NullPointerError(String message) {
        super(message);
    }

    public void exitLog() {
        System.out.println("Process exits with the code 34.");
    }

    @Override
    public String toString() {
        return "NullPointerError: " + getMessage();
    }

}
