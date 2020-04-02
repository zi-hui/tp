package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

public class ListRecipeCommand extends Command {

    public static final String COMMAND_WORD = "listrecipe";
    private String parameter;
    private int itemNumber;
    public static final String COMMAND_FORMAT = "listrecipe <item number/all>";
    public static final String COMMAND_DESC = "Display the recipe.";
    public static final String COMMAND_PARAMETER_LIMIT = "listingredient <item number> [Must be more than 0]";
    public static final String COMMAND_PARAMETER = "INTEGER";
    public static final String COMMAND_EXAMPLE = "Example: listrecipe 1";
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);

    /**
     * Constructor for ListRecipe Command.
     *
     * @param parameter   parameter for ListRecipe. Either 'all' or item number
     */
    public ListRecipeCommand(String parameter) {
        this.parameter = parameter;
        if (! parameter.equalsIgnoreCase("all")) {
            this.itemNumber = Integer.parseInt(parameter);
            assert itemNumber > 0;
        }
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

    public String listRecipe(String parameter, ArrayList<Recipe> recipeArrayList) {
        String result = "";
        if (parameter.equalsIgnoreCase("all")) {
            result = "\nHere is the list of Recipe:\n"
                    + "\nFormat:[Recipe Number] Recipe Name\n";
            if (recipeArrayList.size() == 0) {
                result += "The Recipe List is currently empty.";
            } else {
                for (int i = 0; i < recipeArrayList.size(); i++) {
                    result += "[" + (i + 1) + "] " + recipeArrayList.get(i).getRecipeName() + "\n";
                }
            }
        } else {
            int itemNum = this.itemNumber;
            result = "\nHere is the list of Ingredients in Recipe:"
                    + "\nFormat:Ingredient Name | Ingredient Category | Quantity\n";
            if (recipeArrayList.size() == 0 || itemNum > recipeArrayList.size() || itemNum < 0) {
                result += "The Recipe List is currently empty.";
            } else {
                Recipe recipeItem = recipeArrayList.get(itemNum - 1);
                result += "Recipe Name:" + recipeItem.getRecipeName() + "\n";
                ArrayList<Ingredient> ingredientByCategory = recipeItem.getRecipeItem();
                for (int i = 0; i < ingredientByCategory.size(); i++) {
                    Ingredient ingredientObj = ingredientByCategory.get(i);
                    result += "Ingredient Name : " + ingredientObj.getIngredientName()
                            + " | Category : " + ingredientObj.getCategoryName()
                            + " | " + Integer.toString(ingredientObj.getQuantity()) + " portion(s) \n";
                }
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
        String message = listRecipe(this.parameter, recipeList);
        return new CommandResult(message);
    }
}
