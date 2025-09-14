package user;

import java.util.ArrayList;
import java.util.List;

import cart.Cart;

public class User {
    private static int SEQ = 0;
    private final int userId;
    private final String name;
    private final List<Cart> carts;

    public User(String name) { this(name, SEQ++); }
    public User(String name, int userId) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name is required");

        this.name = name.trim();
        this.userId = userId;
        this.carts = new ArrayList<>();
    }

    // methods
    public void addCart(Cart cart) { if (cart != null) carts.add(cart); }
    public void print() {
        System.out.println("User{id=" + userId + ", name='" + name + "', carts=" + carts.size() + "}");
    }

    // getters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Cart> getCarts() { return carts; }
}