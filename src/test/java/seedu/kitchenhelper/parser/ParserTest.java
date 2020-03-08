package seedu.kitchenhelper.parser;

import org.junit.jupiter.api.Test;
import seedu.kitchenhelper.KitchenHelper;
import seedu.kitchenhelper.command.AddInventoryCommand;
import seedu.kitchenhelper.command.InvalidCommand;
import seedu.kitchenhelper.exception.KitchenHelperException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.kitchenhelper.parser.Parser.splitInputLine;

class ParserTest {
    
    @Test
    void parseUserCommand_testPass() throws KitchenHelperException {
        assertTrue(new Parser().parseUserCommand(
                "addinventory /n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20") instanceof AddInventoryCommand);
    }
    
    @Test
    void parseUserCommand_testFail() throws KitchenHelperException {
        assertFalse(new Parser()
                .parseUserCommand("dada /n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20") instanceof AddInventoryCommand);
    }
    
    @Test
    void prepareAddInventory_testPass() {
        String correctAttributes = "/n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20";
        assertTrue(new Parser().prepareAddInventory(correctAttributes) instanceof AddInventoryCommand);
        String output = String.format(AddInventoryCommand.MESSAGE_SUCCESS, "Beef", "Meat", 30, 20.2, "2020-02-20");
        assertEquals(output, showToConsole(new KitchenHelper()
                .executeCommand(new Parser().prepareAddInventory(correctAttributes)).feedbackToUser));
    }
    
    @Test
    void prepareAddInventory_testFail() {
        String incorrectAttributes = "/ Beef /c Meat /q 30 /p 20.2 /e 2020-02-20";
        assertTrue(new Parser().prepareAddInventory(incorrectAttributes) instanceof InvalidCommand);
        String output = "Invalid Command Format!\n"
                        + "Adds a ingredient to the inventory list. /n INGREDIENT /c CATEGORY /q QUANTITY /p PRICE /e"
                        + " EXPIRY\n" + "Example: addinventory /n Beef /c Meat /q 1 /p 13.5 /e 2020-02-13";
        assertEquals(output, showToConsole(new KitchenHelper()
                .executeCommand(new Parser().prepareAddInventory(incorrectAttributes)).feedbackToUser));
    }
    
    @Test
    void splitInputLine_testPass() {
        String userInput = "addinventory /n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20";
        assertEquals("addinventory", splitInputLine(userInput, " ")[0]);
        assertEquals("/n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20", splitInputLine(userInput, " ")[1]);
    }
    
    @Test
    void splitInputLine_testFail() {
        String userInput = "addinventory /n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20";
        assertNotEquals("addinventory", splitInputLine(userInput, "")[0]);
        assertNotEquals("/n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20", splitInputLine(userInput, "/p")[1]);
    }
    
    @Test
    void isValidUserInputFormat_testPass() {
        String regex = "/n [a-zA-Z]+( [a-zA-Z]+)* /c [a-zA-Z]+ /q [0-9]+ /p \\d+(\\.\\d{1,2})? /e \\d{4}-\\d{2}-\\d{2}";
        assertTrue(new Parser().isValidUserInputFormat("/n Beef /c Meat /q 30 /p 20.2 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n Beef cubes /c Meat /q 30 /p 20.2 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n Kailan /c Vegetable /q 30 /p 20 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n miLK /c dairy /q 30 /p 20.2 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n APPLE /c fRuit /q 20 /p 20.22 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n Rice /c Staple /q 30 /p 222.11 /e 2020-02-20", regex));
        assertTrue(new Parser()
                .isValidUserInputFormat("/n apple cider alcohol drink /c Drink /q 30 /p 50.1 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n spoon /c miscellaneous /q 30 /p 20.2 /e 2020-02-20", regex));
        assertTrue(new Parser().isValidUserInputFormat("/n Beef cubes /c Meat /q 30 /p 20.2 /e 2020-02-20", regex));
    }
    
    @Test
    void isValidUserInputFormat_testFail() {
        String regex = "/n [a-zA-Z]+( [a-zA-Z]+)* /c [a-zA-Z]+ /q [0-9]+ /p \\d+(\\.\\d{1,2})? /e \\d{4}-\\d{2}-\\d{2}";
        // Invalid price notation
        assertFalse(new Parser().isValidUserInputFormat("/n Beef /c Meat /q 30 /p 20.212 /e 2020-02-20", regex));
        // Invalid Date format
        assertFalse(new Parser().isValidUserInputFormat("/n Beef cubes /c Meat /q 30 /p 20.2 /e 02-02-2020", regex));
        // Missing identifier /n
        assertFalse(new Parser().isValidUserInputFormat("Kailan /c Vegetable /q 30 /p 20 /e 2020-02-20", regex));
        // Missing space between ingredient name and identifier /c
        assertFalse(new Parser().isValidUserInputFormat("/n miLK/c dairy /q 30 /p 20.2 /e 2020-02-20", regex));
        // Extra space between ingredient'category and identifier /q
        assertFalse(new Parser().isValidUserInputFormat("/n APPLE /c fRuit  /q 20 /p 20.22 /e 2020-02-20", regex));
        // Invalid Date format, consist of 3 digit in day in a month
        assertFalse(new Parser().isValidUserInputFormat("/n Rice /c Staple /q 30 /p 222.11 /e 2020-02-201", regex));
        // Missing parameter
        assertFalse(new Parser().isValidUserInputFormat("/n Beef cubes /c Meat /q 30 /p /e 2020-02-20", regex));
    }
    
    String showToConsole(String... message) {
        String output = "";
        for (String m : message) {
            output += m;
        }
        return output;
    }
    
}
