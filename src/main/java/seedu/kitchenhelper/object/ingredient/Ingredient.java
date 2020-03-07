package seedu.kitchenhelper.object.ingredient;

/**
 * Represent an Ingredient object.
 */
public abstract class Ingredient {
    
    private String ingredientName;
    private String categoryName;
    private int quantity;
    private double price;
    private String expiryDate;
    
    /**
     * Constructor for Ingredient.
     *
     * @param ingredientName name of the ingredient.
     * @param categoryName   category of the ingredient.
     * @param quantity       quantity of the ingredient.
     * @param price          price of the ingredient.
     * @param expiryDate     expiry date of the ingredient.
     */
    public Ingredient(String ingredientName, String categoryName, int quantity, double price, String expiryDate) {
        this.ingredientName = ingredientName;
        this.categoryName = categoryName;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }
    
    /**
     * Getters for ingredient name.
     *
     * @return ingredient name.
     */
    public String getIngredientName() {
        return ingredientName;
    }
    
    /**
     * Getters for category name.
     *
     * @return category name.
     */
    public String getCategoryName() {
        return categoryName;
    }
    
    /**
     * Getters for quantity.
     *
     * @return quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setters for quantity.
     *
     * @param quantity quantity of ingredient
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getters for price.
     *
     * @return price.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Getters for expiry date.
     *
     * @return expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }
}
