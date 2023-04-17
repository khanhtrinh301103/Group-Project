package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */

/**
 * Represents a physical gift product, which is a type of gift product with a weight.
 * Extends the abstract GiftProduct class.
 */
public class PhysicalGiftProduct extends GiftProduct {

    private final double weight; // the weight of the physical gift product

    /**
     * Constructs a PhysicalGiftProduct object with the specified name, description, quantity, price, and weight.
     *
     * @param name the name of the physical gift product
     * @param description the description of the physical gift product
     * @param quantity the quantity of the physical gift product
     * @param price the price of the physical gift product
     * @param weight the weight of the physical gift product
     */
    public PhysicalGiftProduct(String name, String description, int quantity, double price, double weight) {
        super(name, description, quantity, price);
        this.weight = weight;
    }

    /**
     * Returns the weight of the physical gift product.
     *
     * @return the weight of the physical gift product
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the product type of the physical gift product as a string.
     *
     * @return the product type of the physical gift product as a string ("PHYSICAL_GIFT")
     */
    @Override
    public String getProductType() {
        return "PHYSICAL_GIFT";
    }

    /**
     * Returns a string representation of the physical gift product.
     *
     * @return a string representation of the physical gift product, including the product type and name
     */
    @Override
    public String toString() {
        return getProductType() + " - " + getName();
    }
}
