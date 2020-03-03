package seedu.duke.parser;

import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;

public class Parser {
    public Parser(){

    }

    public Command parseUserCommand(String input){
        String [] userInputs = input.split(" ", 3);
        switch (userInputs[0].toLowerCase()){
        case "add":
            return new AddCommand();
            //FILL IN YOURSELVES, THANKS :)
        default:

        }
        Command newCommand = new Command();
        return newCommand;
    }


    public void executeCommand(String userInput){
        //try {
            Command command = parseUserCommand(userInput);
            command.execute();
        //} catch ()
    }
}
