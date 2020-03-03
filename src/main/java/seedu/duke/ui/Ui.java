package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }
    public String getUserCommand() {
        String fullInputLine = in.nextLine();
        System.out.println(fullInputLine);
        return fullInputLine;
    }
}
