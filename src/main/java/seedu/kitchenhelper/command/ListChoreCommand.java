package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class ListChoreCommand extends Command {

    public static final String COMMAND_WORD = "listchore";
    public static final String COMMAND_FORMAT = "listchore *No additional input";



    public boolean checkItemValid(int itemNumber, ArrayList<Chore> choreList) {
        boolean validItem = false;
        if (itemNumber <= choreList.size() && itemNumber > 0) {
            validItem = true;
        }
        return validItem;
    }

    
    @Override
    public String listChore(ArrayList<Chore> choreList) {
        String feedbackToUser = "";
        if (choreList.size() == 0) {
            feedbackToUser = "Your list of chores is currently empty.";
        } else {
            feedbackToUser = "Here are the chores in your list:\n";
            for (int i = 0; i < choreList.size(); ++i) {
                feedbackToUser += (Integer.toString(i + 1) + ". " + choreList.get(i) + "\n");
            }
        }
        return feedbackToUser;
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        String message = listChore(choreList);
        return new CommandResult(message);
    }
}
