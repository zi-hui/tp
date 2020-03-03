package seedu.kitchenhelper.command;

public class InvalidCommand extends Command {
    
    private static final String MESSAGE_INVALID = "Invalid Command";
    
    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_INVALID);
    }
}
