package seedu.kitchenhelper.command;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.object.ingredient.Ingredient;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteIngredientCommandTest {
    @Test
    public void deleteIngredient() {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        new AddIngredientCommand("Beef", "Meat", 30, 20.2, "2020-02-20")
                                .addToCategory("Meat", ingredientList);
        new AddIngredientCommand("kailan", "Vegetable", 30, 30.45, "2020-03-12")
                                .addToCategory("Vegetable", ingredientList);

        int index = 0;
        /*DeleteIngredientCommand deleteIngredientQuantity = new DeleteIngredientCommand("Beef", 2);
        index = deleteIngredientQuantity.getIngredientIndex("Beef", ingredientList);
        deleteIngredientQuantity.deleteIngredientByName(ingredientList);
        assertEquals(ingredientList.get(index).getQuantity(), 28);

        DeleteIngredientCommand deleteIngredientQuantityExceed = new DeleteIngredientCommand("Beef", 30);
        deleteIngredientQuantityExceed.deleteIngredientByName(ingredientList);
        assertEquals(ingredientList.get(index).getQuantity(), 28);

        DeleteIngredientCommand deleteKnownIngredient = new DeleteIngredientCommand("kailan", null);
        deleteKnownIngredient.deleteIngredientByName(ingredientList);
        assertEquals(ingredientList.size(), 1);

        DeleteIngredientCommand deleteUnknownIngredient = new DeleteIngredientCommand("chocolate", null);
        deleteUnknownIngredient.deleteIngredientByName(ingredientList);
        assertEquals(ingredientList.size(), 1);*/
    }

    @Test
    public void getIngredientIndex() {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        new AddIngredientCommand("Beef", "Meat", 30, 20.2, "2020-02-20")
                                .addToCategory("Meat", ingredientList);
        new AddIngredientCommand("kailan", "Vegetable", 30, 30.45, "2020-03-12")
                                .addToCategory("Vegetable", ingredientList);

        int index = 0;
        /*DeleteIngredientCommand deleteKnownIngredient = new DeleteIngredientCommand("kailan", -1);
        index = deleteKnownIngredient.getIngredientIndex("kailan", ingredientList);
        assertEquals(index, 1);

        DeleteIngredientCommand deleteUnknownIngredient = new DeleteIngredientCommand("Chocolate", 1);
        index = deleteUnknownIngredient.getIngredientIndex("Chocolate", ingredientList);
        assertEquals(index, -1);*/
    }

    @Test
    public void updateNewQuantity() {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        new AddIngredientCommand("Beef", "Meat", 30, 20.2, "2020-02-20")
                                .addToCategory("Meat", ingredientList);
        new AddIngredientCommand("kailan", "Vegetable", 30, 30.45, "2020-03-12")
                                .addToCategory("Vegetable", ingredientList);

        int index = 0;
        Ingredient ingredientToUpdate;
        /*DeleteIngredientCommand updateRangeQuantity = new DeleteIngredientCommand("kailan", 2);
        index = updateRangeQuantity.getIngredientIndex("kailan", ingredientList);
        ingredientToUpdate = ingredientList.get(index);
        updateRangeQuantity.updateNewQuantity(28, ingredientToUpdate);
        assertEquals(ingredientToUpdate.getQuantity(), 28);

        DeleteIngredientCommand updateOutOfRangeQuantity = new DeleteIngredientCommand("Beef", 40);
        index = updateOutOfRangeQuantity.getIngredientIndex("Beef", ingredientList);
        ingredientToUpdate = ingredientList.get(index);
        updateOutOfRangeQuantity.updateNewQuantity(-10, ingredientToUpdate);
        assertEquals(ingredientToUpdate.getQuantity(), 30);*/
    }
}
