package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;

public class AddCommand extends Command {
    
    public static final String COMMAND_WORD = "add";
    public HashMap<String[], Integer> parsedIngr;

    public void setTypeOfObject(String object) {
        String[] attributes = object.split("\\s+");
        if(attributes[0].equalsIgnoreCase("recipe")) {
            objectType = "recipe";
        } else if (attributes[0].equalsIgnoreCase("ingredient")) {
            objectType = "ingredient";
        } else if (attributes[0].equalsIgnoreCase("chore")) {
            objectType = "chore";
        }
    }

    public void setAttributesOfCmd(String rawString, HashMap<String[], Integer> ingrAndQty) {
        setTypeOfObject(rawString);
        setObjectVariables(rawString);
        setAction();
        this.parsedIngr = ingrAndQty;
    }

    public void setObjectVariables(String rawString) {
        objectVariables = rawString;
    }

    public void setAction(){
        actionType = COMMAND_WORD;
    }
    
    public void addIngredients(String attributes) {
    
    }

    @Override
    public String addRecipe(String attributes, ArrayList<Recipe> recipeList) throws KitchenHelperException {
        Recipe freshRecipe = new Recipe();
        freshRecipe.setRecipeName(attributes);
        freshRecipe.addIngredientsToRecipe(parsedIngr);
        return freshRecipe.recipeName + " Recipe has been created with " + freshRecipe.recipeIngrQty + " ingredients inside.";
    }
    
    public void addChores(String attributes) {
    
    }
    
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList, ArrayList<Chore> choreList) throws KitchenHelperException {
        return super.execute(ingredientList, recipeList, choreList);
    }
}
