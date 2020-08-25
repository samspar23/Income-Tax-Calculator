package dev.codescreen.exceptions;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
