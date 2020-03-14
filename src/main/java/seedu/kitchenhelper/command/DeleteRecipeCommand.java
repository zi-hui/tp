package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteRecipeCommand extends Command {
    public static final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static final String COMMAND_WORD = "deleterecipe";
    public static final String COMMAND_USAGE = "deleterecipe /n RECIPENAME";
    public static final String COMMAND_DESC = "Delete the recipe. ";
    public static final String COMMAND_EXAMPLE = "Example: deleterecipe /n Chicken Salad";
    public static final String COMMAND_FORMAT = String.format("%s%s\n%s", COMMAND_DESC, COMMAND_USAGE, COMMAND_EXAMPLE);
    public static final String COMMAND_SUCCESS = "%s has been deleted";
    public static final String COMMAND_FAILURE = "This recipe does not exist! Please type in a correct recipe name.";
    public static final String LOG_INFO = "A recipe has been deleted";
    private static final String OBJECT_TYPE = "recipe";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_USAGE, COMMAND_EXAMPLE);
    
    public DeleteRecipeCommand(String recipeName) {
        setActionType(COMMAND_WORD);
        setObjectType(OBJECT_TYPE);
        setObjectVariables(recipeName);
    }
    /**
     * Getting the index of the recipe to be deleted.
     *
     * @param recipeName the name of the recipe to be deleted
     * @param recipeList the list of recipe
     * @return
     */

    public int getRecipeIndex(String recipeName, ArrayList<Recipe> recipeList) {
        for (Recipe recipe : recipeList) {
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
                int index = recipeList.indexOf(recipe);
                return index;
            }
        }
        return -1;
    }

    /**
     * Delete the recipe for the recipe list.
     *
     * @param recipeList the list of recipe
     */

    public String deleteRecipe(ArrayList<Recipe> recipeList) {
        String feedbackToUser;
        String recipeName = this.objectVariables;
        int index = getRecipeIndex(recipeName, recipeList);
        if (index != -1) {
            assert recipeList.size() > 0;
            kitchenLogs.log(Level.INFO, LOG_INFO);
            recipeList.remove(recipeList.get(index));
            //Storage.saveRecipeData(recipeList);
            feedbackToUser = String.format(COMMAND_SUCCESS, recipeName);
        } else {
            feedbackToUser = COMMAND_FAILURE;
        }
        return feedbackToUser;
    }

    public void executeIngredientStorage(ArrayList<Ingredient> ingredientList, Storage storage){

    }

    public void executeChoreStorage(ArrayList<Chore> choreList, Storage storage){

    }

    public void executeRecipeStorage(ArrayList<Recipe> recipeList, Storage storage){

    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the execution of the deletion of ingredients or tasks.
     */

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                  ArrayList<Chore> choreList) throws KitchenHelperException {
        String feedbackToUser = deleteRecipe(recipeList);
        CommandResult cmdResult = new CommandResult(feedbackToUser);
        return cmdResult;
    }
}
