package seedu.kitchenhelper.object;

import java.util.ArrayList;

public class Chore {
    public String description;
    public String date;
    public boolean isDone;
    public String editType;
    public static final String MESSAGE_SUCCESS = "You have %s this task:\n%s\n Now you have %s task%s in the list.";

    public Chore(String description, String date) {
        this.description = description;
        this.date = date;
        this.isDone = false;
    }

    public void setEditType(String command) {
         if (command.equals("add"))  {
             this.editType = "added";
         } else {
             this.editType = "removed";
         }
    }

    public boolean markAsDone(){
        return isDone = true;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "\u2713";
        } else {
            return "\u2718";
        }
    }

    public String checkSingular(ArrayList<Chore> choreList) {
        if (choreList.size() == 1) {
            return "";
        } else {
            return "s";
        }
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description + "(by: " + date + ")";
    }

}
