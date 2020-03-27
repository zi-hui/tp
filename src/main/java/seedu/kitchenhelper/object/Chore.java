package seedu.kitchenhelper.object;

import java.util.ArrayList;

public class Chore {
    public String description;
    public String date;
    public boolean isDone;
    public static final String MESSAGE_SUCCESS = "You have %s this chore:\n%s\nNow you have %s chore%s in the list.";

    public Chore(String description, String date) {
        this.description = description;
        this.date = date;
        this.isDone = false;
    }

    public boolean markAsDone() {
        return isDone = true;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "/";
        } else {
            return "x";
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
        return "[" + getStatusIcon() + "] " + description + " (by: " + date + ")";
    }

}
