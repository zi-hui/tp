package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteCommand extends Command {
    
    public static final String COMMAND_WORD = "delete";
    public static int quantity;

    /**
     * Set the Object Type for the Command.
     *
     * @param object the name of the object type
     */

    public void setTypeOfObject(String object) {
        String[] attributes = object.split("\\s+");
        if (attributes[0].equalsIgnoreCase("recipe")) {
            objectType = "recipe";
        } else if (attributes[0].equalsIgnoreCase("ingredient")) {
            objectType = "ingredient";
        } else if (attributes[0].equalsIgnoreCase("chore")) {
            objectType = "chore";
        }
    }

    /**
     * Set the other parameters for the DeleteCommand.
     *
     * @param attributes all the parameters for DeleteCommand
     */

    public void setDeleteParams(HashMap<String, String> attributes) {
        setAction();
        setTypeOfObject(attributes.get("type"));
        setOtherAttributes(attributes);
    }


    /**
     * Set the Action Type for the Command (delete).
     */

    public void setAction() {
        actionType = COMMAND_WORD;
    }

    /**
     * Set the other parameters for the DeleteCommand.
     *
     * @param attributes all the parameters for DeleteCommand
     */

    public void setOtherAttributes(HashMap<String, String> attributes) {
        objectVariables = attributes.get("nameToDelete");
        quantity = Integer.parseInt(attributes.get("quantity"));
    }
    
    @Override
    public String deleteChore(String numberToDelete, ArrayList<Chore> choreList) {
        String feedbackToUser;
        try {
            int number = Integer.parseInt(numberToDelete.trim());
            Chore choreToDelete = choreList.get(number - 1);
            choreList.remove(choreToDelete);
            choreToDelete.setEditType(COMMAND_WORD);
            feedbackToUser = String.format(Chore.MESSAGE_SUCCESS,
                    choreToDelete.editType, choreToDelete, choreList.size(), choreToDelete.checkSingular(choreList));
        } catch (NumberFormatException e) {
            feedbackToUser = "The description of \"delete\" has to be an integer in the list.";
        } catch (IndexOutOfBoundsException e) {
            feedbackToUser = "The description of \"delete\" has to be an integer in the list.";
        }
        return feedbackToUser;
    }

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
     * @return the execution of the deletion of ingredients or tasks.
     */

    @Override
    public CommandResult  execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) throws KitchenHelperException {
        return super.execute(ingredientList, recipeList, choreList);
    }
}
