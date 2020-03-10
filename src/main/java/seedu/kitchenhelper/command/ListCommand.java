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

import java.util.ArrayList;
import java.util.HashMap;

public class ListCommand extends Command {
    
    public static final String COMMAND_WORD = "list";

    public static final String COMMAND_FORMAT = "list ingredient";

    public void setListParams(HashMap<String, String> attributes) {
        actionType = COMMAND_WORD;
        setTypeOfObject(attributes.get("type"));
        if (attributes.size() == 2) {
            objectVariables = attributes.get("item");
        }
    }

    public void setTypeOfObject(String object) {
        String[] attributes = object.split("\\s");
        if (attributes[0].equalsIgnoreCase("recipe")) {
            objectType = "recipe";
        } else if (attributes[0].equalsIgnoreCase("ingredient")) {
            objectType = "ingredient";
        } else if (attributes[0].equalsIgnoreCase("chore")) {
            objectType = "chore";
        }
    }

    public String listIngredients(ArrayList<Ingredient> ingredientList) {
        String result = "Here is the list of Ingredients in Inventory:\n"
                + "Format : Ingredient Name | Quantity | Price | Expiry\n";
        String[] categoryArray = {Dairy.INGREDIENT_WORD, Drink.INGREDIENT_WORD, Fruit.INGREDIENT_WORD,
            Meat.INGREDIENT_WORD, Miscellaneous.INGREDIENT_WORD, Staple.INGREDIENT_WORD, Vegetable.INGREDIENT_WORD};
        if (ingredientList.size() == 0) {
            result += "The Ingredient List is currently empty.";
        } else {
            for (String categoryName : categoryArray) {
                result += categoryName + " : \n";
                for (int i = 0; i < ingredientList.size(); i++) {
                    Ingredient ingredientObj = ingredientList.get(i);
                    if (ingredientObj.getCategoryName().equals(categoryName)) {
                        result += ingredientObj.getIngredientName() + " | " + ingredientObj.getQuantity() + " | "
                                + ingredientObj.getPrice() + " | " + ingredientObj.getExpiryDate() + " \n";
                    }
                }
            }
        }
        return result;
    }

    public String listRecipe(String itemNumber, ArrayList<Recipe> recipeArrayList) {
        int itemNum = Integer.parseInt(itemNumber) - 1;
        String result = "\nHere is the list of Ingredients in Recipe:"
                + "\nFormat : Ingredient Name | Ingredient Category | Quantity | Price | Expiry\n";
        if (recipeArrayList.size() == 0 || (itemNum + 1) > recipeArrayList.size()) {
            result += "The Recipe List is currently empty.";
        } else {
            Recipe recipeItem = recipeArrayList.get(itemNum);
            result += "Recipe Name : " + recipeArrayList.get(itemNum).getRecipeName() + "\n";
            for (int i = 0; i < recipeItem.getRecipeItem().size(); i++) {
                Ingredient ingredientObj = recipeItem.getRecipeItem().get(i);
                result += ingredientObj.getIngredientName() + " | " + ingredientObj.getCategoryName()
                        + " | " + ingredientObj.getQuantity() + " | "
                        + ingredientObj.getPrice() + " | " + ingredientObj.getExpiryDate() + " \n";
            }
        }
        return result;
    }

    public void executeIngredientStorage(ArrayList<Ingredient> ingredientList, Storage storage){

    }

    public void executeChoreStorage(ArrayList<Chore> choreList, Storage storage){

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
        return super.execute(ingredientList, recipeList, choreList);
    }
}
