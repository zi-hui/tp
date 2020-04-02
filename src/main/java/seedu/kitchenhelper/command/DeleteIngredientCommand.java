package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Expenditure;
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
    public static final String COMMAND_USAGE = "Usage: deleteingredient /n INGREDIENTNAME [/q QUANTITY] OR "
                                                + "deleteingredient /i INGREDIENTINDEX [/q QUANTITY]";
    public static final String COMMAND_PARAMETER = "/n INGREDIENTNAME [/q QUANTITY] OR"
                                                    + "/i INGREDIENTINDEX [/q QUANTITY]";
    public static final String COMMAND_DESC = "Deletes an ingredient. ";
    public static final String COMMAND_EXAMPLE = "Example: deleteingredient /n Beef /q 2 OR deleteingredient /i 1 /q 2";
    public static final String COMMAND_FORMAT = String.format("%s\n%s\n%s", COMMAND_DESC, COMMAND_USAGE,
                                                            COMMAND_EXAMPLE);
    public static final String COMMAND_SUCCESS = "%s has been deleted.";
    public static final String COMMAND_FAILURE = "This ingredient does not exist! Please type in a correct "
                                                    + "ingredient name/index.";
    public static final String COMMAND_SUCCESS_QUANTITY = "The quantity of %s has been changed!";
    public static final String COMMAND_FAILURE_QUANTITY = "Please enter a valid quantity to delete!\nCurrently:"
                                                            + "\n%s : %d";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String LOG_INFO = "An ingredient has been deleted";
    private static final String OBJECT_TYPE = "ingredient";
    private Integer quantity;
    private Integer ingredientIndex;

    /**
     * Constructor for Delete Ingredient Command.
     *
     * @param ingredientIndex index of the ingredient to be deleted
     * @param quantity number of serving of ingredient to be deleted
     */

    public DeleteIngredientCommand(Integer ingredientIndex, Integer quantity) {
        setActionType(COMMAND_WORD);
        setObjectType(OBJECT_TYPE);
        this.quantity = quantity;
        this.ingredientIndex = ingredientIndex;
    }

    /**
     * Constructor for Delete Ingredient Command.
     *
     * @param ingredientName name of the ingredient to be deleted
     * @param quantity number of serving of ingredient to be deleted
     */

    public DeleteIngredientCommand(String ingredientName, Integer quantity) {
        setActionType(COMMAND_WORD);
        setObjectType(OBJECT_TYPE);
        setObjectVariables(ingredientName);
        this.quantity = quantity;
        this.ingredientIndex = null;
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
     * Delete the ingredient by name.
     *
     * @param ingredientsList the list of ingredients
     * @return feedback to user
     */

    public String deleteIngredientByName(ArrayList<Ingredient> ingredientsList) {
        int ingredientIndex = getIngredientIndex(this.objectVariables, ingredientsList);
        String feedbackToUser = deleteIngredient(ingredientsList, ingredientIndex);
        return feedbackToUser;
    }

    /**
     * Delete the ingredient by index.
     *
     * @param ingredientsList the list of ingredients
     * @return feedback to user
     */

    public String deleteIngredientByIndex(ArrayList<Ingredient> ingredientsList) {
        int ingredientIndex = this.ingredientIndex;
        String feedbackToUser = deleteIngredient(ingredientsList, ingredientIndex);
        return feedbackToUser;
    }

    /**
     * Delete the ingredient from the ingredient list.
     *
     * @param ingredientsList the list of ingredients
     * @return feedback to user
     */

    public String deleteIngredient(ArrayList<Ingredient> ingredientsList, Integer indexOfIngredient) {
        String feedbackToUser;
        if (indexOfIngredient > -1 && indexOfIngredient < ingredientsList.size()) {
            assert indexOfIngredient >= 0;
            Ingredient ingredientToDelete = ingredientsList.get(indexOfIngredient);
            String ingredientName = ingredientToDelete.getIngredientName();
            int ingredientQuantity = ingredientToDelete.getQuantity();
            if (quantity == null) {
                kitchenLogs.log(Level.INFO, LOG_INFO);
                ingredientsList.remove(ingredientToDelete);
                feedbackToUser = String.format(COMMAND_SUCCESS, ingredientName);
            } else if (quantity > 0) {
                int newQuantity = ingredientQuantity - quantity;
                feedbackToUser = updateNewQuantity(newQuantity, ingredientToDelete);
            } else {
                feedbackToUser = String.format(COMMAND_FAILURE_QUANTITY, ingredientName, ingredientQuantity);
            }
            Storage.saveIngredientData(ingredientsList);
            //Expenditure.getInstance().editExpenditure(ingredientToDelete, quantity);
        } else {
            feedbackToUser = COMMAND_FAILURE;
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
        String feedbackToUser;
        if (this.ingredientIndex == null) {
            feedbackToUser = deleteIngredientByName(ingredientList);
        } else {
            feedbackToUser = deleteIngredientByIndex(ingredientList);
        }
        CommandResult cmdResult = new CommandResult(feedbackToUser);
        return cmdResult;
    }
}
