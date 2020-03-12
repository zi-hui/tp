package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class DeleteRecipeCommand extends Command {
    public static final String COMMAND_WORD = "deleterecipe";
    private static final String OBJECT_TYPE = "recipe";

    public DeleteRecipeCommand(String recipeName) {
        setAction();
        setObjectType(OBJECT_TYPE);
        setAttributes(recipeName);
    }

    public void setAttributes(String recipeName) {
        objectVariables = recipeName;
    }

    /**
     * Set the Action Type for the Command (delete).
     */

    public void setAction() {
        actionType = COMMAND_WORD;
    }

    /**
     * Set the Object Type for the Command.
     *
     * @param type the name of the object type
     */

    public static void setObjectType(String type) {
        objectType = type;
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
            recipeList.remove(recipeList.get(index));
            feedbackToUser = recipeName + " has been deleted.";
        } else {
            feedbackToUser = "This recipe does not exist! Please type in a correct recipe name.";
        }
        return feedbackToUser;
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
