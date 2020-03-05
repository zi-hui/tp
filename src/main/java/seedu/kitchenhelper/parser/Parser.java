package seedu.kitchenhelper.parser;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.AddCommand;
import seedu.kitchenhelper.command.ListCommand;
import seedu.kitchenhelper.command.DeleteCommand;
import seedu.kitchenhelper.command.HelpCommand;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.command.InvalidCommand;

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
    public Command parseUserCommand(String input) {
        String[] userInputs = splitInputLine(input, " ");
        final String commandWord = userInputs[0];
        final String parameters = userInputs[1];
        
        switch (commandWord.toLowerCase()) {
        case AddCommand.COMMAND_WORD:
            return new AddCommand();
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
