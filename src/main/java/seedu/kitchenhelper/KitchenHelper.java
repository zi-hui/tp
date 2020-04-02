package seedu.kitchenhelper;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.CommandResult;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.notification.ChoreNotification;
import seedu.kitchenhelper.notification.IngredientNotification;
import seedu.kitchenhelper.object.Expenditure;
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
    
    private Ui ui;
    private Storage storage;

    private void start() {
        ui = new Ui();
        String userChoice = ui.getUserChoice();
        ui.validUserChoice(userChoice);
        ui.showWelcomeMessage();
        if (userChoice.equals("1")) {
            storage = new Storage("outputIngredient.txt", "outputRecipe.txt",
                    "outputChore.txt", "outputExpenditure.txt");
            try {
                ingredientList = new ArrayList<>(storage.getIngredientData());
                recipeList = new ArrayList<>(storage.getRecipeData());
                choreList = new ArrayList<>(storage.getChoreData());
                storage.loadExpenditureData();
            } catch (FileNotFoundException err) {
                ingredientList = new ArrayList<>();
                recipeList = new ArrayList<>();
                choreList = new ArrayList<>();
                Expenditure.getInstance().loadExpenditureVariables(0, 0, null);
            }
        } else if (userChoice.equals("2")) {
            createNewFiles();
            storage = new Storage("outputIngredientCopy.txt", "outputRecipeCopy.txt",
                    "outputChoreCopy.txt", "outputExpenditureCopy.txt");
            try {
                ingredientList = new ArrayList<>(storage.getIngredientData());
                recipeList = new ArrayList<>(storage.getRecipeData());
                choreList = new ArrayList<>(storage.getChoreData());
                storage.loadExpenditureData();
            } catch (FileNotFoundException err) {
                ingredientList = new ArrayList<>();
                recipeList = new ArrayList<>();
                choreList = new ArrayList<>();
                Expenditure.getInstance().loadExpenditureVariables(0, 0, null);
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
        var sourceExpenditure = new File("outputExpenditure.txt");
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

        var destExpenditure = new File("outputExpenditureCopy.txt");
        if (destExpenditure.length() == 0) {
            Storage.copyFile(sourceExpenditure, destExpenditure);
        }
    }
    
    private void run() throws KitchenHelperException {
        setUpLogger();
        start();
        showNotifications();
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
                userCommandInput = ui.getUserCommand();
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

    private void showNotifications() {
        String choreNotification;
        choreNotification = new ChoreNotification().getNotifications(choreList);
        System.out.println(choreNotification);
        String ingredientNotification;
        ingredientNotification = new IngredientNotification().getNotifications(ingredientList);
        System.out.println(ingredientNotification);
    }
    
    public static void main(String[] args) throws KitchenHelperException {
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
            CommandResult result = command.execute(ingredientList, recipeList, choreList);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
