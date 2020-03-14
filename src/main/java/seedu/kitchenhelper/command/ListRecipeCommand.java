package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Vegetable;
import seedu.kitchenhelper.object.ingredient.Staple;
import seedu.kitchenhelper.object.ingredient.Miscellaneous;
import seedu.kitchenhelper.object.ingredient.Dairy;
import seedu.kitchenhelper.object.ingredient.Drink;
import seedu.kitchenhelper.object.ingredient.Fruit;
import seedu.kitchenhelper.object.ingredient.Meat;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class ListRecipeCommand extends Command {

    public static final String COMMAND_WORD = "listrecipe";
    private int itemNumber;
    public static final String COMMAND_FORMAT = "listrecipe <item number>";

    /**
     * Constructor for ListIngredient Command.
     *
     * @param itemNumber   category of the ingredient.
     */
    public ListRecipeCommand(int itemNumber) {
        this.itemNumber = itemNumber;
        assert itemNumber > 0;
    }


    public int getItemNumber() {
        return this.itemNumber;
    }

    public boolean checkItemValid(int itemNumber, ArrayList<Recipe> recipeArrayList) {
        boolean validItem = false;
        if (itemNumber <= recipeArrayList.size() && itemNumber > 0) {
            validItem = true;
        }
        return validItem;
    }

    public String listRecipe(int itemNum, ArrayList<Recipe> recipeArrayList) {
        String result = "\nHere is the list of Ingredients in Recipe:"
                + "\nFormat : Ingredient Name | Ingredient Category | Quantity | Price | Expiry\n";
        if (recipeArrayList.size() == 0 || itemNum > recipeArrayList.size() || itemNum < 0) {
            result += "The Recipe List is currently empty.";
        } else {
            Recipe recipeItem = recipeArrayList.get(itemNum - 1);
            result += "Recipe Name : " + recipeItem.getRecipeName() + "\n";
            for (int i = 0; i < recipeItem.getRecipeItem().size(); i++) {
                Ingredient ingredientObj = recipeItem.getRecipeItem().get(i);
                result += ingredientObj.getIngredientName() + " | " + ingredientObj.getCategoryName()
                        + " | " + ingredientObj.getQuantity() + " | "
                        + ingredientObj.getPrice() + " | " + ingredientObj.getExpiryDate() + " \n";
            }
        }
        return result;
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
        String message = listRecipe(this.itemNumber, recipeList);
        return new CommandResult(message);
    }
}
