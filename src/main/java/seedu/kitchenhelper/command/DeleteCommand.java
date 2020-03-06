package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    
    public static final String COMMAND_WORD = "delete";
    
    public void deleteIngredients(String attributes) {
    
    }
    
    public void deleteRecipe(String attributes) {
    
    }
    
    public void deleteChores(String attributes) {
    
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        return super.execute(ingredientList, recipeList, choreList);
    }
}
