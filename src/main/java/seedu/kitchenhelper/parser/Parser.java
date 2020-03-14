package seedu.kitchenhelper.parser;

import seedu.kitchenhelper.command.Command;
import seedu.kitchenhelper.command.AddRecipeCommand;
import seedu.kitchenhelper.command.AddIngredientCommand;
import seedu.kitchenhelper.command.DeleteRecipeCommand;
import seedu.kitchenhelper.command.DeleteIngredientCommand;
import seedu.kitchenhelper.command.ListCommand;
import seedu.kitchenhelper.command.DeleteCommand;
import seedu.kitchenhelper.command.HelpCommand;
import seedu.kitchenhelper.command.ExitCommand;
import seedu.kitchenhelper.command.InvalidCommand;

import seedu.kitchenhelper.exception.KitchenHelperException;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse user input.
 */

public class Parser {

    public static final Logger kitchenlogs = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public final String warningPrepareRecipe = "An IO exception has been caught";

    /**
     * Parses user input into command for execution.
     *
     * @param input full user input string.
     * @return the command based on the user input.
     */
    public Command parseUserCommand(String input) throws KitchenHelperException {
        String[] userInputs = splitInputLine(input, " ");
        final String commandWord = userInputs[0];
        final String parameters = userInputs[1];
        switch (commandWord.toLowerCase()) {
        case AddRecipeCommand.COMMAND_WORD:
            return prepareAddRecipe(parameters);
        case AddIngredientCommand.COMMAND_WORD:
            return prepareAddIngredient(parameters);
        case DeleteRecipeCommand.COMMAND_WORD:
            return prepareDeleteRecipe(parameters);
        case DeleteIngredientCommand.COMMAND_WORD:
            return prepareDeleteIngredient(parameters);
        case ListCommand.COMMAND_WORD:
            ListCommand listCmd = new ListCommand();
            HashMap<String, String> listParams = prepareListParams(parameters);
            listCmd.setListParams(listParams);
            return listCmd;
        case DeleteCommand.COMMAND_WORD:
            DeleteCommand deleteCmd = new DeleteCommand();
            HashMap<String, String> deleteParams = prepareDeleteParams(parameters);
            deleteCmd.setDeleteParams(deleteParams);
            return deleteCmd;
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        default:
            return new InvalidCommand();
        }
    }

    /**
     * Prepares the addition of ingredients into recipe.
     *
     * @param attributes full user input string.
     * @return hashmap of a formatted list of ingredients.
     * @throws KitchenHelperException if the command is invalid
     */
    public Command prepareAddRecipe(String attributes) throws KitchenHelperException {
        HashMap<String[], Integer> ingrAndQty = new HashMap<>();
        String ingredientList;
        AddRecipeCommand addCmd = new AddRecipeCommand();
        try {
            ingredientList = attributes.substring(attributes.indexOf("/i") + 3);
            String[] splitedIngr = ingredientList.split("[,][\\s]");
            for (String item : splitedIngr) {
                String[] ingrContent = item.split(":");
                String[] nameAndType = new String[2];
                nameAndType[0] = ingrContent[0];
                nameAndType[1] = ingrContent[2];
                ingrAndQty.put(nameAndType, Integer.parseInt(ingrContent[1]));
            }
        } catch (IndexOutOfBoundsException e) {
            kitchenlogs.log(Level.WARNING, warningPrepareRecipe, e.toString());
            return new InvalidCommand(
                    String.format("%s\n%s", InvalidCommand.MESSAGE_INVALID, AddRecipeCommand.COMMAND_FORMAT));
        }
        addCmd.setAttributesOfCmd(attributes, ingrAndQty);
        return addCmd;
    }
    
    /**
     * Prepares the addition of ingredient into inventory.
     *
     * @param attributes full user input string.
     * @return the prepared command.
     */
    public Command prepareAddIngredient(String attributes) {
        try {
            // Regex for checking the format of add ingredient
            String addInventoryRegex =
                    "/n [a-zA-Z]+( [a-zA-Z]+)* /c [a-zA-Z]+ /q [0-9]+ /p \\d+(\\.\\d{1,2})? /e \\d{4}-\\d{2}-\\d{2}";
            if (!isValidUserInputFormat(attributes, addInventoryRegex)) {
                throw new KitchenHelperException("Invalid Add Inventory Format");
            }
    
            String[] nameAndOthers = attributes.split("/c\\s", 2);
            String itemName = nameAndOthers[0].split("/n\\s+")[1].trim();
            assert itemName.length() > 0 : itemName;
            
            String[] categoryAndOthers = nameAndOthers[1].split("\\s+/q\\s+");
            String category = categoryAndOthers[0].trim();
            assert category.length() > 0 : category;
            
            String[] quantityAndOthers = categoryAndOthers[1].split("\\s+/p\\s+");
            int quantity = Integer.parseInt(quantityAndOthers[0]);
            assert quantity >= 0 : quantity;
            
            String[] priceAndExpiry = quantityAndOthers[1].split("\\s+/e\\s+");
            double price = Double.parseDouble(priceAndExpiry[0]);
            assert price >= 0.00 : price;
            
            String expiry = priceAndExpiry[1];
            
            return new AddIngredientCommand(itemName, category, quantity, price, expiry);
        } catch (KitchenHelperException khe) {
            kitchenlogs.log(Level.WARNING,InvalidCommand.MESSAGE_INVALID + " " + attributes);
            return new InvalidCommand(
                    String.format("%s\n%s", InvalidCommand.MESSAGE_INVALID, AddIngredientCommand.COMMAND_FORMAT));
        }
    }
  
