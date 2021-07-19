package com.example.webdeveloperchallenge.commons.exception;

public class CustomsException extends RuntimeException {
    private final ErrorCode code;

    public CustomsException(ErrorCode code) {
        super(code.getText());
        this.code = code;
    }

    public CustomsException(String message, Throwable cause, ErrorCode code) {
        super(code.getText() + ": " + message, cause);
        this.code = code;
    }

    public CustomsException(String message, ErrorCode code) {
        super(code.getText() + ": " + message);
        this.code = code;
    }

    public CustomsException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }

    public synchronized Throwable fillInStackTrace()  { return this; }


}
