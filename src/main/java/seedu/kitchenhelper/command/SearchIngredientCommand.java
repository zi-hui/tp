package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

/**
 * Search for ingredient in the ingredient list.
 */
public class SearchIngredientCommand extends Command {
    
    public static final String COMMAND_WORD = "searchingredient";
    public static final String COMMAND_DESC = "Find ingredients in the ingredient list using a keyword.";
    public static final String COMMAND_PARAMETER = "KEYWORD";
    public static final String COMMAND_EXAMPLE = "Example: searchingredient beef";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);
    private static final String EMPTY_LIST = "There are no matching ingredient in your list.";
    private static final String NON_EMPTY_LIST = "Here are your matching ingredients in your list";
    private static final String NUMBER_FORMAT = "%d.";
    private String keyword;
    
    /**
     * Constructor for Search Ingredient Command.
     * @param keyword the word to search.
     */
    public SearchIngredientCommand(String keyword) {
        this.keyword = keyword;
    }
    
    /**
     * {@inheritDoc}
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the list of matching ingredient.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        ArrayList<Ingredient> findIngredientList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.toFind().toLowerCase().contains(keyword)) {
                findIngredientList.add(ingredient);
            }
        }
        
        if (findIngredientList.isEmpty()) {
            return new CommandResult(EMPTY_LIST);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NON_EMPTY_LIST)
                .append(Ui.LS);
        for (int i = 0; i < findIngredientList.size(); ++i) {
            if (i == findIngredientList.size() - 1) {
                sb.append(String.format(NUMBER_FORMAT, i + 1))
                        .append(findIngredientList.get(i).toFind());
                break;
            }
            sb.append(String.format(NUMBER_FORMAT, i + 1))
                    .append(findIngredientList.get(i)
                            .toFind()).append(Ui.LS);
        }
        return new CommandResult(sb.toString());
    }
}
