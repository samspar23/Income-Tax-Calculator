package dev.codescreen.exceptions;

public class NegativeValueException extends Exception {
    public NegativeValueException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
