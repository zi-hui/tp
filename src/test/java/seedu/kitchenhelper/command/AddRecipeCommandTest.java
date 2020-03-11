package seedu.kitchenhelper.command;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.object.Recipe;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddRecipeCommandTest {

    @Test
    public void addRecipe_testPass() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        HashMap<String[], Integer> parsedIngr = new HashMap<>();
        String[] ingr = new String[2];
        ingr[0] = "milo";
        ingr[1] = "drink";
        parsedIngr.put(ingr, 10);
        String attributes = "recipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable";
        AddRecipeCommand newRecipe = new AddRecipeCommand();
        newRecipe.setAttributesOfCmd(attributes, parsedIngr);
        newRecipe.addRecipe(attributes, recipeList);
        assertEquals(1, recipeList.size());
    }

    @Test
    public void addRecipe_testFail() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        HashMap<String[], Integer> parsedIngr = new HashMap<>();
        String[] ingr = new String[2];
        ingr[0] = "milo";
        ingr[1] = " ";
        parsedIngr.put(ingr, 10);
        String attributes = "recipe /n Chicken Salad /i Chicken Breast:2:meat, Lettuce:4:vegetable";
        AddRecipeCommand newRecipe = new AddRecipeCommand();
        newRecipe.setAttributesOfCmd(attributes, parsedIngr);
        System.out.println();
        newRecipe.addRecipe(attributes, recipeList);
        assertNotEquals("drink", recipeList.get(0).getRecipeItem().getClass());
    }
}
