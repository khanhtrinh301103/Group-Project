package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */


/**
 * This is the abstract base class for all products.
 * It defines common fields and methods for all products.
 * Subclasses must implement the getProductType() and toString() methods.
 */
public abstract class Product {

    // Fields
    private String name;
    private String description;
    private int quantity;
    private double price;

    // Constructor
    public Product(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters

    /**
     * Sets the name of this product.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid book title");
        }
    }

    /**
     * Sets the price of this product.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the quantity of this product.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the description of this product.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // Abstract methods

    /**
     * Returns the type of this product.
     * Subclasses must implement this method to specify the type of the product.
     *
     * @return the type of this product
     */
    public abstract String getProductType();

    /**
     * Returns a string representation of this product.
     * Subclasses must implement this method to provide a string representation of the product.
     *
     * @return a string representation of this product
     */
    public abstract String toString();
}

    /**
     * Sets whether this product is digital or physical.
     * @param isDigital true if this product is digital, false if it is physical
     */

