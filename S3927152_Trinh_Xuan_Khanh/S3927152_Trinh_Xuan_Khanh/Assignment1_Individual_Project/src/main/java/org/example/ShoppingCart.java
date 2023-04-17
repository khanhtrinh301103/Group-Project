package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */
import java.util.*;

public class ShoppingCart {

    // Set to keep track of the unique items in the shopping cart
    private final Set<String> items;

    // Total weight of physical products in the shopping cart
    private double totalWeight;

    // Array of all available products
    private Product[] products;

    // Constructor to initialize the shopping cart with a list of products
    public ShoppingCart(List<Product> products) {
        // Create a new HashSet to store unique items in the shopping cart
        this.items = new HashSet<>();

        // Set total weight of physical products to zero
        this.totalWeight = 0.0;

        // Convert the list of products to an array of products
        this.products = products.toArray(new Product[0]);
    }

    // Method to add an item to the shopping cart
    public CartItem addItem(String productName, List<Product> products) {
        // Loop through the list of products to find the matching product
        for (Product product : products) {
            // If the product name matches and the quantity is greater than zero
            if (product.getName().equals(productName) && product.getQuantity() > 0) {
                // Decrease the quantity of the product by 1
                product.setQuantity(product.getQuantity() - 1);

                // Loop through the existing cart items to check if the product is already in the cart
                for (CartItem cartItem : getCartItems(products)) {
                    if (cartItem.getProduct().equals(product)) {
                        // If the product is already in the cart, increase the quantity by 1 and return the cart item
                        cartItem.setQuantity(cartItem.getQuantity() + 1);
                        return cartItem;
                    }
                }

                // If the product is not already in the cart, add it to the items set
                items.add(productName);

                // If the product is a physical product, add its weight to the total weight
                if (product instanceof PhysicalProduct) {
                    totalWeight += ((PhysicalProduct) product).getWeight();
                }

                // Create a new cart item with a quantity of 1 and return it
                return new CartItem(product, 1, product instanceof PhysicalProduct ? ((PhysicalProduct)
                        product).getWeight() : 0);
            }
        }
        // If no matching product is found, return null
        return null;
    }

    // Method to remove an item from the shopping cart
    public boolean removeItem(String productName) {
        // If the items set contains the product name
        if (items.contains(productName)) {
            // Loop through the array of products to find the matching product
            for (int i = 0; i < products.length; i++) {
                if (products[i].getName().equals(productName)) {
                    // Increase the quantity of the product by 1
                    products[i].setQuantity(products[i].getQuantity() + 1);

                    // Remove the product name from the items set
                    items.remove(productName);

                    // If the product is a physical product, subtract its weight from the total weight
                    if (products[i] instanceof PhysicalProduct) {
                        totalWeight -= ((PhysicalProduct) products[i]).getWeight();
                    }

                    // Return true to indicate that the product was successfully removed
                    return true;
                }
            }
        }
        // If no matching product is found or the items set does not contain the product name, return false
        return false;
    }

    // Method to calculate the total amount of the shopping cart
    public double cartAmount(List<Product> products){
        double total = 0;
        for (String itemName : items) {
            for (Product product : products) {
                if (product.getName().equals(itemName)) {
                    total += product.getPrice();
                }
            }
        }
        if (totalWeight > 1) {
            total += totalWeight * 0.1;
        }
        return total;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "ShoppingCart [items=" + items + ", totalWeight=" + totalWeight + "]";
    }
    public List<CartItem> getCartItems(List<Product> products) {
        List<CartItem> cartItems = new ArrayList<>();

        for (String itemName : items) {  // iterate over each item in the cart
            for (Product product : products) { // iterate over each product in the list of products
                if (product.getName().equals(itemName)) { // if the product matches the cart item
                    int quantity = Collections.frequency(items, itemName); // get the quantity of the item in the cart
                    double weight = 0.0;
                    if (product instanceof PhysicalProduct) { // if the product is a physical product, calculate the weight
                        weight = ((PhysicalProduct) product).getWeight() * quantity;
                    }
                    cartItems.add(new CartItem(product, quantity, weight)); // add the item to the list of cart items
                }
            }
        }

        return cartItems;
    }

    public double getTotalPrice(List<Product> products) {
        double totalPrice = 0.0;
        for (String itemName : items) { // iterate over each item in the cart
            for (Product product : products) { // iterate over each product in the list of products
                if (product.getName().equals(itemName)) { // if the product matches the cart item
                    totalPrice += product.getPrice(); // add the price of the item to the total price
                    if (product instanceof PhysicalProduct) { // if the product is a physical product, add the shipping cost to the total price
                        totalPrice += ((PhysicalProduct) product).getWeight() * 0.1;
                    }
                }
            }
        }
        return totalPrice;
    }

    public int getTotalQuantity(List<Product> products) {
        int totalQuantity = 0;
        for (String itemName : items) { // iterate over each item in the cart
            for (Product product : products) { // iterate over each product in the list of products
                if (product.getName().equals(itemName)) { // if the product matches the cart item
                    totalQuantity += product.getPrice(); // add the price of the item to the total quantity
                    if (product instanceof PhysicalProduct) { // if the product is a physical product, add the shipping

                        totalQuantity += ((PhysicalProduct) product).getWeight() * 0.1;
                    }
                }
            }
        }
        return totalQuantity;
    }

}

