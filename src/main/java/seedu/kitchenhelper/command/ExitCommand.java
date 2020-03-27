package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

public class ExitCommand extends Command {
    
    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_EXIT = "Exiting KitchenHelper as requested ...";
    public static final String COMMAND_DESC = "Exits the program";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Example: %s", COMMAND_WORD);

    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        return new CommandResult(MESSAGE_EXIT);
    }
}
