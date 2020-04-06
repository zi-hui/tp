package seedu.kitchenhelper.notification;

import seedu.kitchenhelper.command.ListChoreCommand;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IngredientNotification {

    public static final String EXPIRING_NOTIFICATION = "These ingredients expiring date are approaching!\n";
    public static final String LOWQUANTITY_NOTIFICATION = "These ingredients are currently low stock [< 5]!\n";
    public static final String EXPIRED_NOTIFICATION = "These ingredients are expired!\n";
    public static final String EMPTYEXPIRING_NOTIFICATION = "You have no ingredients that are "
            + "expiring for the next 3 days.\n";
    public static final String EMPTYLOWQUANTITY_NOTIFICATION = "You have no ingredients that are low in stock [< 5].\n";
    public static final String EMPTYEXPIRED_NOTIFICATION = "You have no ingredients that are expired.\n";
    private String notification = "";

    public String getNotifications(ArrayList<Ingredient> ingredientArrayList) {
        ArrayList<Ingredient> ingredientExpiring = checkForExpiringIngr(ingredientArrayList);
        ArrayList<Ingredient> ingredientLowQuantity = checkForLowQuantityIngr(ingredientArrayList);
        ArrayList<Ingredient> ingredientExpired = checkForExpiredIngr(ingredientArrayList);


        if (!ingredientExpiring.isEmpty()) {
            notification += EXPIRING_NOTIFICATION;
            addToNotification(ingredientExpiring);
            notification += Ui.DIVIDER + "\n";
        } else {
            notification += EMPTYEXPIRING_NOTIFICATION;
            notification += Ui.DIVIDER + "\n";
        }
        if (!ingredientLowQuantity.isEmpty()) {
            notification += LOWQUANTITY_NOTIFICATION;
            addToNotification(ingredientLowQuantity);
            notification += Ui.DIVIDER + "\n";
        } else {
            notification += EMPTYLOWQUANTITY_NOTIFICATION + Ui.DIVIDER  + "\n";
        }
        if (!ingredientExpired.isEmpty()) {
            notification += EXPIRED_NOTIFICATION;
            addToNotification(ingredientExpired);
            notification += Ui.DIVIDER  + "\n";
        } else {
            notification += EMPTYEXPIRED_NOTIFICATION + Ui.DIVIDER + "\n";
        }

        return notification;
    }

    public Date stringToDate(String date1) {
        Date date = new Date();
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            date = dateFormat.parse(date1);
        } catch (Exception e) {
            System.out.println("Failed");
        }
        return date;
    }

    public void addToNotification(ArrayList<Ingredient> ingredientArrayList) {
        int counter = 1;
        for (Ingredient i : ingredientArrayList) {
            notification += "[" + counter + "] Ingredient name : " + i.getIngredientName()
                    + " | " + i.getQuantity() + " portion(s) | $"
                    + i.getPrice() + " | Expiry Date : " + i.getExpiryDate() + "\n";
            counter++;
        }
    }

    public ArrayList<Ingredient> checkForExpiringIngr(ArrayList<Ingredient> ingredientArrayList) {
        ArrayList<Ingredient> ingredientExpiring = new ArrayList<Ingredient>();
        for (Ingredient i : ingredientArrayList) {
            Date deadline = stringToDate(i.getExpiryDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(deadline); //sets the time to deadline
            calendar.add(Calendar.DATE, -3); //find out what the date 3 days before deadline
            Date threeDaysBefore = calendar.getTime(); //get this time in Date object form
            Date currentDate = new Date();

            if (threeDaysBefore.before(currentDate) && deadline.after(currentDate)) {
                ingredientExpiring.add(i);
            }
        }
        return ingredientExpiring;
    }


    public ArrayList<Ingredient> checkForLowQuantityIngr(ArrayList<Ingredient> ingredientArrayList) {
        ArrayList<Ingredient> ingredientLowQuantity = new ArrayList<Ingredient>();
        for (Ingredient i : ingredientArrayList) {
            if (i.getQuantity() < 5) {
                ingredientLowQuantity.add(i);
            }
        }
        return ingredientLowQuantity;
    }

    public ArrayList<Ingredient> checkForExpiredIngr(ArrayList<Ingredient> ingredientArrayList) {
        ArrayList<Ingredient> ingredientExpired = new ArrayList<Ingredient>();
        for (Ingredient i : ingredientArrayList) {
            Date deadline = stringToDate(i.getExpiryDate());
            Date currentDate = new Date();
            if (deadline.before(currentDate)) {
                ingredientExpired.add(i);
            }
        }
        return ingredientExpired;
    }



}
