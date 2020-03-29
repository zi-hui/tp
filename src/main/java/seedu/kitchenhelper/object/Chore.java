package seedu.kitchenhelper.object;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chore {
    public String description;
    public String dateStr = null;
    public Date date = null;
    public boolean isDone;
    public static final String MESSAGE_SUCCESS = "You have %s this chore:\n%s\nNow you have %s chore%s in the list.";

    public Chore(String description, String dateStr) {
        this.description = description;
        this.dateStr = dateStr;
        this.isDone = false;
    }

    public Chore(String description, Date date) {
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

    public String convertDateToString() {
        if (dateStr == null) {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
        } else {
            return dateStr;
        }
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description + " (by: " + convertDateToString() + ")";
    }

}
