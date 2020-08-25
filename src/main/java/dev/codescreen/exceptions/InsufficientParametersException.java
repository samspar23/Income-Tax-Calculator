package dev.codescreen.exceptions;

public class InsufficientParametersException extends Exception {
    public InsufficientParametersException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
