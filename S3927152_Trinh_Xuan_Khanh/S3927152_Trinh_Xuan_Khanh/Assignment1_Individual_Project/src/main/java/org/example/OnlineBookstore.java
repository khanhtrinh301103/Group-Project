package org.example;
/**
 * @author <Trinh Xuan Khanh - s3927152>
 */
import java.util.ArrayList;

/**
 * Represents an online bookstore that stores a collection of products.
 */
public class OnlineBookstore {
    private ArrayList<Product> products;

    /**
     * Initializes an empty collection of products.
     */
    public OnlineBookstore() {
        this.products = new ArrayList<Product>();
    }

    /**
     * Adds a new product to the collection of products.
     * @param name the name of the product
     * @param description the description of the product
     * @param quantity the quantity of the product
     * @param price the price of the product
     * @param isDigital true if the product is digital, false otherwise
     * @return true if the product was added successfully, false otherwise
     */
    public boolean addProduct(String name, String description, int quantity, double price, boolean isDigital) {
        // Check if the product already exists in the collection
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return false;
            }
        }

        // If the product does not exist, create a new product object and add it to the collection
        Product product;
        if (isDigital) {
            product = new DigitalProduct(name, description, quantity, price);
        } else {
            product = new PhysicalProduct(name, description, quantity, price);
        }
        products.add(product);
        return true;
    }

    /**
     * Edits the information of an existing product.
     * @param name the name of the product to be edited
     * @param newName the new name of the product (can be empty to keep the original name)
     * @param newDescription the new description of the product (can be empty to keep the original description)
     * @param newQuantity the new quantity of the product (-1 to keep the original quantity)
     * @param newPrice the new price of the product (-1 to keep the original price)
     * @return true if the product was edited successfully, false otherwise
     */
    public boolean editProduct(String name, String newName, String newDescription, int newQuantity, double newPrice) {
        // Search for the product based on its name
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                // If the product is found, modify its information
                Product product = products.get(i);
                if (!newName.equals("")) {
                    product.setName(newName);
                }
                if (!newDescription.equals("")) {
                    product.setDescription(newDescription);
                }
                if (newQuantity != -1) {
                    product.setQuantity(newQuantity);
                }
                if (newPrice != -1) {
                    product.setPrice(newPrice);
                }
                products.set(i, product);
                return true;
            }
        }
        // If the product cannot be found, return false
        return false;
    }

    /**
     * Returns the collection of products.
     * @return the collection of products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
}

