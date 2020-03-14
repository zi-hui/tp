package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class ListChoreCommand extends Command {
    public static final String COMMAND_WORD = "listchore";

    public String listChore(ArrayList<Chore> choreList) {
        String feedbackToUser = "";
        if (choreList.size() == 0) {
            feedbackToUser = "Your list of chores is currently empty.";
        } else {
            feedbackToUser = "Here are the chores in your list:";
            for (int i = 0; i < choreList.size(); ++i) {
                feedbackToUser += ("\n" + Integer.toString(i + 1) + ". " + choreList.get(i));
            }
        }
        return feedbackToUser;
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        String feedbackToUser = listChore(choreList);
        return new CommandResult(feedbackToUser);
    }

}
