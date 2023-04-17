package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */

/**
 * A subclass of GiftProduct representing a digital gift product.
 */
public class DigitalGiftProduct extends GiftProduct {

    /**
     * Constructor for creating a new DigitalGiftProduct object.
     *
     * @param name        the name of the digital gift product
     * @param description a description of the digital gift product
     * @param quantity    the quantity of the digital gift product available
     * @param price       the price of the digital gift product
     */
    public DigitalGiftProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    /**
     * Returns the product type of the digital gift product.
     *
     * @return the product type of the digital gift product
     */
    @Override
    public String getProductType() {
        return "DIGITAL_GIFT";
    }

    /**
     * Returns a string representation of the digital gift product.
     *
     * @return a string representation of the digital gift product
     */
    @Override
    public String toString() {
        return getProductType() + " - " + getName();
    }
}
