package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class DeleteIngredientCommand extends Command {
    public static final String COMMAND_WORD = "deleteingredient";
    public static final String COMMAND_FORMAT = "deleteingredient /n INGREDIENT [/q QUANTITY]";
    private static final String OBJECT_TYPE = "ingredient";
    private static int quantity = 0;

    /**
     * Constructor for Delete Ingredient Command.
     *
     * @param ingredientName name of the ingredient to be deleted
     * @param quantity number of serving of ingredient to be deleted
     */

    public DeleteIngredientCommand(String ingredientName, int quantity) {
        setActionType(COMMAND_WORD);
        setObjectType(OBJECT_TYPE);
        setObjectVariables(ingredientName);
        this.quantity = quantity;
    }

    /**
     * Getting the index of the ingredient to be deleted.
     *
     * @param ingredientName the name of the ingredient to be deleted
     * @param ingredientsList the list of ingredients
     * @return index if the ingredient is found in the ingredient list, else -1
     */

    public int getIngredientIndex(String ingredientName, ArrayList<Ingredient> ingredientsList) {
        for (Ingredient ingredient : ingredientsList) {
            if (ingredient.getIngredientName().equalsIgnoreCase(ingredientName)) {
                int index = ingredientsList.indexOf(ingredient);
                return index;
            }
        }
        return -1;
    }

    /**
     * Update the quantity of an ingredient the ingredient list.
     *
     * @param newQuantity  the new quantity for the ingredient
     * @param ingredientToDelete the ingredient to be deleted
     * @return feedback to user
     */

    public String updateNewQuantity(int newQuantity, Ingredient ingredientToDelete) {
        String feedbackToUser;
        if (newQuantity < 0) {
            feedbackToUser = "Please enter a valid quantity to delete! \nCurrently: \n"
                    + ingredientToDelete.getIngredientName() + ":" + ingredientToDelete.getQuantity();
        } else {
            ingredientToDelete.setQuantity(newQuantity);
            feedbackToUser = "The quantity of " + ingredientToDelete.getIngredientName() + " has been changed!";
        }
        return feedbackToUser;
    }

    /**
     * Delete the ingredient from the ingredient list.
     *
     * @param ingredientsList the list of ingredients
     * @return feedback to user
     */

    public String deleteIngredient(ArrayList<Ingredient> ingredientsList) {
        String feedbackToUser = "";
        String ingredientName = this.objectVariables;
        int indexOfIngredient = getIngredientIndex(ingredientName, ingredientsList);
        if (indexOfIngredient != -1) {
            Ingredient ingredientToDelete = ingredientsList.get(indexOfIngredient);
            if (quantity <= -1) {
                ingredientsList.remove(ingredientToDelete);
                feedbackToUser = ingredientName + " has been deleted.";
            } else {
                int newQuantity = ingredientToDelete.getQuantity() - quantity;
                feedbackToUser = updateNewQuantity(newQuantity, ingredientToDelete);
            }
        } else {
            feedbackToUser = "This ingredient does not exist! Please type in a correct ingredient name.";
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
                                  ArrayList<Chore> choreList) {
        String feedbackToUser = deleteIngredient(ingredientList);
        CommandResult cmdResult = new CommandResult(feedbackToUser);
        return cmdResult;
    }
}
