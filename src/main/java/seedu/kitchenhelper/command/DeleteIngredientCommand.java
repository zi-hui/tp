package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class DeleteIngredientCommand extends Command{
    public static final String COMMAND_WORD = "deleteingredient";
    private static final String OBJECT_TYPE = "ingredient";
    private static int quantity = 0;

    /**
     * Constructor for Delete Ingredient Command.
     *
     * @param recipeName name of the recipe to be deleted
     * @param quantity number of serving of ingredient to be deleted
     */

    public DeleteIngredientCommand(String recipeName, int quantity) {
        setAction();
        setObjectType(OBJECT_TYPE);
        setAttributes(recipeName, quantity);
    }

    /**
     * To set the other attributes for DeleteIngredientCommand.
     * @param ingredientName The name of ingredient to be deleted
     * @param quantity number of serving of ingredient to be deleted
     */

    public void setAttributes(String ingredientName, int quantity) {
        objectVariables = ingredientName;
        this.quantity = quantity;
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
     * Getting the index of the ingredient to be deleted.
     *
     * @param ingredientName the name of the ingredient to be deleted
     * @param ingredientsList the list of ingredients
     * @return
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
     */

    public void updateNewQuantity(int newQuantity, Ingredient ingredientToDelete) {
        if (newQuantity < 0) {
            System.out.println("Please enter a valid quantity to delete! Currently: \n" +
                    ingredientToDelete.getIngredientName() + ":" + ingredientToDelete.getQuantity());;
        } else {
            ingredientToDelete.setQuantity(newQuantity);
            System.out.println("The quantity of " + ingredientToDelete.getIngredientName() + " has been changed!");
        }
    }

    /**
     * Delete the ingredient from the ingredient list.
     *
     * @param ingredientsList the list of ingredients
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
                updateNewQuantity(newQuantity, ingredientToDelete);
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
                                  ArrayList<Chore> choreList) throws KitchenHelperException {
        String feedbackToUser = deleteIngredient(ingredientList);
        System.out.println(feedbackToUser);
        return super.execute(ingredientList, recipeList, choreList);
    }
}
