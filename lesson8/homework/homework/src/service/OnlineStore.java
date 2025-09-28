package service;

import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Objects;

import cart.Cart;
import product.Product;
import product.Purchasable;
import user.User;

public class OnlineStore {
    private final List<User> users;

    public OnlineStore() { this(new ArrayList<>()); }
    public OnlineStore(List<User> initial) {
        this.users = new ArrayList<>();
        if (initial != null) this.users.addAll(initial);
    }

    public void addUser(User u) { if (u != null) users.add(u); }
    public List<User> getUsers() { return users; }

    public long purchaseAllParallel(Purchasable[] items) {
        if (items == null) return 0L;
        long count = Arrays.stream(items)
                .parallel()
                .filter(Objects::nonNull)
                .peek(Purchasable::purchase)
                .count();
        System.out.println("Processed purchases (parallel): " + count);
        return count;
    }

    public double totalPriceParallel() {
        return users.parallelStream()
                .flatMap(u -> u.getCarts().stream())
                .flatMap(Cart::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, Long> countByBrandParallel() {
        return users.parallelStream()
                .flatMap(u -> u.getCarts().stream())
                .flatMap(Cart::stream)
                .collect(Collectors.groupingBy(
                        Product::getBrand,
                        Collectors.counting()
                ));
    }

    
    public List<Product> topNByPrice(int n) {
        return users.parallelStream()
                .flatMap(u -> u.getCarts().stream())
                .flatMap(Cart::stream)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    
    public DoubleSummaryStatistics priceStatsParallel() {
        return users.parallelStream()
                .flatMap(u -> u.getCarts().stream())
                .flatMap(Cart::stream)
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }
    

    public static final OnlineStore def_store;
    static {
        def_store = new OnlineStore();

        Cart c1 = new Cart();
        c1.addToCart(new Product("iPhone 15", "Apple", 1000, "EUR"));
        c1.addToCart(new Product("ThinkPad X1", "Lenovo", 2000, "EUR"));

        Cart c2 = new Cart();
        c2.addToCart(new Product("Galaxy S24", "Samsung", 1500, "EUR"));

        User u1 = new User("Nikolay");  u1.addCart(c1);
        User u2 = new User("Filippov"); u2.addCart(c2);

        def_store.addUser(u1);
        def_store.addUser(u2);
    }

    public static int totalProductsCount() {
        int total = 0;
        for (User u : def_store.getUsers())
            for (Cart c : u.getCarts())
                total += c.getCount();
        return total;
    }
}