    /**
     * Prepares the parameters needed for the list function.
     *
     * @param attributes full user input string.
     * @return the prepared command.
     */
    private HashMap<String, String> prepareListParams(String attributes) throws KitchenHelperException {
        HashMap<String, String> listParam = new HashMap<>();
        try {
            String[] typeName = attributes.split("\\s", 2);
            listParam.put("type", typeName[0].trim());
            if (typeName.length == 2) {
                listParam.put("item", typeName[1].trim());
            }
            if (listParam.get("type").equalsIgnoreCase("recipe") && typeName.length != 2) {
                throw new KitchenHelperException("list recipe <integer>");
            }
            if (listParam.get("type").isEmpty()) {
                throw new KitchenHelperException("list <type>");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new KitchenHelperException(ListCommand.COMMAND_FORMAT);
        }
        return listParam;
    }

    /**
     * Prepares the deletion of recipe from the lists.
     *
     * @param parameters full user input string.
     * @return hashmap of a formatted list of parameters to be deleted.
     * @throws KitchenHelperException if the command is invalid
     */

    private Command prepareDeleteRecipe(String parameters) throws KitchenHelperException {
        try {
            String [] typeAndName = parameters.split("/n\\s",2);
            return new DeleteRecipeCommand(typeAndName[1].trim());
        } catch (IndexOutOfBoundsException e) {
            throw new KitchenHelperException(DeleteRecipeCommand.COMMAND_FORMAT);
        }
    }

    /**
     * Prepares the deletion of ingredients from the lists.
     *
     * @param parameters full user input string.
     * @return hashmap of a formatted list of parameters to be deleted.
     * @throws KitchenHelperException if the command is invalid
     */

    private Command prepareDeleteIngredient(String parameters) throws KitchenHelperException {
        try {
            String [] typeAndName = parameters.split("/n\\s", 2);
            String [] nameAndQuantity = typeAndName[1].split("/q\\s", 2);
            if (nameAndQuantity.length > 1) {
                return new DeleteIngredientCommand(nameAndQuantity[0].trim(), Integer.parseInt(nameAndQuantity[1]));
            } else {
                return new DeleteIngredientCommand(nameAndQuantity[0].trim(), -1);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new KitchenHelperException(DeleteIngredientCommand.COMMAND_FORMAT);
        }
    }

    private HashMap<String, String> prepareDeleteParams(String attributes) throws KitchenHelperException {
        HashMap<String, String> deleteParam = new HashMap<>();
        try {
            if (attributes.indexOf("/n") == -1) {
                String [] typeAndNumber = attributes.split(" ", 2);
                deleteParam.put("type", typeAndNumber[0].trim());
                deleteParam.put("nameToDelete", typeAndNumber[1].trim());
                deleteParam.put("quantity", "-1");
            }
        } catch (IndexOutOfBoundsException e) {
            if (deleteParam.get("type").equalsIgnoreCase("chore")) {
                throw new KitchenHelperException("delete chore <integer>");
            }
            throw new KitchenHelperException("");
        }
        return deleteParam;
    }
    
    //@@author AY1920S2-CS2113T-M16-2-reused
    //Reused from
    //https://github.com/nus-cs2113-AY1920S2/contacts/blob/master/src/main/java/Contacts1.java
    
    /**
     * Split the user input into two parts with a specific regex.
     *
     * @param rawUserInput full user input string.
     * @param regex        the quantifier to separate the string.
     * @return an array of size 2 separated by the quantifier.
     */
    public static String[] splitInputLine(String rawUserInput, String regex) {
        String[] split = rawUserInput.trim().split(regex, 2);
        return split.length == 2 ? split : new String[]{split[0], ""}; // else no parameters
    }
    //@@author
    
    /**
     * Checks if the input string matches the regex.
     *
     * @param attributes the user input string.
     * @param regex      quantifier to check if valid.
     * @return true if it match, otherwise false.
     */
    public boolean isValidUserInputFormat(String attributes, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        boolean isMatch = matcher.matches();
        if (isMatch) {
            return true;
        }
        return false;
    }
}
