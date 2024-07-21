package main.java.com.example.view;

import java.io.Console;
import java.util.Scanner;

public class AbstractInputView {
    private static Scanner sc = new Scanner(System.in);

    protected static String readInput() {
        return sc.nextLine();
    }
}
