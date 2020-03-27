package seedu.kitchenhelper.notification;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChoreNotification {

    public static final String DEADLINE_NOTIFICATION = "The deadline for these chores are approaching!\n";
    public static final String EMPTY_NOTIFICATION = "You have no deadlines upcoming in the next 3 days.\n";
    public static final String OVERDUE_NOTIFICATION = "The deadline for these chores are overdue!\n";

    public String getNotifications(ArrayList<Chore> choreList) {
        String notification = "";
        String upcomingChores = "";
        String overdueChores = "";
        for (Chore chore:choreList) {
            if (hasDateAsDeadline(chore) && isApproachingDeadline(chore)) {
                upcomingChores += (chore + "\n");
            }
            if (hasDateAsDeadline(chore) && isOverdue(chore)) {
                overdueChores += (chore + "\n");
            }
        }

        if (!overdueChores.isEmpty()) {
            notification += OVERDUE_NOTIFICATION + overdueChores + Ui.LS;
        }
        if (upcomingChores.isEmpty()) {
            notification += EMPTY_NOTIFICATION + Ui.DIVIDER;
        } else {
            notification += DEADLINE_NOTIFICATION + upcomingChores + Ui.DIVIDER;
        }
        return notification;
    }

    public boolean isApproachingDeadline(Chore chore) {
        Date deadline = chore.date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deadline); //sets the time to deadline
        calendar.add(Calendar.DATE, -3); //find out what the date 3 days before deadline
        Date threeDaysBefore = calendar.getTime(); //get this time in Date object form
        Date currentDate = new Date();

        if (threeDaysBefore.before(currentDate) && deadline.after(currentDate)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasDateAsDeadline(Chore chore) {
        if (chore.date != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOverdue(Chore chore) {
        Date deadline = chore.date;
        Date currentDate = new Date();

        if (deadline.before(currentDate)) {
            return true;
        } else {
            return false;
        }
    }


}
