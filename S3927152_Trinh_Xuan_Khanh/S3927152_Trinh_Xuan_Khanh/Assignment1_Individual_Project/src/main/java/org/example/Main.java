package org.example;
/**
* @author <Trinh Xuan Khanh - s3927152>
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        OnlineBookstore bookstore = new OnlineBookstore();
        List<Product> productList = bookstore.getProducts();
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = null;
        String choice = "";

        // List of options by enter number 1 to 8
        while (!choice.equals("9")) { // Exit the list, system will stop
            System.out.println("                               ");
            System.out.println("*******************************");
            System.out.println("** Welcome to the Bookstore! **");
            System.out.println("*******************************");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Edit a book");
            System.out.println("4. Create a shopping cart");
            System.out.println("5. Add a book to the cart");
            System.out.println("6. Add book for gift");
            System.out.println("7. Remove a book from the cart");
            System.out.println("8. View shopping cart");
            System.out.println("9. Exit");
            System.out.println("                               ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1": // View all books have been added
                        System.out.println(productList);
                    break;
                case "2": // Add book to the list
                    System.out.print("Enter book name: "); // Enter book name to add
                    String name = scanner.nextLine();
                    System.out.print("Enter book's description: "); // Enter book description to add
                    String description = scanner.nextLine();
                    System.out.print("Enter quantity available: "); // Enter book quantity to add
                    int Quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter price: "); // Enter book price to add
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Is this a digital book? (y/n): "); // choose the type of book
                    String digitalChoice = scanner.nextLine();
                    boolean isDigital = false;
                    if (digitalChoice.equalsIgnoreCase("y")) {
                        isDigital = true;
                    }
                    boolean added = bookstore.addProduct(name, description, Quantity, price, isDigital);
                    if (added) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Book could not be added.");
                    }
                    break;
                case "3": // Edit book in the list
                    System.out.println("Editing a book...");
                    System.out.print("Enter book name that you want to edit: "); // Enter book name to edit
                    String productName = scanner.nextLine();
                    Product productToEdit = null;
                    for (Product product : productList) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            productToEdit = product;
                            break;
                        }
                    }
                    if (productToEdit == null) {
                        System.out.println("Book not found."); // If book not exist
                    } else {
                        System.out.print("Enter new book name (leave blank if no change): ");// Enter new book name
                        String newName = scanner.nextLine();
                        if (newName.equals("")) {
                            newName = productToEdit.getName();
                        }
                        System.out.print("Enter new book description (leave blank if no change): ");
                        // Enter new book description
                        String newDescription = scanner.nextLine();
                        if (newDescription.equals("")) {
                            newDescription = productToEdit.getDescription();
                        }
                        System.out.print("Enter new quantity available (leave blank if no change): ");
                        // Enter new book quantity
                        String newQuantityString = scanner.nextLine();
                        int newQuantity = -1;
                        if (!newQuantityString.equals("")) {
                            newQuantity = Integer.parseInt(newQuantityString);
                        } else {
                            newQuantity = productToEdit.getQuantity();
                        }
                        System.out.print("Enter new price (leave blank if no change): "); // Enter new book price
                        String newPriceString = scanner.nextLine();
                        double newPrice = -1;
                        if (!newPriceString.equals("")) {
                            newPrice = Double.parseDouble(newPriceString);
                        } else {
                            newPrice = productToEdit.getPrice();
                        }
                        boolean edited = bookstore.editProduct(productToEdit.getName(), newName, newDescription,
                                newQuantity, newPrice);
                        if (edited) {
                            System.out.println("Book edited successfully!");
                        } else {
                            System.out.println("Book could not be edited.");
                        }
                    }
                    break;
                case "4": // Create the shopping cart
                    System.out.println("Create shopping cart successfully");
                    cart = new ShoppingCart(productList);
                    break;
                case "5": // Add book to the shopping cart
                    if (cart == null) {
                        System.out.println("Please create a shopping cart first.");
                        // Check if not create shopping cart yet
                    } else {
                        System.out.print("Enter book's name: "); // Enter book name to add into shopping cart
                        String cartProductName = scanner.nextLine();
                        CartItem addedToCart = cart.addItem(cartProductName, bookstore.getProducts());
                        if (addedToCart != null) {
                            System.out.println("Book added to cart successfully!");
                        } else {
                            System.out.println("Book could not be added to cart.");
                        }
                    }
                    break;
                case "6":
                    if (cart == null) {
                        System.out.println("Please create a shopping cart to add gift first.");
                        // Check if not create shopping cart yet
                    } else {
                        Scanner giftProduct = new Scanner(System.in);
                        System.out.print("Enter book's for gift: "); // Enter book name to add into shopping cart
                        String cartProductName = scanner.nextLine();
                        System.out.println("Enter message for gift: ");
                        giftProduct.nextLine();
                        CartItem addedToCart = cart.addItem(cartProductName, bookstore.getProducts());
                        if (addedToCart != null) {
                            System.out.println("Book for gift added to cart successfully!");
                        } else {
                            System.out.println("Book for gift could not be added to cart.");
                        }
                    }
                    break;
                case "7": // Remove book from the shopping cart and return it to the list
                    if (cart == null) {
                        System.out.println("Please create a shopping cart first.");
                        // Check if not create shopping cart yet
                    } else {
                        System.out.print("Enter book name to remove from cart: "); // Enter book name to remove
                        String cartProductName = scanner.nextLine();
                        boolean removedFromCart = cart.removeItem(cartProductName);
                        if (removedFromCart) {
                            System.out.println("Book removed from cart successfully!");
                        } else {
                            System.out.println("Book not found in cart.");
                        }
                    }
                    break;

                case "8": // View the shopping cart
                    if (cart == null) {
                        System.out.println("Please create a shopping cart first.");
                        // Check if not create shopping cart yet
                    } else if (cart.getCartItems(productList).isEmpty()) {
                        System.out.println("Your cart is empty"); // Check if added book into shopping cart yet
                    } else {
                        System.out.println("Here are the books in your cart:");// Show shopping cart
                        for (CartItem item : cart.getCartItems(productList)) {
                            Product product = item.getProduct();
                            int quantity = item.getQuantity();
                            System.out.println("- " + product.getName() + " (" + quantity +
                                    ") - $" + product.getPrice());
                        }
                        double totalPrice = cart.getTotalPrice(productList);
                        System.out.println("Total: $" + totalPrice);
                    }
                    break;
            }
        }
    }
}
