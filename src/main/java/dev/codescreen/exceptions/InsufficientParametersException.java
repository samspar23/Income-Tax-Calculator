package dev.codescreen.exceptions;

public class InsufficientParametersException extends Exception {
    private final String errMessage;

    public InsufficientParametersException(String errMessage) {
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
