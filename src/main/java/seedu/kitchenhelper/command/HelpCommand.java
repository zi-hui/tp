package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;
import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

public class HelpCommand extends Command {
    
    public static final String COMMAND_WORD = "help";
    public static final String INGREDIENT_LOGO = Ui.DIVIDER + Ui.LS + "Ingredient" + Ui.LS + Ui.DIVIDER + Ui.LS;
    public static final String RECIPE_LOGO = Ui.DIVIDER + Ui.LS + "Recipe" + Ui.LS + Ui.DIVIDER + Ui.LS;
    public static final String CHORE_LOGO = Ui.DIVIDER + Ui.LS + "Chore" + Ui.LS + Ui.DIVIDER + Ui.LS;

    public void executeIngredientStorage(ArrayList<Ingredient> ingredientList, Storage storage){
    }

    public void executeChoreStorage(ArrayList<Chore> choreList, Storage storage){
    }

    public void executeRecipeStorage(ArrayList<Recipe> recipeList, Storage storage){
    }

    /**
     * {@inheritDoc}
     *
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the success message of printing help.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        return new CommandResult(
                Ui.DIVIDER + Ui.LS + INGREDIENT_LOGO + AddIngredientCommand.MESSAGE_USAGE + Ui.LS + Ui.LS
                + DeleteIngredientCommand.MESSAGE_USAGE + Ui.LS + Ui.LS + RECIPE_LOGO + AddRecipeCommand.MESSAGE_USAGE
                + Ui.LS + Ui.LS + DeleteRecipeCommand.MESSAGE_USAGE + Ui.LS + Ui.LS + CHORE_LOGO);
    }
}
