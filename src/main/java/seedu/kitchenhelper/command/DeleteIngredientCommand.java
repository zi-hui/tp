package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteIngredientCommand extends Command {
    public static final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static final String COMMAND_WORD = "deleteingredient";
    public static final String COMMAND_USAGE = "deleteingredient /n INGREDIENT [/q QUANTITY]";
    public static final String COMMAND_DESC = "Deletes an ingredient. ";
    public static final String COMMAND_EXAMPLE = "Example: deleteingredient /n Beef /q 2";
    public static final String COMMAND_FORMAT = String.format("%s%s\n%s", COMMAND_DESC, COMMAND_USAGE, COMMAND_EXAMPLE);
    public static final String COMMAND_SUCCESS = "%s has been deleted.";
    public static final String COMMAND_FAILURE = "This ingredient does not exist! Please type in a correct "
                                                    + "ingredient name.";
    public static final String COMMAND_SUCCESS_QUANTITY = "The quantity of %s has been changed!";
    public static final String COMMAND_FAILURE_QUANTITY = "Please enter a valid quantity to delete!\nCurrently:"
                                                            + "\n%s : %d";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_USAGE, COMMAND_EXAMPLE);
    public static final String LOG_INFO = "An ingredient has been deleted";
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
        String ingredientName = ingredientToDelete.getIngredientName();
        int ingredientQuantity = ingredientToDelete.getQuantity();

        if (newQuantity < 0) {
            feedbackToUser = String.format(COMMAND_FAILURE_QUANTITY, ingredientName, ingredientQuantity);
            assert ingredientQuantity != newQuantity;
        } else {
            ingredientToDelete.setQuantity(newQuantity);
            feedbackToUser = String.format(COMMAND_SUCCESS_QUANTITY, ingredientName);
            assert ingredientToDelete.getQuantity() == newQuantity;
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
            assert ingredientsList.size() > 0;
            Ingredient ingredientToDelete = ingredientsList.get(indexOfIngredient);
            if (quantity <= -1) {
                kitchenLogs.log(Level.INFO, LOG_INFO);
                ingredientsList.remove(ingredientToDelete);
                feedbackToUser = String.format(COMMAND_SUCCESS, ingredientName);
            } else {
                int newQuantity = ingredientToDelete.getQuantity() - quantity;
                feedbackToUser = updateNewQuantity(newQuantity, ingredientToDelete);
            }
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
                                  ArrayList<Chore> choreList) {
        String feedbackToUser = deleteIngredient(ingredientList);
        CommandResult cmdResult = new CommandResult(feedbackToUser);
        return cmdResult;
    }
}
