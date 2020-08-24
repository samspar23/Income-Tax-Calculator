package dev.codescreen.exceptions;

public class InvalidYearException extends Exception {
    private final String errMessage;

    public InvalidYearException(String errMessage) {
        this.errMessage = errMessage;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    public String getErrMessage() {
        return errMessage;
    }
}
