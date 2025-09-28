package app;

import cart.Cart;
import product.DigitalProduct;
import product.PhysicalProduct;
import product.Product;
import product.Purchasable;
import service.OnlineStore;
import user.User;

import java.util.List;
import java.util.Map;
import java.util.DoubleSummaryStatistics;

public class Program {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.addToCart(new Product[] {
            new Product("iPhone 15", "Apple", 1000, "EUR"),
            new Product("Galaxy S24", "Samsung", 1500, "EUR"),
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

        System.out.println("\n=== purchaseAll demo (PARALLEL) ===");
        store.purchaseAllParallel(new Purchasable[] {
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
        
        System.out.println("\n=== Parallel Streams analytics ===");
        double total = store.totalPriceParallel();
        System.out.println("Parallel total price across all carts: " + total + " EUR");

        Map<String, Long> byBrand = store.countByBrandParallel();
        System.out.println("Counts by brand (parallel): " + byBrand);

        List<Product> top2 = store.topNByPrice(2);
        System.out.println("Top-2 by price (parallel):");
        for (Product p : top2) {
            p.print();
            System.out.println();
        }

        DoubleSummaryStatistics stats = store.priceStatsParallel();
        System.out.println("Price stats (parallel): " + stats);
    }
}