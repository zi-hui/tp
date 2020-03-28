package seedu.kitchenhelper.object;

import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;


import java.util.Scanner;

public class Expenditure {
    public static final String PROMPT_REMOVE_FROM_EXPENDITURE
            = "Would you like to remove the amount spent on this item from the total expenditure?\n";
    public static final String PROMPT_ADD_TO_AMOUNT_USED
            = "Would you like to add the amount spent on this item " +
            "to the amount used for cooking?\n";
    public static final String REMOVAL_SUCCESS = "Ok! $%.2f is deducted from total expenditure.\n";
    public static final String INCREASE_AMOUNT_USED = "Ok! $%.2f is added to amount used in cooking.\n";
    public static final String NO_CHANGE = "Ok! There are no changes to expenditure.\n";


    private double totalExpenditure;
    private double amountUsedInCooking;

    public void renewExpenditureValue() {
        totalExpenditure = 0;
    }

    public void addToExpenditure(double price) {
        totalExpenditure += price;
    }

    public void removeFromExpenditure(Ingredient ingredientToDelete, Integer quantityToDelete) {
        String userResponse = promptUser(PROMPT_REMOVE_FROM_EXPENDITURE );
        if (userResponse.equalsIgnoreCase("yes")) {
            totalExpenditure -= changePrice(ingredientToDelete, quantityToDelete);
            System.out.println(REMOVAL_SUCCESS);
        } else {
            System.out.println(NO_CHANGE);
        }
    }

    public void addToAmountUsed(Ingredient ingredientToDelete, Integer quantityToDelete) {
        String userResponse = promptUser(PROMPT_ADD_TO_AMOUNT_USED);
        if (userResponse.equalsIgnoreCase("yes")) {
            amountUsedInCooking += changePrice(ingredientToDelete, quantityToDelete);
            System.out.println(INCREASE_AMOUNT_USED);
        } else {
            System.out.println(NO_CHANGE);
        }
    }

    public void editExpenditure(Ingredient ingredientToDelete, Integer quantityToDelete) {
        removeFromExpenditure(ingredientToDelete, quantityToDelete);
        addToAmountUsed(ingredientToDelete, quantityToDelete);
    }

    public double changePrice(Ingredient ingredientToDelete, Integer quantityToDelete) {
        double itemPrice = ingredientToDelete.getPrice();
        int totalQuantityOfItem = ingredientToDelete.getQuantity();
        double priceOfEachIngredient = itemPrice/totalQuantityOfItem;
        if (quantityToDelete == null) {
            return itemPrice;
        } else {
            return priceOfEachIngredient * quantityToDelete;
        }
    }

    public String promptUser(String prompt) {
        String userResponse;
        System.out.println(prompt);
        userResponse = new Scanner(System.in).nextLine().trim();
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
