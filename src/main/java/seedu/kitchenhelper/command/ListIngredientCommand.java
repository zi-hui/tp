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
import java.util.HashMap;

public class ListIngredientCommand extends Command {
    
    public static final String COMMAND_WORD = "listingredient";
    private String category;
    public static final String COMMAND_FORMAT = "listingredient <all|dairy|drink|fruit|meat|"
        + "miscellaneous|staple|vegetable";
    public static final String[] categoryArray = {"all",Dairy.INGREDIENT_WORD,
        Drink.INGREDIENT_WORD,Fruit.INGREDIENT_WORD,
        Meat.INGREDIENT_WORD,Miscellaneous.INGREDIENT_WORD,
        Staple.INGREDIENT_WORD,Vegetable.INGREDIENT_WORD};

    /**
     * Constructor for ListIngredient Command.
     *
     * @param category   category of the ingredient.
     */
    public ListIngredientCommand(String category) {
        this.category = category;
        assert category.length() > 0;
    }

    public String listIngredients(String category, ArrayList<Ingredient> ingredientList) {
        String result = "Here is the list of Ingredients in Inventory:\n"
                + "Format : Ingredient Name | Quantity | Price | Expiry\n";
        if (ingredientList.size() == 0) {
            result += "The Ingredient List is currently empty.";
        } else {
            if (category.equalsIgnoreCase("all")) {
                for (String categoryName : categoryArray) {
                    result += categoryName + " :\n";
                    for (int i = 0; i < ingredientList.size(); i++) {
                        Ingredient ingredientObj = ingredientList.get(i);
                        if (ingredientObj.getCategoryName().equalsIgnoreCase(categoryName)) {
                            result += ingredientObj.getIngredientName() + " | " + ingredientObj.getQuantity() + " | "
                                    + ingredientObj.getPrice() + " | " + ingredientObj.getExpiryDate() + "\n";
                        }
                    }
                }
            } else {
                result += category + " : \n";
                for (int i = 0; i < ingredientList.size(); i++) {
                    Ingredient ingredientObj = ingredientList.get(i);
                    if (ingredientObj.getCategoryName().equalsIgnoreCase(category)) {
                        result += ingredientObj.getIngredientName() + " | " + ingredientObj.getQuantity() + " | "
                                + ingredientObj.getPrice() + " | " + ingredientObj.getExpiryDate() + "\n";
                    }

                    if (i == ingredientList.size()) {
                        result += "The Ingredient List for your category (" + category + ") is currently empty.";
                    }
                }
            }

        }
        return result;
    }

    public String getCategory() {
        return this.category;
    }

    public boolean checkCategoryValid() {
        boolean validCategory = false;
        for (String catName : categoryArray) {
            if (catName.equalsIgnoreCase(this.category)) {
                validCategory = true;
            }
        }
        return validCategory;
    }

    public String[] getCategoryArray() {
        return this.categoryArray;
    }

    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        String message = listIngredients(this.category, ingredientList);
        return new CommandResult(message);
    }
}
