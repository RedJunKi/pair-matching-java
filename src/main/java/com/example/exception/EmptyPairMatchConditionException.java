package main.java.com.example.exception;

public class EmptyPairMatchConditionException extends RuntimeException {
    public EmptyPairMatchConditionException() {
    }

    public EmptyPairMatchConditionException(String message) {
        super(message);
    }

    public EmptyPairMatchConditionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyPairMatchConditionException(Throwable cause) {
        super(cause);
    }

    public EmptyPairMatchConditionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
