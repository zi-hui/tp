package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

/**
 * Abstract class to represent user's command.
 */
public abstract class Command {
    
    public static String actionType; //add, delete, list
    public static String objectType; //ingredient, recipe, chore
    public static String objectVariables;
    
    public Command() {
    }

    public String addRecipe(String attributes, ArrayList<Recipe> recipeList) throws KitchenHelperException {
        return "";
    }

    /**
     * Runs the command given by user.
     *
     * @param ingredientList list of ingredients.
     * @param recipeList list of recipes.
     * @param choreList list of chores.
     * @return cmdResult response given to user after successful execution.
     * @throws KitchenHelperException if the command is invalid.
     */
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        //throw new UnsupportedOperationException();
        String feedbackToUser = "";
        if (actionType.equals(AddCommand.COMMAND_WORD) && objectType.equals("recipe")) {
            feedbackToUser = addRecipe(objectVariables, recipeList);
        } else if (actionType.equals(AddCommand.COMMAND_WORD) && objectType.equals("ingredient")) {
            // change here for your part!
            System.out.println("hello add ingr");
        } else if (actionType.equals(AddCommand.COMMAND_WORD) && objectType.equals("chore")) {
            System.out.println("hello add chore");
        }
        CommandResult cmdResult = new CommandResult(feedbackToUser);
        return cmdResult;
    }
}
