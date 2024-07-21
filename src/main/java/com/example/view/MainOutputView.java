package main.java.com.example.view;

import main.java.com.example.MainCommand;

public class MainOutputView {
    private static final String CHOOSE_FUNCTION_MESSAGE = "기능을 선택하세요.";
    private static final String COMMAND_FORMAT = "%s. %s%n";

    public static void printCommands() {
        System.out.println();
        System.out.println(CHOOSE_FUNCTION_MESSAGE);
        printCommandInfo();
    }

    private static void printCommandInfo() {
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.printf(COMMAND_FORMAT,
                    mainCommand.getCommand(), mainCommand.getDescription());
        }
    }
}
