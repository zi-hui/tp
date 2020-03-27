package seedu.kitchenhelper;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.CommandResult;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.parser.Parser;
import seedu.kitchenhelper.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class KitchenHelper {
    public final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public ArrayList<Ingredient> ingredientList = new ArrayList<>();
    public ArrayList<Recipe> recipeList = new ArrayList<>();
    public ArrayList<Chore> choreList = new ArrayList<>();
    /* Hi pls, look at this main program.
     * https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/Main.java */
    
    private Ui ui;
    private Storage storage;

    private void start() {
        ui = new Ui();
        String userChoice = ui.getUserChoice();
        ui.validUserChoice(userChoice);
        ui.showWelcomeMessage();
        if (userChoice.equals("1")) {
            storage = new Storage("outputIngredient.txt", "outputRecipe.txt",
                    "outputChore.txt");
            try {
                ingredientList = new ArrayList<>(storage.getIngredientData());
                recipeList = new ArrayList<>(storage.getRecipeData());
                choreList = new ArrayList<>(storage.getChoreData());
            } catch (FileNotFoundException err) {
                //Ui.errorMessage(err.toString());
                ingredientList = new ArrayList<>();
                recipeList = new ArrayList<>();
                choreList = new ArrayList<>();
            }
        } else if (userChoice.equals("2")) {
            createNewFiles();
            storage = new Storage("outputIngredientCopy.txt", "outputRecipeCopy.txt",
                    "outputChoreCopy.txt");
            try {
                ingredientList = new ArrayList<>(storage.getIngredientData());
                recipeList = new ArrayList<>(storage.getRecipeData());
                choreList = new ArrayList<>(storage.getChoreData());
            } catch (FileNotFoundException err) {
                //Ui.errorMessage(err.toString());
                ingredientList = new ArrayList<>();
                recipeList = new ArrayList<>();
                choreList = new ArrayList<>();
            }
        }
    }

    /**
     * Populate empty saved state files with current output files if save command have never been called by user.
     */
    private void createNewFiles() {
        var sourceIngredient = new File("outputIngredient.txt");
        var sourceRecipe = new File("outputRecipe.txt");
        var sourceChore = new File("outputChore.txt");
        var destIngredient = new File("outputIngredientCopy.txt");
        var destRecipe = new File("outputRecipeCopy.txt");
        var destChore = new File("outputChoreCopy.txt");

        if (destIngredient.length() == 0) {
            Storage.copyFile(sourceIngredient, destIngredient);
        }

        if (destRecipe.length() == 0) {
            Storage.copyFile(sourceRecipe, destRecipe);
        }
        if (destChore.length() == 0) {
            Storage.copyFile(sourceChore, destChore);
        }
    }
    
    private void run() throws KitchenHelperException {
        setUpLogger();
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }
    
    private void exit() {
        System.exit(0);
    }

    private void setUpLogger() throws KitchenHelperException {
        /*
        Output to console only when a serious failure has caused normal
        execution of the program
         */
        LogManager.getLogManager().reset();
        ConsoleHandler consoleOutput = new ConsoleHandler();
        consoleOutput.setLevel(Level.SEVERE);
        kitchenLogs.addHandler(consoleOutput);

        /*
        Logs all information above the Level.Fine to a log file
         */
        try {
            FileHandler logFile = new FileHandler("KitchenLogs.log");
            logFile.setFormatter(new SimpleFormatter());
            logFile.setLevel(Level.FINE);
            kitchenLogs.addHandler(logFile);
        } catch (IOException e) {
            throw new KitchenHelperException("Error in Logging");
        }
    }
    
    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandInput = "";
        
        do {
            try {
                // takes in the user's input
                userCommandInput = ui.getUserCommand();
                // parse input to return obj of the corresponding
                // type of command (i.e add/ delete/ list/ help / exit)
                command = new Parser().parseUserCommand(userCommandInput);
                CommandResult result = executeCommand(command);
                ui.showResultToUser(result);
                ui.printDivider();
            } catch (KitchenHelperException e) {
                ui.printInvalidCmd();
                ui.print(e.getMessage());
                ui.printDivider();
            }
        } while (!userCommandInput.equalsIgnoreCase(ExitCommand.COMMAND_WORD));
        
    }
    
    public static void main(String[] args) throws KitchenHelperException, IOException {
        new KitchenHelper().run();
    }
    
    /**
     * Executes the command and return result.
     *
     * @param command the command being executed.
     * @return the return message of the command.
     */
    public CommandResult executeCommand(Command command) {
        try {
            // to check if you get the right object
            // System.out.println(command.getClass().getName());
            CommandResult result = command.execute(ingredientList, recipeList, choreList);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
