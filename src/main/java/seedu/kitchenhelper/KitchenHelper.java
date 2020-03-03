package seedu.kitchenhelper;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.CommandResult;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.parser.Parser;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

public class KitchenHelper {
    
    private ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ArrayList<Chore> choreList = new ArrayList<>();
    /* Hi pls, look at this main program.
     * https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/Main.java */

    private Ui ui;
    
    private void start() {
        ui = new Ui();
        ui.showWelcomeMessage();
    }
    
    private void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }
    
    private void exit() {
        System.exit(0);
    }
    
    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandInput;
        do {
            userCommandInput = ui.getUserCommand();
            command = new Parser().parseUserCommand(userCommandInput);
            CommandResult result = executeCommand(command);
            ui.showResultToUser(result);
        } while (!userCommandInput.equalsIgnoreCase(ExitCommand.COMMAND_WORD));
        
    }
    
    public static void main(String[] args) {
        new KitchenHelper().run();
    }
    
    private CommandResult executeCommand(Command command) {
        try {
            CommandResult result = command.execute();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
