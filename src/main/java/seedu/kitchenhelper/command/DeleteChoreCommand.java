package seedu.kitchenhelper.command;

import seedu.kitchenhelper.KitchenHelper;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;

import java.util.ArrayList;

/**
 * Deletes a chore from the chore list.
 */
public class DeleteChoreCommand extends Command {

    public static final String COMMAND_WORD = "deletechore";
    public static final String MESSAGE_SUCCESS = "You have deleted this chore:\n%s\n"
            + "Now you have %s chore%s in the list.";
    public static final String COMMAND_DESC = "Deletes a chore from the chore list.";
    public static final String COMMAND_PARAMETER = "<index>";
    public static final String COMMAND_EXAMPLE = "Example: deletechore 1";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);

    private int indexToDelete;

    public void executeIngredientStorage(ArrayList<Ingredient> ingredientList, Storage storage){

    }

    public void executeChoreStorage(ArrayList<Chore> choreList, Storage storage){

    }

    public void executeRecipeStorage(ArrayList<Recipe> recipeList, Storage storage){

    }

    /**
     * Constructor for DeleteChoreCommand.
     *
     * @param indexToDelete the index in the list of the chore to delete.
     */
    public DeleteChoreCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    /**
     * Deletes a chore from the chore list.
     *
     * @param choreList the ArrayList of chores.
     * @return success message for successful deletion and error message for invalid index specified.
     */
    public String deleteChore(ArrayList<Chore> choreList) {
        try {
            if (indexToDelete > choreList.size()) {
                throw new KitchenHelperException("Please choose an index in the chore list!");
            }
            Chore choreToDelete = choreList.get(indexToDelete - 1);
            choreList.remove(choreToDelete);
            Storage.saveChoreData(choreList);
            return String.format(MESSAGE_SUCCESS, choreToDelete, choreList.size(),
                    choreToDelete.checkSingular(choreList));
        } catch (KitchenHelperException khe) {
            return khe.getMessage();
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList list of recipes.
     * @param choreList list of chores.
     * @return the success or error message of deleting a chore from the chore list.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        String feedbackToUser = deleteChore(choreList);
        return new CommandResult(feedbackToUser);
    }
}

