package cn.edu.nju.cs.throwables;

public class AssertionError extends RuntimeException{

    public AssertionError(String message) {
        super(message);
    }

    public void exitLog() {
        System.out.println("Process exits with the code 33.");
    }

    @Override
    public String toString() {
        return "AssertionError: " + getMessage();
    }
}
