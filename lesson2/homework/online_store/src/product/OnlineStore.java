package product;

import java.util.List;

import cart.Cart;
import user.User;

import java.util.ArrayList;

public class OnlineStore {
    private final List<User> users;

    public OnlineStore() { this(new ArrayList<>()); }
    public OnlineStore(List<User> initial) {
        this.users = new ArrayList<>();
        if (initial != null) this.users.addAll(initial);
    }

    public void addUser(User u) { if (u != null) users.add(u); }
    public List<User> getUsers() { return users; }

    // methods
    public void purchaseAll(Purchasable[] items) {
        if (items == null) return;

        int count = 0;
        for (Purchasable it : items) {
            if (it == null) continue;
            it.purchase();
            count++;
        }
        System.out.println("Processed purchases: " + count);
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

