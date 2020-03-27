package seedu.kitchenhelper.command;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.ingredient.Meat;
import seedu.kitchenhelper.parser.Parser;
import seedu.kitchenhelper.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchIngredientCommandTest {
    
    @Test
    void execute_notEmpty() throws KitchenHelperException, IOException {
        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        ArrayList<Chore> choreArrayList = new ArrayList<>();
        ingredientArrayList.add(new Meat("Beef", "meat", 3, 20, "2020-03-18"));
        ingredientArrayList.add(new Meat("Beef cubes", "meat", 3, 20, "2020-03-18"));
        String expectedOutput = "Here are your matching ingredients in your list"
                                + Ui.LS
                                + "1.[Meat] Beef Qty:3 $20.0 Exp:2020-03-18"
                                + Ui.LS
                                + "2.[Meat] Beef cubes Qty:3 $20.0 Exp:2020-03-18";
        String output = new Parser().parseUserCommand("searchingredient beef")
                .execute(ingredientArrayList, recipeArrayList, choreArrayList).feedbackToUser;
        assertEquals(expectedOutput, output);
    }
    
    @Test
    void execute_empty() throws KitchenHelperException, IOException {
        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        ArrayList<Chore> choreArrayList = new ArrayList<>();
        String expectedOutput = "There are no matching ingredient in your list.";
        String output = new Parser().parseUserCommand("searchingredient beef")
                .execute(ingredientArrayList, recipeArrayList, choreArrayList).feedbackToUser;
        assertEquals(expectedOutput, output);
    }
    
    @Test
    void execute_notFound() throws KitchenHelperException, IOException {
        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        ArrayList<Chore> choreArrayList = new ArrayList<>();
        ingredientArrayList.add(new Meat("Beef", "meat", 3, 20, "2020-03-18"));
        ingredientArrayList.add(new Meat("Beef cubes", "meat", 3, 20, "2020-03-18"));
        String expectedOutput = "There are no matching ingredient in your list.";
        String output = new Parser().parseUserCommand("searchingredient pork")
                .execute(ingredientArrayList, recipeArrayList, choreArrayList).feedbackToUser;
        assertEquals(expectedOutput, output);
    }
}
