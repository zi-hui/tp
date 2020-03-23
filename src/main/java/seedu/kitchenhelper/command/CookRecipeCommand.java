package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

/**
 * Cooks a recipe.
 */
public class CookRecipeCommand extends Command {
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

    /**
     * Cooks a recipe as specified by user.
     *
     * @param ingredientList    the list of ingredients available to use.
     * @param recipeList        the list of recipe that is known.
     * @return the message after a successful cook.
     * @throws KitchenHelperException if there is no recipe that is wanted by user/ insufficient ingredients.
     */
    public String cookRecipe(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList)
            throws KitchenHelperException {
        // checks if the specified recipe given by user exists
        int indexOfRecipe = checkIfRecipeExist(recipeList);
        if (indexOfRecipe != recipeList.size()) {
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

    /**
     * Deducts ingredients from list of ingredients sorted on expiry.
     *
     * @param ingredientList    the list of ingredients available.
     * @param recipeToBeCooked  the recipe that the user want to cook.
     */
    public void deductIngredients(ArrayList<Ingredient> ingredientList, Recipe recipeToBeCooked) {
        for (Ingredient ingredient : recipeToBeCooked.getRecipeItem()) {
            // write a function to get all the ingredients with the same name
            // sort that output according to expiry im not sure if its already sorted
            // when u loop through the ingredient list
            // deduct accordingly - the ones that will expire first
        }
    }

    /**
     * Checks if the recipe user wants exist.
     *
     * @param recipeList    the list of recipes.
     * @return the index of the recipe in the list or the size of list if not found.
     */
    public int checkIfRecipeExist(ArrayList<Recipe> recipeList) {
        int counter = 0;
        for (Recipe recipe : recipeList) {
            if (recipeName.equalsIgnoreCase(recipe.recipeName)) {
                break;
            }
            counter += 1;
        }
        counter += 1;
        return counter;
    }

    /**
     * Checks if there is sufficient ingredient for each ingredient needed in recipe.
     *
     * @param ingredientList    the list of ingredients available.
     * @param recipeToBeCooked  the recipe that the user want to cook.
     * @return true if there are sufficient ingredients, otherwise false.
     */
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

    /**
     * Retrieves the quantity of each ingredient needed in the recipe.
     *
     * @param ingrName          the name of the required ingredient.
     * @param ingredientList    the list of ingredients available.
     * @return the quantity of ingredients with the same name.
     */
    public int getIngredientQty(String ingrName, ArrayList<Ingredient> ingredientList) {
        int availableIngrCount = 0;
        for (Ingredient ingr : ingredientList) {
            if (ingr.getIngredientName().equalsIgnoreCase(ingrName)) {
                availableIngrCount += ingr.getQuantity();
            }
        }
        return availableIngrCount;
    }

    /**
     * Sets the Recipe to be cooked.
     *
     * @param name  the name of the recipe to be cooked.
     */
    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    /**
     * Sets the number of pax for the recipe.
     *
     * @param numberofpax
     */
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
