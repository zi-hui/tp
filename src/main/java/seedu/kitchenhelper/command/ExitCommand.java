package seedu.kitchenhelper.command;

public class ExitCommand extends Command {
    
    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_EXIT = "Exiting KitchenHelper as requested ...";
    
    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_EXIT);
    }
}
