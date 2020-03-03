package seedu.kitchenhelper.command;

public abstract class Command {
    
    private String actionType; //add, delete, list
    private String objectType; //ingredient, recipe, chore
    private String objectVariables;
    
    public Command() {
    
    }
    
    public CommandResult execute() {
        throw new UnsupportedOperationException();
    }
}
