package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Resets the Data structures of the application.
 */
public class ResetCommand extends Command {
    public static final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static final String COMMAND_WORD = "reset";

    /**
     * Resets the arraylist contents that stores user's input.
     *
     * @param ingredientList    list of ingredients.
     * @param recipeList        list of recipes.
     * @param choreList         list of chores.
     * @return the message to be displayed on the console.
     */
    public String resetDatabase(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                ArrayList<Chore> choreList) {
        ingredientList.clear();
        recipeList.clear();
        choreList.clear();
        return "All data has been wiped";
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the message to be displayed on the console.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        String message = resetDatabase(ingredientList, recipeList, choreList);
        return new CommandResult(message);
    }
}
