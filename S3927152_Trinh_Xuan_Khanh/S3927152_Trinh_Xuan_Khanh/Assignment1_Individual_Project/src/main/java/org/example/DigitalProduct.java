package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */

/**
 * Represents a digital product, which is a type of product that can be downloaded or accessed online.
 * Extends the abstract Product class and implements its abstract methods.
 */
public class DigitalProduct extends Product {

    /**
     * Creates a new DigitalProduct object with the given name, description, quantity, and price.
     * @param name the name of the digital product
     * @param description a brief description of the digital product
     * @param quantity the quantity of the digital product available for purchase
     * @param price the price of the digital product
     */
    public DigitalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    /**
     * Returns a string representation of the type of product.
     * @return a string representing the product type
     */
    @Override
    public String getProductType() {
        return "Book type: DIGITAL";
    }

    /**
     * Returns a string representation of the digital product.
     * @return a string representing the digital product
     */
    @Override
    public String toString() {
        return getProductType() + " - " + getName() +" - Description: "+ getDescription() +
                " - Quantity: " + getQuantity()
                + " - Price: " + "$" + getPrice() + "\n";
    }
}
