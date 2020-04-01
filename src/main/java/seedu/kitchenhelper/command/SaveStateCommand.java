package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.ui.Ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveStateCommand extends Command {

    public static final String COMMAND_WORD = "save";
    public static final String MESSAGE_SUCCESS = "You have saved the current state in the following files: ";
    public static final String FILE_PATH_INGREDIENT = "outputIngredientCopy.txt, ";
    public static final String FILE_PATH_RECIPE = "outputRecipeCopy.txt, ";
    public static final String FILE_PATH_CHORE = "outputChoreCopy.txt";
    public static final String COMMAND_DESC = "Stores the current state of program in manual mode.";
    public static final String MESSAGE_USAGE =
            String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String.format("Example: %s", COMMAND_WORD);


    /**
     * Save current state of Kitchen Helper into new output files.
     *
     * @return success message of saved state successful.
     */
    public String saveState() throws IOException {
        chooseSaveOption();
        return MESSAGE_SUCCESS + FILE_PATH_INGREDIENT + FILE_PATH_RECIPE +  FILE_PATH_CHORE;
    }

    /**
     * Copy current output files of Kitchen Helper into new output files to save current state.
     */
    private void chooseSaveOption() throws IOException {
        var sourceIngredient = new File("outputIngredient.txt");
        var sourceRecipe = new File("outputRecipe.txt");
        var sourceChore = new File("outputChore.txt");
        var destIngredient = new File("outputIngredientCopy.txt");
        var destRecipe = new File("outputRecipeCopy.txt");
        var destChore = new File("outputChoreCopy.txt");

        Storage.copyFile(sourceIngredient, destIngredient);
        Storage.copyFile(sourceRecipe, destRecipe);
        Storage.copyFile(sourceChore, destChore);
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList list of recipes.
     * @param choreList list of chores.
     * @return the success message of saving current state of Kitchen Helper.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws IOException {
        String feedbackToUser = saveState();
        return new CommandResult(feedbackToUser);
    }
}
