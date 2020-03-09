package seedu.kitchenhelper.command;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.ingredient.Meat;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListCommandTest {

    @Test
    public void listCommandIngredient_validData_correctlyConstructed() throws Exception {
        ListCommand command = new ListCommand();
        HashMap<String, String> listParam = new HashMap<>();
        listParam.put("type", "ingredient");
        listParam.put("item", "");
        command.setListParams(listParam);
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals("list", command.getActionType());
        assertEquals("ingredient",command.getObjectType());
        assertEquals("", command.getObjectVariables());

    }

    @Test
    public void listCommandIngredient_validData_wronglyConstructed() throws Exception {
        ListCommand command = new ListCommand();
        HashMap<String, String> listParam = new HashMap<>();
        listParam.put("type", "ingredient");
        listParam.put("item", "");
        command.setListParams(listParam);
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertNotEquals("delete", command.getActionType());
        assertNotEquals("recipe",command.getObjectType());
        assertNotEquals("1", command.getObjectVariables());

    }

    @Test
    public void listCommandRecipe_validData_correctlyConstructed() throws Exception {
        ListCommand command = new ListCommand();
        HashMap<String, String> listParam = new HashMap<>();
        listParam.put("type", "recipe");
        listParam.put("item", "1");
        command.setListParams(listParam);
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals("list", command.getActionType());
        assertEquals("recipe",command.getObjectType());
        assertEquals("1", command.getObjectVariables());

    }

    @Test
    public void listCommandRecipe_validData_wronglyConstructed() throws Exception {
        ListCommand command = new ListCommand();
        HashMap<String, String> listParam = new HashMap<>();
        listParam.put("type", "recipe");
        listParam.put("item", "1");
        command.setListParams(listParam);
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertNotEquals("delete", command.getActionType());
        assertNotEquals("ingredient",command.getObjectType());
        assertNotEquals("0", command.getObjectVariables());

    }



}
