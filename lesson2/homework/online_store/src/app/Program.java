package app;

import cart.Cart;
import product.DigitalProduct;
import product.PhysicalProduct;
import product.Product;
import product.Purchasable;
import service.OnlineStore;
import user.User;

public class Program {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.addToCart(new Product[] {
            new Product("iPhone 15", "Apple", 1000, "EUR"),
            new Product("Galaxy S24", "Samsung", 1500, "EUR"),
            new Product("iPhone 15", "Apple", 999, "EUR")
        });
        cart2.addToCart(new Product[] {
            new Product("ThinkPad X1", "Lenovo", 2000, "EUR")
        });

        PhysicalProduct phoneBox = new PhysicalProduct("iPhone 15 (boxed)", "Apple", 1020, "EUR", 0.23f);
        DigitalProduct antivirus = new DigitalProduct("Antivirus Pro", "BestSoft", 50, "EUR", 250, "ABC-123-XYZ");

        cart1.addToCart(phoneBox);
        cart2.addToCart(antivirus);

        User user1 = new User("Nikolay");
        User user2 = new User("Filippov");
        user1.addCart(cart1);
        user2.addCart(cart1);
        user2.addCart(cart2);

        OnlineStore store = new OnlineStore();
        store.addUser(user1);
        store.addUser(user2);

        System.out.println("\n=== #1 ===");
        cart1.printAllProducts();
        user1.print();

        System.out.println("\n=== #2 ===");
        cart2.printAllProducts();
        user2.print();

        System.out.println("\nTotal products in store: " + OnlineStore.totalProductsCount());

        System.out.println("\n=== purchaseAll demo ===");
        store.purchaseAll(new Purchasable[] {
            new Product("Gift Card", "Store", 25, "EUR"),
            phoneBox,
            antivirus
        });

        System.out.println("\n=== findById demo ===");
        int okId = phoneBox.getId();
        int badId = 999;

        Product found = cart1.findById(okId);
        if (found != null) {
            System.out.println("Found product by id=" + okId + ":");
            found.print();
        }

        Product missing = cart1.findById(badId);
        if (missing == null) {
            System.out.println("Nothing found by id=" + badId);
        }
        
        System.out.println("\n=== Guava Multimap: products by brand ===");
        cart1.printProductsByBrand("Apple");
        cart1.printProductsByBrand("Samsung");
        cart1.printProductsByBrand("Lenovo");

        System.out.println("\n=== Guava Multiset: counts ===");
        cart1.printBrandCounts();
        cart1.printNameCounts();
        
        System.out.println("\n=== Remove by name (iPhone 15) and recount ===");
        cart1.removeFromCartByName("iPhone 15");
        cart1.printBrandCounts();
        cart1.printProductsByBrand("Apple");
    }
}
