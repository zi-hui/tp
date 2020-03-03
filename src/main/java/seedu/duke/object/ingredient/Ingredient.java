package seedu.duke.object.ingredient;

public abstract class Ingredient {
    private String ingredientName;
    private String categoryName;
    private int quantity;
    private double price;
    private String expiryDate;

    public Ingredient(String ingredientName, String categoryName, int quantity, double price, String expiryDate){
        this.ingredientName = ingredientName;
        this.categoryName = categoryName;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
