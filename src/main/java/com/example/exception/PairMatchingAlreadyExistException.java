package main.java.com.example.exception;

public class PairMatchingAlreadyExistException extends RuntimeException {
    public PairMatchingAlreadyExistException() {
    }

    public PairMatchingAlreadyExistException(String message) {
        super(message);
    }

    public PairMatchingAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PairMatchingAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public PairMatchingAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
