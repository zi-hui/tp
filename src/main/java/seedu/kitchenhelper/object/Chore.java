package seedu.kitchenhelper.object;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Allows users to add tasks to complete by certain deadline.
 */
public class Chore {
    public String description;
    public String dateStr = null;
    public Date date = null;
    public boolean isDone;
    public static final String MESSAGE_SUCCESS = "You have %s this chore:\n%s\nNow you have %s chore%s in the list.";

    /**
     * Constructor for Chore object.
     *
     * @param description the task description.
     * @param dateStr the deadline specified in String.
     */
    public Chore(String description, String dateStr) {
        this.description = description;
        this.dateStr = dateStr;
        this.isDone = false;
    }

    /**
     * Constructor for Chore object.
     *
     * @param description the task description.
     * @param date the deadline specified by Date Java class.
     */
    public Chore(String description, Date date) {
        this.description = description;
        this.date = date;
        this.isDone = false;
    }

    /**
     * Marks the chore as done.
     *
     * @return isDone class variable set to true.
     */
    public boolean markAsDone() {
        return isDone = true;
    }

    /**
     * Displays icon that represents whether chore is done or not.
     * @return
     */
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

    public static Chore createChoreWhenLoadFile(String description, String dateStr) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = dateFormat.parse(dateStr);
            return new Chore(description, date);
        } catch (ParseException e) {
            return new Chore(description, dateStr);
        }
    }

    /**
     * To compare two Chore objects based on their attributes.
     * @return boolean return false if any of the attributes are not equal to each other.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Chore) {
            Chore i = (Chore) o;
            return this.description.equals(i.description)
                    && this.isDone == isDone
                    && this.dateStr.equals(i.dateStr);
        } else {
            return false;
        }
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description + " (by: " + convertDateToString() + ")";
    }

}
