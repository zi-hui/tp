package seedu.kitchenhelper.command;

import seedu.kitchenhelper.exception.KitchenHelperException;
import seedu.kitchenhelper.object.Chore;
import seedu.kitchenhelper.object.Recipe;
import seedu.kitchenhelper.object.ingredient.Ingredient;
import seedu.kitchenhelper.ui.Ui;

import java.util.ArrayList;

/**
 * Search for recipe name in the recipe list.
 */
public class SearchRecipeCommand extends Command {
    
    public static final String COMMAND_WORD = "searchrecipe";
    public static final String COMMAND_DESC = "Find common recipe name in the recipe list using a keyword.";
    public static final String COMMAND_PARAMETER = "KEYWORD";
    public static final String COMMAND_EXAMPLE = "Example: searchrecipe chicken stew";
    public static final String COMMAND_FORMAT =
            String.format("%s %s\n%s", COMMAND_DESC, COMMAND_PARAMETER, COMMAND_EXAMPLE);
    public static final String MESSAGE_USAGE = String.format("%s: %s", COMMAND_WORD, COMMAND_DESC) + Ui.LS + String
            .format("Parameter: %s\n%s", COMMAND_PARAMETER, COMMAND_EXAMPLE);
    private static final String EMPTY_LIST = "There are no matching recipes in your list.";
    private static final String NON_EMPTY_LIST = "Here are your matching recipes in your list";
    private static final String RECIPE_INDEX = " located at listrecipe %d";
    private static final String NUMBER_FORMAT = "%d.";
    
    private String keyword;
    
    public SearchRecipeCommand(String keyword) {
        this.keyword = keyword;
    }
    
    @Override
    public CommandResult execute(ArrayList<Ingredient> ingredientList, ArrayList<Recipe> recipeList,
                                 ArrayList<Chore> choreList) {
        ArrayList<Recipe> findRecipeList = new ArrayList<>();
        ArrayList<Integer> recipeIndex = new ArrayList<>();
        int currIndex = 1;
        for (Recipe recipe : recipeList) {
            if (recipe.getRecipeName().toLowerCase().contains(keyword)) {
                findRecipeList.add(recipe);
                recipeIndex.add(currIndex);
            }
            currIndex++;
        }
        
        if (findRecipeList.isEmpty()) {
            return new CommandResult(EMPTY_LIST);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NON_EMPTY_LIST)
                .append(Ui.LS);
        for (int i = 0; i < findRecipeList.size(); ++i) {
            if (i == findRecipeList.size() - 1) {
                sb.append(String.format(NUMBER_FORMAT, i + 1))
                        .append(findRecipeList.get(i).getRecipeName())
                        .append(String.format(RECIPE_INDEX, recipeIndex.get(i)));
                break;
            }
            sb.append(String.format(NUMBER_FORMAT, i + 1))
                    .append(findRecipeList.get(i).getRecipeName())
                    .append(String.format(RECIPE_INDEX, recipeIndex.get(i)))
                    .append(Ui.LS);
        }
        return new CommandResult(sb.toString());
    }
}
