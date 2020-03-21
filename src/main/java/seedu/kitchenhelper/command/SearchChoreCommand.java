package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

/**
 * Search for chore in the chore list.
 */
public class SearchChoreCommand extends Command {
    
    public static final String COMMAND_WORD = "searchchore";
    public static final String COMMAND_DESC = "Find chores in the chore list using a keyword.";
    public static final String COMMAND_PARAMETER = "KEYWORD";
    public static final String COMMAND_EXAMPLE = "Example: searchchore groceries";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);
    private static final String EMPTY_LIST = "There are no matching chores in your list.";
    private static final String NON_EMPTY_LIST = "Here are your matching chores in your list";
    private static final String NUMBER_FORMAT = "%d.";
    
    private String keyword;
    
    /**
     * Constructor for Search Chore Command.
     * @param keyword the word to search.
     */
    public SearchChoreCommand(String keyword) {
        this.keyword = keyword;
    }
    
    /**
     * {@inheritDoc}
     * @param ingredientList list of ingredients.
     * @param recipeList     list of recipes.
     * @param choreList      list of chores.
     * @return the list of matching chores.
     */
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        ArrayList<Chore> findChoreList = new ArrayList<>();
        for (Chore chore : choreList) {
            if (chore.toString().toLowerCase().contains(keyword)) {
                findChoreList.add(chore);
            }
        }
        
        if (findChoreList.isEmpty()) {
            return new CommandResult(EMPTY_LIST);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NON_EMPTY_LIST)
                .append(Ui.LS);
        for (int i = 0; i < findChoreList.size(); ++i) {
            if (i == findChoreList.size() - 1) {
                sb.append(String.format(NUMBER_FORMAT, i + 1))
                        .append(findChoreList.get(i).toString());
                break;
            }
            sb.append(String.format(NUMBER_FORMAT, i + 1))
                    .append(findChoreList.get(i).toString())
                    .append(Ui.LS);
        }
        return new CommandResult(sb.toString());
        
    }
}
