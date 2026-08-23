import java.util.Scanner;

public class ECommerceSystem {

    static Scanner sc = new Scanner(System.in);

    static String[] products = {
        "Laptop",
        "Smartphone",
        "Headphones",
        "Keyboard",
        "Mouse"
    };

    static double[] prices = {
        50000,
        25000,
        2000,
        1500,
        800
    };

    static int[] cart = new int[5];

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== E-COMMERCE SYSTEM =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart();
                    break;

                case 3:
                    viewCart();
                    break;

                case 4:
                    checkout();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    // Display Products
    static void viewProducts() {

        System.out.println("\n===== AVAILABLE PRODUCTS =====");

        for (int i = 0; i < products.length; i++) {
            System.out.println(
                (i + 1) + ". " + products[i] +
                " - Rs." + prices[i]
            );
        }
    }

    // Add Product to Cart
    static void addToCart() {

        viewProducts();

        System.out.print("\nEnter product number: ");
        int productNo = sc.nextInt();

        if (productNo >= 1 && productNo <= products.length) {

            cart[productNo - 1]++;

            System.out.println(
                products[productNo - 1] +
                " added to cart!"
            );

        } else {
            System.out.println("Invalid product number!");
        }
    }

    // Display Cart
    static void viewCart() {

        double total = 0;
        boolean empty = true;

        System.out.println("\n===== YOUR CART =====");

        for (int i = 0; i < products.length; i++) {

            if (cart[i] > 0) {

                empty = false;

                double amount = prices[i] * cart[i];

                System.out.println(
                    products[i] +
                    " x " + cart[i] +
                    " = Rs." + amount
                );

                total += amount;
            }
        }

        if (empty) {
            System.out.println("Your cart is empty!");
        } else {
            System.out.println("----------------------");
            System.out.println("Total: Rs." + total);
        }
    }

    // Checkout
    static void checkout() {

        double total = 0;

        for (int i = 0; i < products.length; i++) {
            total += prices[i] * cart[i];
        }

        if (total == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Total Amount: Rs." + total);

        System.out.println("1. UPI");
        System.out.println("2. Credit/Debit Card");
        System.out.println("3. Cash on Delivery");

        System.out.print("Select Payment Method: ");
        int payment = sc.nextInt();

        if (payment >= 1 && payment <= 3) {

            System.out.println("Payment successful!");
            System.out.println("Order placed successfully!");

            for (int i = 0; i < cart.length; i++) {
                cart[i] = 0;
            }

        } else {
            System.out.println("Invalid payment method!");
        }
    }
}