package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String INVALID_INDEX = "Please choose an index in the chore list!";
    public static final String MESSAGE_SUCCESS = "You have completed this chore:\n%s\n";
    public static final String COMMAND_DESC = "Marks a chore as done.";
    public static final String COMMAND_PARAMETER = "<index>";
    public static final String COMMAND_EXAMPLE = "Example: done 1";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);

    private int indexToCheck;

    public DoneCommand(int indexToCheck) {
        this.indexToCheck = indexToCheck;
    }

    public String markChoreDone(ArrayList<Chore> choreList) {
        try {
            if (indexToCheck > choreList.size()) {
                throw new KitchenHelperException(INVALID_INDEX);
            }
            Chore choreToCheck = choreList.get(indexToCheck - 1);
            choreToCheck.markAsDone();
            Storage.saveChoreData(choreList);
            return String.format(MESSAGE_SUCCESS, choreToCheck);
        } catch (KitchenHelperException khe) {
            return khe.getMessage();
        }
    }


    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        String feedbackToUser = markChoreDone(choreList);
        return new CommandResult(feedbackToUser);
    }
}
