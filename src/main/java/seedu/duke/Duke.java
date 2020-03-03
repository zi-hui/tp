package seedu.duke;

import seedu.duke.object.Chore;
import seedu.duke.object.Recipe;
import seedu.duke.object.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ArrayList<Chore> choreList = new ArrayList<>();
    /* Hi pls, look at this main program.
    * https://github.com/nus-cs2113-AY1920S2/personbook/blob/master/src/main/java/seedu/personbook/Main.java */
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private void run(){

    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
