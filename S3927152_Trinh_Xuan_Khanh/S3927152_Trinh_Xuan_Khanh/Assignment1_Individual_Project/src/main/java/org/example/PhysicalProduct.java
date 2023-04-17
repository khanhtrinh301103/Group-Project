package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */


/**
 * This class represents a physical product, which is a type of Product with an additional weight attribute.
 * It inherits attributes and methods from the Product class.
 */
public class PhysicalProduct extends Product {

    private double weight = 0;

    /**
     * Constructs a PhysicalProduct object with the given name, description, quantity, price, and weight.
     * @param name the name of the physical product
     * @param description the description of the physical product
     * @param quantity the quantity of the physical product
     * @param price the price of the physical product
     */
    public PhysicalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
        this.weight = weight;
    }

    /**
     * Gets the weight of the physical product.
     * @return the weight of the physical product
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the type of product, which is "Book type: PHYSICAL" for PhysicalProduct.
     * @return the type of product as a string
     */
    @Override
    public String getProductType() {
        return "Book type: PHYSICAL";
    }

    /**
     * Returns a string representation of the PhysicalProduct object, including its type, name, quantity, and price.
     * @return a string representation of the PhysicalProduct object
     */
    @Override
    public String toString() {
        return getProductType() + " - " + getName() +" - Description: "+ getDescription() +
                " - Quantity: " + getQuantity()
                + " - Price: " + "$" + getPrice() + "\n";
    }
}
