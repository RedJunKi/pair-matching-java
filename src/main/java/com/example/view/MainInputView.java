package main.java.com.example.view;

import main.java.com.example.MainCommand;

public class MainInputView extends AbstractInputView {
    public static MainCommand getCommand() {
        return MainCommand.findByCommand(readInput());
    }
}
