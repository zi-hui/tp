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
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListRecipeCommand extends Command {

    public static final String COMMAND_WORD = "listrecipe";
    private int itemNumber;
    public static final String COMMAND_FORMAT = "listrecipe <item number>";
    public static final String COMMAND_DESC = "Display the recipe";
    public static final String COMMAND_PARAMETER = "INTEGER";
    public static final String COMMAND_EXAMPLE = "Example: listrecipe 1";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);

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
                + "\nFormat:Ingredient Name|Ingredient Category|Quantity|Price|Expiry\n";
        if (recipeArrayList.size() == 0 || itemNum > recipeArrayList.size() || itemNum < 0) {
            result += "The Recipe List is currently empty.";
        } else {
            Recipe recipeItem = recipeArrayList.get(itemNum - 1);
            result += "Recipe Name:" + recipeItem.getRecipeName() + "\n";
            ArrayList<Ingredient> ingredientByCategory = recipeItem.getRecipeItem();
            for (int i = 0; i < ingredientByCategory.size(); i++) {
                Ingredient ingredientObj = ingredientByCategory.get(i);
                result += ingredientObj.getIngredientName() + "|" + ingredientObj.getCategoryName()
                        + "|" + Integer.toString(ingredientObj.getQuantity()) + "|"
                        + Double.toString(ingredientObj.getPrice()) + "|" + ingredientObj.getExpiryDate() + "\n";
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList list of recipes.
     * @param choreList list of chores.
     * @return the list of recipes.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        String message = listRecipe(this.itemNumber, recipeList);
        return new CommandResult(message);
    }
}
