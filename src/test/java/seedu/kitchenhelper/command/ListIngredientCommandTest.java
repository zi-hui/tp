package seedu.kitchenhelper.command;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ListIngredientCommandTest {

    @Test
    public void listCommandIngredient_validCategoryName_correctlyConstructed() throws Exception {
        ListIngredientCommand command = new ListIngredientCommand("all");
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals("all",command.getCategory());
        assertTrue(command.checkCategoryValid());
    }

    @Test
    public void listCommandIngredient_invalidCategoryName_correctlyConstructed() throws Exception {
        ListIngredientCommand command = new ListIngredientCommand("laptop");
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals("laptop",command.getCategory());
        assertFalse(command.checkCategoryValid());
    }






}
