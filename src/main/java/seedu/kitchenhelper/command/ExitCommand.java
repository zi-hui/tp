package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class ExitCommand extends Command {
    
    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_EXIT = "Exiting KitchenHelper as requested ...";

    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        return new CommandResult(MESSAGE_EXIT);
    }
}
