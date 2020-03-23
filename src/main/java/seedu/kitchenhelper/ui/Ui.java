package seedu.kitchenhelper.ui;

import seedu.kitchenhelper.command.CommandResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * UI of the application.
 */
public class Ui {
    
    public static final String LS = System.lineSeparator();
    
    public static final String DIVIDER = "===================================================";

    public void printDivider() {
        System.out.println(DIVIDER);
    }

    /**
     * Format of a comment input line. Comment lines are silently consumed when reading user input.
     */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    private static final String WELCOME_MESSAGE = "Hello! I'm KitchenHelper here" + LS + "What can I do for you?";

    public static final String MESSAGE_TO_CHOOSE_STATE = "Please enter '1' for auto-save and '2' for saved state:";
    public static final String MESSAGE_FOR_AUTO_SAVE = "Okay auto-save chosen.";
    public static final String MESSAGE_FOR_SAVED_STATE = "Okay saved state chosen.";
    public static final String MESSAGE_INVALID_USER_CHOICE = "Invalid Choice!";
    
    private final Scanner in;
    private final PrintStream out;
    
    public Ui() {
        this(System.in, System.out);
    }
    
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void print(String message) {
        out.println(message);
    }

    public void printInvalidCmd() {
        System.out.println("Invalid Command, please check your format!");
    }

    public String getUserChoice() {
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_TO_CHOOSE_STATE);
        String userChoice;
        try {
            //Scanner sc = new Scanner(System.in);
            userChoice = in.nextLine();
            return userChoice;
        } catch (InputMismatchException ex) {
            askForReInput();
            getUserChoice();
            return "-1";
        }
    }

    public static void askForReInput() {
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_INVALID_USER_CHOICE);
        System.out.println(DIVIDER);
    }


    public static void validUserChoice(String userChoice) {
        System.out.println(DIVIDER);
        switch (userChoice) {
        case "1":
            System.out.println(MESSAGE_FOR_AUTO_SAVE);
            break;
        case "2":
            System.out.println(MESSAGE_FOR_SAVED_STATE);
            break;
        default:
        }
    }
    
    //@@author AY1920S2-CS2113T-M16-2-reused
    //Reused from
    //https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/ui/TextUi.java
    
    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }
    //@@author
    
    //@@author AY1920S2-CS2113T-M16-2-reused
    //Reused from
    //https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/ui/TextUi.java
    
    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    //@@author
    
    /**
     * Display the welcome message during startup.
     */
    public void showWelcomeMessage() {
        showToConsole(DIVIDER, WELCOME_MESSAGE, DIVIDER);
    }
    
    //@@author AY1920S2-CS2113T-M16-2-reused
    //Reused from
    //https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/ui/TextUi.java
    
    /**
     * Get the user command.
     *
     * @return the input line string
     */
    public String getUserCommand() {
        String fullInputLine = in.nextLine().trim();
        
        //silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }
        
        out.println(fullInputLine);
        return fullInputLine;
    }
    //@@author
    
    /**
     * A method that can take in a variable number of arguments.
     *
     * @param message the argument.
     */
    private void showToConsole(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }
    
    /**
     * Shows the results of the command to the user.
     *
     * @param result the CommandResult object.
     */
    public void showResultToUser(CommandResult result) {
        showToConsole(result.feedbackToUser);
    }

    public static void errorMessage(String err) {
        System.out.println(err);
    }
}
