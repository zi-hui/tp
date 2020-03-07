package seedu.kitchenhelper.storage;

import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.object.ingredient.Dairy;
import seedu.kitchenhelper.object.ingredient.Drink;
import seedu.kitchenhelper.object.ingredient.Fruit;
import seedu.kitchenhelper.object.ingredient.Meat;
import seedu.kitchenhelper.object.ingredient.Staple;
import seedu.kitchenhelper.object.ingredient.Vegetable;
import seedu.kitchenhelper.object.ingredient.Miscellaneous;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Ingredient> getIngredientData() throws FileNotFoundException {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String userData = scanner.nextLine();
            String[] getName = userData.split("/n");
            String[] getQuantity = getName[1].split("/q");
            String[] getExpiry = getQuantity[1].split("/e");
            String[] getSub = getExpiry[1].split("/s");
            String[] getPrice = getSub[1].split("/p");

            String name = getQuantity[0];
            Integer quantity = Integer.parseInt(getExpiry[0]);
            String expiry = getSub[0];
            String subcategory = getPrice[0];
            Double price = Double.parseDouble(getPrice[1]);

            switch (subcategory) {
            case "Dairy":
                Ingredient diary = new Dairy(name, subcategory, quantity, price, expiry);
                ingredientList.add(diary);
                break;
            case "Drink": {
                Ingredient drink = new Drink(name, subcategory, quantity, price, expiry);
                ingredientList.add(drink);
                break;
            }
            case "Fruit": {
                Ingredient fruit = new Fruit(name, subcategory, quantity, price, expiry);
                ingredientList.add(fruit);
                ;
                break;
            }
            case "Meat": {
                Ingredient meat = new Meat(name, subcategory, quantity, price, expiry);
                ingredientList.add(meat);
                break;
            }
            case "Miscellaneous": {
                Ingredient miscellaneous = new Miscellaneous(name, subcategory, quantity, price, expiry);
                ingredientList.add(miscellaneous);
                break;
            }
            case "Staple": {
                Ingredient staple = new Staple(name, subcategory, quantity, price, expiry);
                ingredientList.add(staple);
                break;
            }
            case "Vegetable": {
                Ingredient vegetable = new Vegetable(name, subcategory, quantity, price, expiry);
                ingredientList.add(vegetable);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + subcategory);
            }
        }
        return ingredientList;
    }

    public void saveIngredientData(ArrayList<Ingredient> ingredientList) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Ingredient ingredient : ingredientList) {
                fw.write(ingredient.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void saveRecipeData(ArrayList<Recipe> recipeList) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Recipe recipe : recipeList) {
                fw.write(recipe.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void saveChoreData(ArrayList<Chore> choreList) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Chore chore : choreList) {
                fw.write(chore.toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}