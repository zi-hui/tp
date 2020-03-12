package seedu.kitchenhelper.object;

import seedu.kitchenhelper.object.ingredient.Dairy;
import seedu.kitchenhelper.object.ingredient.Drink;
import seedu.kitchenhelper.object.ingredient.Fruit;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.ingredient.Meat;
import seedu.kitchenhelper.object.ingredient.Miscellaneous;
import seedu.kitchenhelper.object.ingredient.Staple;
import seedu.kitchenhelper.object.ingredient.Vegetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A Recipe represents a collection of ingredients of different types.
 */
public class Recipe {
    ArrayList<Ingredient> recipeItems = new ArrayList<>();
    public String recipeName;
    public Integer recipeIngrQty;

    /**
     * Prepares the addition of ingredients into recipe.
     *
     * @param ingrAndQty the hashmap of ingredients.
     */
    public void addIngredientsToRecipe(HashMap<String[], Integer> ingrAndQty) {
        for (Map.Entry<String[], Integer> entry : ingrAndQty.entrySet()) {
            String ingrName = (entry.getKey())[0];
            String ingrCategory = (entry.getKey())[1];
            Integer ingrQuantity = entry.getValue();
            Ingredient newIngredient = createIngr(ingrName, ingrCategory, ingrQuantity);
            recipeItems.add(newIngredient);
        }
        recipeIngrQty = recipeItems.size();
    }

    /**
     * Prepares the addition of ingredients into recipe.
     *
     * @param ingrName the name of the ingredient.
     * @param ingrCategory the category of the ingredient.
     * @param ingrQuantity the quantity of the ingredient.
     * @return Ingredient specific to its category.
     */
    public Ingredient createIngr(String ingrName, String ingrCategory, Integer ingrQuantity) {
        switch (ingrCategory.toLowerCase()) {
        case "dairy":
            return new Dairy(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "drink":
            return new Drink(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "fruit":
            return new Fruit(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "meat":
            return new Meat(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "miscellaneous":
            return new Miscellaneous(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "staple":
            return new Staple(ingrName, ingrCategory, ingrQuantity, 0, null);
        case "vegetable":
            return new Vegetable(ingrName, ingrCategory, ingrQuantity, 0, null);
        default:
            return null;
        }
    }

    public void setRecipeName(String attributes) {
        String recipeNameAndIngr = attributes.substring(attributes.indexOf("/n") + 3, attributes.indexOf("/i") - 1);
        recipeName = recipeNameAndIngr;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public ArrayList<Ingredient> getRecipeItem() {
        System.out.println(recipeItems.size());
        return this.recipeItems;
    }
}
