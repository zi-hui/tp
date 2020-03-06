package seedu.kitchenhelper.parser;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.AddCommand;
import seedu.kitchenhelper.command.ListCommand;
import seedu.kitchenhelper.command.DeleteCommand;
import seedu.kitchenhelper.command.HelpCommand;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.command.InvalidCommand;
import seedu.kitchenhelper.exception.KitchenHelperException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Parse user input.
 */
public class Parser {
    /**
     * Parses user input into command for execution.
     *
     * @param input full user input string.
     * @return the command based on the user input.
     */
    public Command parseUserCommand(String input) throws KitchenHelperException {
        String[] userInputs = splitInputLine(input, " ");
        final String commandWord = userInputs[0];
        final String parameters = userInputs[1];
        switch (commandWord.toLowerCase()) {
        case AddCommand.COMMAND_WORD:
            AddCommand addCmd = new AddCommand();
            HashMap<String[], Integer> ingrAndQty = prepareAddRecipe(parameters);
            addCmd.setAttributesOfCmd(parameters, ingrAndQty);
            return addCmd;
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommand();
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        default:
            return new InvalidCommand();
        }
    }

    /**
     * Prepares the addition of ingredients into recipe.
     *
     * @param attributes full user input string.
     * @return hashmap of a formatted list of ingredients.
     * @throws KitchenHelperException if the command is invalid
     */
    public HashMap<String[], Integer> prepareAddRecipe(String attributes) throws KitchenHelperException {
        HashMap<String[], Integer> ingrAndQty = new HashMap<>();
        String ingredientList;
        try {
            ingredientList = attributes.substring(attributes.indexOf("/i") + 3);
            String[] splitedIngr = ingredientList.split("[,][\\s]");
            for (String item : splitedIngr) {
                String[] ingrContent = item.split(":");
                String[] nameAndType = new String[2];
                nameAndType[0] = ingrContent[0];
                nameAndType[1] = ingrContent[2];
                ingrAndQty.put(nameAndType, Integer.parseInt(ingrContent[1]));
            }
        } catch (IndexOutOfBoundsException e) {
            throw new KitchenHelperException("Invalid Command");
        }
        return ingrAndQty;
    }
    
    //@@author AY1920S2-CS2113T-M16-2-reused
    //Reused from
    //https://github.com/nus-cs2113-AY1920S2/contacts/blob/master/src/main/java/Contacts1.java
    
    /**
     * Split the user input into two parts with a specific regex.
     *
     * @param rawUserInput full user input string.
     * @param regex        the quantifier to separate the string.
     * @return an array of size 2 separated by the quantifier.
     */
    public static String[] splitInputLine(String rawUserInput, String regex) {
        String[] split = rawUserInput.trim().split(regex, 2);
        return split.length == 2 ? split : new String[]{split[0], ""}; // else no parameters
    }
    //@@author
}
