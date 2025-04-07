package cn.edu.nju.cs.throwables;

public class ArrayOutOfBoundsError extends RuntimeException {

    public ArrayOutOfBoundsError(String message) {
        super(message);
    }

    public void exitLog() {
        System.out.println("Process exits with the code 34.");
    }

    @Override
    public String toString() {
        return "ArrayOutOfBoundsError: " + getMessage();
    }

}
