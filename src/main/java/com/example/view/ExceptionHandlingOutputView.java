package main.java.com.example.view;

public class ExceptionHandlingOutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void printExceptionMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
