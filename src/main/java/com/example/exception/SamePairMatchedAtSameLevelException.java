package main.java.com.example.exception;

public class SamePairMatchedAtSameLevelException extends RuntimeException {
    public SamePairMatchedAtSameLevelException() {
    }

    public SamePairMatchedAtSameLevelException(String message) {
        super(message);
    }

    public SamePairMatchedAtSameLevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public SamePairMatchedAtSameLevelException(Throwable cause) {
        super(cause);
    }

    public SamePairMatchedAtSameLevelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
