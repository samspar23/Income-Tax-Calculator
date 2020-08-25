package dev.codescreen.exceptions;

public class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
