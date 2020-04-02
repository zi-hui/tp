package seedu.kitchenhelper.storage;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.Chore;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {
    private static String currentDirectory = System.getProperty("user.dir");
    public static final String OUTPUT_INGREDIENT = currentDirectory + "/src/test/data/StorageTest/outputIngredient.txt";
    public static final String OUTPUT_RECIPE = currentDirectory + "/src/test/data/StorageTest/outputRecipe.txt";
    public static final String OUTPUT_CHORE = currentDirectory + "/src/test/data/StorageTest/outputChore.txt";
    public static final String OUTPUT_EXPENDITURE = currentDirectory
            + "/src/test/data/StorageTest/outputExpenditure.txt";
    public static final String NEW_OUTPUT_INGREDIENT = currentDirectory
            + "/src/test/data/NewStorageTest/outputIngredient.txt";
    public static final String NEW_OUTPUT_RECIPE = currentDirectory + "/src/test/data/NewStorageTest/outputRecipe.txt";
    public static final String NEW_OUTPUT_CHORE = currentDirectory + "/src/test/data/NewStorageTest/outputChore.txt";
    public static final String NEW_OUTPUT_EXPENDITURE = currentDirectory
            + "/src/test/data/NewStorageTest/outputExpenditure.txt";


    public Storage storage = new Storage(OUTPUT_INGREDIENT, OUTPUT_RECIPE, OUTPUT_CHORE, OUTPUT_EXPENDITURE);

    @Test
    void getIngredientDataTest() {
        try {
            Storage newStorage = new StubStorage();
            List<Ingredient> ingredients = storage.getIngredientData();
            List<Ingredient> stubIngredients = newStorage.getIngredientData();
            assertEquals(ingredients, stubIngredients);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    void getRecipeData() {
        try {
            Storage newStorage = new StubStorage();
            List<Recipe> recipe = storage.getRecipeData();
            List<Recipe> stubRecipe = newStorage.getRecipeData();
            assertEquals(recipe, stubRecipe);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    void getChoreData() {
        try {
            Storage newStorage = new StubStorage();
            List<Chore> chore = storage.getChoreData();
            List<Chore> stubChore = newStorage.getChoreData();
            assertEquals(chore, stubChore);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    void saveIngredientData() {
    }

    @Test
    void saveRecipeData() {
    }

    @Test
    void saveChoreData() {
    }

    private class StubStorage extends Storage {
        public StubStorage() {
            super(NEW_OUTPUT_INGREDIENT, NEW_OUTPUT_RECIPE, NEW_OUTPUT_CHORE, NEW_OUTPUT_EXPENDITURE);
        }

        @Override
        public ArrayList<Ingredient> getIngredientData() throws FileNotFoundException {
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            loadingIngredients("Beef", "meat", 3, 20.0, "2020-03-18",ingredients);
            loadingIngredients("Chicken", "meat", 3, 20.0, "2020-03-18", ingredients);
            return ingredients;
        }

        @Override
        public ArrayList<Recipe> getRecipeData() throws FileNotFoundException {
            Recipe freshRecipe = new Recipe();
            ArrayList<Ingredient> recipeItems = new ArrayList<>();
            freshRecipe.setRecipeNameForStorage("Chicken Salad");
            freshRecipe.recipeIngrQty = 2;
            loadingRecipeItems("Chicken Breast", "meat", 2, 0.0, "null", recipeItems);
            loadingRecipeItems("Lettuce", "vegetable", 4, 0.0, "null", recipeItems);
            freshRecipe.addIngredientsToRecipeFromArrayList(recipeItems);
            ArrayList<Recipe> recipe = new ArrayList<>();
            recipe.add(freshRecipe);
            recipe.add(freshRecipe);
            return recipe;
        }

        @Override
        public ArrayList<Chore> getChoreData() throws FileNotFoundException {
            ArrayList<Chore> chore = new ArrayList<>();
            Chore todo = Chore.createChoreWhenLoadFile("buy milk", "Tuesday 12pm");
            chore.add(todo);
            return chore;
        }
    }
}