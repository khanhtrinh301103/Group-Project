package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */

/**
 * GiftProduct is an abstract class that represents a product that can be given as a gift.
 * It extends the Product class and adds a message field that can be set by the giver of the gift.
 */
public abstract class GiftProduct extends Product {

    private String message; // A message that can be set by the giver of the gift

    /**
     * Constructs a new GiftProduct object with the given name, description, quantity, and price.
     *
     * @param name        the name of the gift product
     * @param description a description of the gift product
     * @param quantity    the number of gift products available
     * @param price       the price of the gift product
     */
    public GiftProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    /**
     * Sets the message for the gift product.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
        System.out.println("Message set: " + this.message); // Debugging statement
    }

    /**
     * Gets the message for the gift product.
     *
     * @return the message for the gift product
     */
    public String getMessage() {
        return message;
    }

}
