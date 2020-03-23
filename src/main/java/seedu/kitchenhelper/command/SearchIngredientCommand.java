package seedu.kitchenhelper.command;

import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Search for ingredient in the ingredient list.
 */
public class SearchIngredientCommand extends Command {
    
    public static final Logger kitchenLogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
    public static final String LOG_INFO = "Entering execution of finding matching ingredients";
    public static final String LOG_INFO_EMPTY = "Has non-matching ingredient";
    public static final String LOG_INFO_Found = "Found matching ingredient";
    
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
        kitchenLogs.info(LOG_INFO);
        ArrayList<Ingredient> findIngredientList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.toFind().toLowerCase().contains(keyword)) {
                findIngredientList.add(ingredient);
            }
        }
        
        if (findIngredientList.isEmpty()) {
            kitchenLogs.info(LOG_INFO_EMPTY);
            return new CommandResult(EMPTY_LIST);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NON_EMPTY_LIST)
                .append(Ui.LS);
        assert findIngredientList.size() > 0;
        kitchenLogs.info(LOG_INFO_Found);
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
