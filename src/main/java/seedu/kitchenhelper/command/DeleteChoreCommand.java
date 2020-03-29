package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deletes a chore from the chore list.
 */
public class DeleteChoreCommand extends Command {

    public static final String COMMAND_WORD = "deletechore";
    public static final String DELETE_CHORE_MESSAGE_SUCCESS = "You have deleted this chore:\n%s\n"
            + "Now you have %s chore%s in the list.";
    public static final String INVALID_INDEX = "Please choose an index in the chore list!";
    public static final String DELETE_ALL_MESSAGE_SUCCESS = "You have deleted all the chores. "
            + "Now you have 0 chores in the list.";
    public static final String DELETE_ALL_PROMPT = "Are you sure you want to delete all the chores in your list?"
            + "\nEnter \"Yes\"/\"No\"";
    public static final String DELETE_ALL_CANCELLATION = "Ok then. Nothing has been deleted. "
            + "You still have %s chore%s in the list.";
    public static final String COMMAND_DESC = "Deletes a chore from the chore list.";
    public static final String COMMAND_PARAMETER = "<index>";
    public static final String COMMAND_EXAMPLE = "Example: deletechore 1";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);

    private int indexToDelete;
    private boolean isDeleteAll = false;

    /**
     * Constructor for DeleteChoreCommand.
     *
     * @param indexToDelete the index in the list of the chore to delete.
     */
    public DeleteChoreCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    public DeleteChoreCommand() {
        this.isDeleteAll = true;
    }

    /**
     * Deletes a chore from the chore list.
     *
     * @param choreList the list of Chores.
     * @return success message for successful deletion and error message for invalid index specified.
     */
    public String deleteChore(ArrayList<Chore> choreList) {
        try {
            if (indexToDelete > choreList.size()) {
                throw new KitchenHelperException(INVALID_INDEX);
            }
            Chore choreToDelete = choreList.get(indexToDelete - 1);
            choreList.remove(choreToDelete);
            Storage.saveChoreData(choreList);
            return String.format(DELETE_CHORE_MESSAGE_SUCCESS, choreToDelete, choreList.size(),
                    choreToDelete.checkSingular(choreList));
        } catch (KitchenHelperException khe) {
            return khe.getMessage();
        }
    }

    /**
     * Deletes all the chores in the list.
     *
     * @param choreList the list of Chores.
     * @return message success of deleting all chores or
     * message showing cancellation of action to delete all chores.
     */
    public String deleteAll(ArrayList<Chore> choreList) {
        String userResponse = promptUser();
        if (userResponse.equalsIgnoreCase("no")) {
            return String.format(DELETE_ALL_CANCELLATION, choreList.size(),
                    choreList.get(0).checkSingular(choreList));
        } else {
            choreList.clear();
            Storage.saveChoreData(choreList);
            return DELETE_ALL_MESSAGE_SUCCESS;
        }
    }

    /**
     * Prompts user to ensure user wants to delete all chores from list.
     *
     * @return user response to confirmation of deletion.
     */
    public String promptUser() {
        String userResponse;
        System.out.println(DELETE_ALL_PROMPT);
        userResponse = new Scanner(System.in).nextLine().trim();
        while (!isValidResponse(userResponse)) {
            System.out.println("Please enter either \"Yes\"/\"No\"");
            userResponse = new Scanner(System.in).nextLine().trim();
        }
        return userResponse;
    }

    /**
     * Checks if user responds with either "yes" or "no".
     *
     * @param userResponse user input in commandline.
     * @return True if user responds with either "yes" or "no".
     */
    public boolean isValidResponse(String userResponse) {
        String response = userResponse;
        if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList list of recipes.
     * @param choreList list of chores.
     * @return the success or error message of deleting one or all chores from the chore list.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        String feedbackToUser;
        if (isDeleteAll) {
            feedbackToUser = deleteAll(choreList);
        } else {
            feedbackToUser = deleteChore(choreList);
        }
        return new CommandResult(feedbackToUser);
    }
}

