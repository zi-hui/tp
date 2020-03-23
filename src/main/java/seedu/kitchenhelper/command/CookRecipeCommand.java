package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

public class CookRecipeCommand extends Command{
    public static final String COMMAND_WORD = "cookrecipe";
    public static final String COMMAND_DESC = "Cooks a recipe from the recipe list.";
    public static final String COMMAND_PARAMETER
            = "/n RECIPENAME /p NUMOFPAX";
    public static final String COMMAND_EXAMPLE
            = "Example: cookrecipe /n Chicken Salad /p 2";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public String recipeName;
    public int pax;

    public String cookRecipe(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList) throws KitchenHelperException {
        // checks if the specified recipe given by user exists
        int indexOfRecipe = checkIfRecipeExist(recipeList);
        if (indexOfRecipe!= recipeList.size()) {
            throw new KitchenHelperException("The given recipe name does not exist");
        }
        System.out.println("Kitchen Helper is trying to cook!");
        Recipe recipeToBeCooked = recipeList.get(indexOfRecipe - 1);

        if (checkForSufficientIngredient(ingredientList, recipeToBeCooked)) {
            deductIngredients(ingredientList, recipeToBeCooked);
        } else {
            throw new KitchenHelperException("There are insufficient/ missing ingredients!");
        }

        return recipeName + " was cooked with a pax of " + pax;
    }

    public void deductIngredients(ArrayList<Ingredient> ingredientList, Recipe recipeToBeCooked) {
        for (Ingredient ingredient : recipeToBeCooked.getRecipeItem()) {
            // write a function to get all the ingredients with the same name
            // sort that output according to expiry im not sure if its already sorted
            // when u loop through the ingredient list
            // deduct accordingly - the ones that will expire first
        }
    }

    public int checkIfRecipeExist(ArrayList<Recipe> recipeList) {
        int counter = 0;
        for (Recipe recipe : recipeList) {
            if (recipeName.equalsIgnoreCase(recipe.recipeName)) {
                break;
            }
            counter += 1;
        }
        counter +=1;
        return counter;
    }

    public Boolean checkForSufficientIngredient(ArrayList<Ingredient> ingredientList, Recipe recipeToBeCooked) {
        boolean isSufficient = true;
        for (Ingredient ingr : recipeToBeCooked.getRecipeItem()) {
            int totalCookedQty = pax * ingr.getQuantity();
            if (getIngredientQty(ingr.getIngredientName().toLowerCase(), ingredientList) < totalCookedQty) {
                isSufficient = false;
            }
        }
        return isSufficient;
    }

    public int getIngredientQty(String ingrName, ArrayList<Ingredient> ingredientList) {
        int availableIngrCount = 0;
        for (Ingredient ingr : ingredientList) {
            if (ingr.getIngredientName().equalsIgnoreCase(ingrName)) {
                availableIngrCount += ingr.getQuantity();
            }
        }
        return availableIngrCount;
    }

    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    public void setRecipePax(int numberofpax) {
        this.pax = numberofpax;
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the success message of adding recipe.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        try {
            String message = cookRecipe(ingredientList, recipeList);
            return new CommandResult(message);
        } catch (KitchenHelperException e) {
            return new CommandResult("There are insufficient/ missing ingredients!");
        }
    }
}
