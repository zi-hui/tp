package seedu.duke.command;

public class Command {
    private String actionType; //add, delete, list
    private String objectType; //ingredient, recipe, chore
    private String objectVariables;

    public Command(){

    }
    //individual classes (Add, Delete, List) to implement their own
    public void execute() {
    }
}
