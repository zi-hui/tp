package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class ListCommand extends Command {
    
    public static final String COMMAND_WORD = "list";

    public void listIngredients(String attributes) {
    
    }
    
    public void listRecipe(String attributes) {
    
    }
    
    @Override
    public String listChore(ArrayList<Chore> choreList) {
        String feedbackToUser = "";
        if (choreList.size() == 0) {
            feedbackToUser = "Your list of chores is currently empty.";
        } else {
            feedbackToUser = "Here are the chores in your list:\n"
            for (int i = 0; i < choreList.size(); ++i) {
                feedbackToUser += (Integer.toString(i+1) + ". " + choreList.get(i) + "\n");
            }
        }
        return feedbackToUser;
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        return super.execute(ingredientList, recipeList, choreList);
    }
}
