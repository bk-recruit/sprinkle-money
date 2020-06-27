package me.bk.sprinklemoney.exception;

public class DefaultExceptionHandler extends RuntimeException {
    public DefaultExceptionHandler() {
        super();
    }

    public DefaultExceptionHandler(String message) {
        super(message);
    }

    public DefaultExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultExceptionHandler(Throwable cause) {
        super(cause);
    }
}
