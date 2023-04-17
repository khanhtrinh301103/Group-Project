package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */


/**
 * CartItem represents a product in a shopping cart with its associated quantity and weight.
 */
public class CartItem {
    private Product product; // the product being represented by this cart item
    private int quantity; // the quantity of the product in the cart
    private double weight; // the weight of the product in the cart

    /**
     * Constructs a new CartItem with the given product, quantity, and weight.
     * @param product the product being represented by this cart item
     * @param quantity the quantity of the product in the cart
     * @param weight the weight of the product in the cart
     */
    public CartItem(Product product, int quantity, double weight) {
        this.product = product;
        this.quantity = quantity;
        this.weight = weight;
    }

    /**
     * Returns the product being represented by this cart item.
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the quantity of the product in the cart.
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the cart.
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Returns the weight of the product in the cart.
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of this CartItem.
     * @return a string representation
     */
    @Override
    public String toString() {
        return "CartItem [product=" + product + ", quantity=" + quantity + ", weight=" + weight + "]";
    }
}
