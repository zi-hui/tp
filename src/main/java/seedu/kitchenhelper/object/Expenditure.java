package seedu.kitchenhelper.object;

import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Calculate user expenditure.
 */
public class Expenditure {

    public static final String PROMPT_REMOVE_FROM_EXPENDITURE
            = "The amount of money spent on this ingredient has already been recorded.\n"
            + "Would you like to remove the amount spent on this item from the total expenditure?";
    public static final String PROMPT_ADD_TO_AMOUNT_USED
            = "Would you like to add the amount spent on this item "
            + "to the amount used for cooking?";
    public static final String REMOVAL_SUCCESS = "Ok! $%.2f is deducted from total expenditure.";
    public static final String INCREASE_AMOUNT_USED = "Ok! $%.2f is added to amount used in cooking.";
    public static final String NO_CHANGE = "Ok! There are no changes to expenditure.";


    public double totalExpenditure;
    public double amountUsedInCooking;
    public Date lastSavedDate;

    private static Expenditure onlyInstance = null;

    /**
     * Only one instance of Expenditure class can be instantiated.
     */
    private Expenditure() {
    }

    /**
     * Singleton instantiated by
     *
     * @return
     */
    public static Expenditure getInstance() {
        if (onlyInstance == null) {
            onlyInstance = new Expenditure();
        }
        return onlyInstance;
    }

    public String saveExpenditureFile() {
        String text;
        text = String.format("Expenditure: $%.2f,", totalExpenditure);
        text += String.format("Amount used in cooking: $%.2f,", amountUsedInCooking);
        Date currentDate = new Date();
        text += new SimpleDateFormat("EEE dd/MM/yyyy HH:mm:ss").format(currentDate) + Ui.LS;
        return text;
    }

    public void loadExpenditureVariables(double totalExpenditure, double amountUsedInCooking, Date lastSavedDate) {
        this.totalExpenditure = totalExpenditure;
        this.amountUsedInCooking = amountUsedInCooking;
        this.lastSavedDate = lastSavedDate;
        renewExpenditureValue();
    }

    public void renewExpenditureValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        //DateFormat dateFormat = new SimpleDateFormat("EEE dd/MM/yyyy HH:mm:ss");
        //System.out.println(dateFormat.format(c.getTime()));      // This past Monday [ May include today ]
        Date pastMonday = calendar.getTime(); //past Monday
        //calendar.add(Calendar.DATE,7);
        //Date nextMonday = calendar.getTime(); //next Monday
        if (lastSavedDate == null || lastSavedDate.before(pastMonday)) {
            totalExpenditure = 0;
            amountUsedInCooking = 0;
        }
    }

    public void addToExpenditure(double price, int quantity) {
        totalExpenditure += (price * quantity);
    }

    public void removeFromExpenditure(Ingredient ingredientToDelete, Integer quantityToDelete) {
        String userResponse = promptUser(PROMPT_REMOVE_FROM_EXPENDITURE);
        if (userResponse.equalsIgnoreCase("yes")) {
            double price = changePrice(ingredientToDelete, quantityToDelete);
            totalExpenditure -= price;
            System.out.println(String.format((REMOVAL_SUCCESS), price));
        } else {
            System.out.println(NO_CHANGE);
        }
    }

    public void addToAmountUsed(Ingredient ingredientToDelete, Integer quantityToDelete) {
        String userResponse = promptUser(PROMPT_ADD_TO_AMOUNT_USED);
        if (userResponse.equalsIgnoreCase("yes")) {
            addAmountForCooking(ingredientToDelete, quantityToDelete);
        } else {
            System.out.println(NO_CHANGE);
        }
    }

    public void addAmountForCooking(Ingredient ingredientToDelete, Integer quantityToDelete) {
        amountUsedInCooking += changePrice(ingredientToDelete, quantityToDelete);
        //Storage.saveExpenditureData();
    }

    public void editExpenditure(Ingredient ingredientToDelete, Integer quantityToDelete) {
        removeFromExpenditure(ingredientToDelete, quantityToDelete);
        addToAmountUsed(ingredientToDelete, quantityToDelete);
        //Storage.saveExpenditureData();
    }

    public double changePrice(Ingredient ingredientToDelete, Integer quantityToDelete) {
        double pricePerPiece = ingredientToDelete.getPrice();
        int totalQuantityOfItem = ingredientToDelete.getQuantity();
        if (quantityToDelete == null) {
            return pricePerPiece * totalQuantityOfItem;
        } else {
            return pricePerPiece * quantityToDelete;
        }
    }

    public String promptUser(String prompt) {
        String userResponse;
        System.out.println(prompt);
        try {
            userResponse = new Scanner(System.in).nextLine().trim();
        } catch (NoSuchElementException e) {
            return "no";
        }
        while (!isValidResponse(userResponse)) {
            System.out.println("Please enter either \"Yes\"/\"No\"");
            userResponse = new Scanner(System.in).nextLine().trim();
        }
        return userResponse;
    }

    public boolean isValidResponse(String userResponse) {
        String response = userResponse;
        if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }



}
