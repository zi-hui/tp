package seedu.kitchenhelper.object;

import seedu.kitchenhelper.object.ingredient.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Recipe {
    ArrayList<Ingredient> recipeItems = new ArrayList<>();
    public String recipeName;
    public Integer recipeIngrQty;

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

    public Ingredient createIngr(String ingrName, String ingrCategory, Integer ingrQuantity) {
        switch (ingrCategory.toLowerCase()){
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
        }
        return null;
    }

    public void setRecipeName(String attributes) {
        String recipeNameAndIngr = attributes.substring(attributes.indexOf("/n")+3, attributes.indexOf("/i")-1);
        recipeName = recipeNameAndIngr;
    }
}
