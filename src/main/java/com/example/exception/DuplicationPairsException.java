package main.java.com.example.exception;

public class DuplicationPairsException extends Exception {
    public DuplicationPairsException() {
    }

    public DuplicationPairsException(String message) {
        super(message);
    }

    public DuplicationPairsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationPairsException(Throwable cause) {
        super(cause);
    }

    public DuplicationPairsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
