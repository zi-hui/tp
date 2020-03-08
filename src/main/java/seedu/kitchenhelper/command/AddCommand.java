package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Perform addition-related commands.
 */
public class AddCommand extends Command {
    
    public static final String COMMAND_WORD = "add";
    public HashMap<String[], Integer> parsedIngr;

    /**
     * Set the object's type.
     *
     * @param object full user input string excluding the action word.
     */
    public void setTypeOfObject(String object) {
        String[] attributes = object.split("\\s+");
        if (attributes[0].equalsIgnoreCase("recipe")) {
            objectType = "recipe";
        } else if (attributes[0].equalsIgnoreCase("ingredient")) {
            objectType = "ingredient";
        } else if (attributes[0].equalsIgnoreCase("chore")) {
            objectType = "chore";
        }
    }

    /**
     * Set the attributes of the Command class.
     *
     * @param rawString full user input string.
     * @param ingrAndQty a hashmap of ingredient with [ingredientName, ingredientCategory] as key
     *                   and ingredientQuantity as value
     */
    public void setAttributesOfCmd(String rawString, HashMap<String[], Integer> ingrAndQty) {
        setTypeOfObject(rawString);
        setObjectVariables(rawString);
        setAction();
        this.parsedIngr = ingrAndQty;
    }

    public void setObjectVariables(String rawString) {
        objectVariables = rawString;
    }

    public void setAction() {
        actionType = COMMAND_WORD;
    }
    
    public void addIngredients(String attributes) {
    
    }

    @Override
    public String addRecipe(String attributes, ArrayList<Recipe> recipeList) throws KitchenHelperException {
        Recipe freshRecipe = new Recipe();
        freshRecipe.setRecipeName(attributes);
        freshRecipe.addIngredientsToRecipe(parsedIngr);
        recipeList.add(freshRecipe);
        return freshRecipe.recipeName + " Recipe has been created with "
                + freshRecipe.recipeIngrQty + " ingredients inside.";
    }
    
    public void addChores(String attributes) {
    
    }
    
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        return super.execute(ingredientList, recipeList, choreList);
    }
}
