package seedu.kitchenhelper.command;

import seedu.kitchenhelper.KitchenHelper;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class DeleteChoreCommand extends Command {
    public static final String COMMAND_WORD = "deletechore";
    public static final String MESSAGE_SUCCESS = "You have deleted this chore:\n%s\nNow you have %s chore%s in the list.";
    public static final String COMMAND_DESC = "Deletes a chore from the chore list.";
    public static final String COMMAND_PARAMETER = "<index>";
    public static final String COMMAND_EXAMPLE = "Example: deletechore 1";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);

    private int indexToDelete;

    public DeleteChoreCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    public String deleteChore(ArrayList<Chore> choreList) {
        try {
            if (indexToDelete > choreList.size()) {
                throw new KitchenHelperException("Please choose an index in the chore list!");
            }
            Chore choreToDelete = choreList.get(indexToDelete - 1);
            choreList.remove(choreToDelete);
            return String.format(MESSAGE_SUCCESS, choreToDelete, choreList.size(), choreToDelete.checkSingular(choreList));
        } catch (KitchenHelperException khe) {
            return khe.getMessage();
        }
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        String feedbackToUser = deleteChore(choreList);
        return new CommandResult(feedbackToUser);
    }
}

