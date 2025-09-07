package online_store;

public class Program {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.addToCart(new Product[] {
            new Product("iPhone 15", "Apple", 1000, "EUR"),
            new Product("Galaxy S24", "Samsung", 1500, "EUR")
        });
        cart2.addToCart(new Product[] {
            new Product("ThinkPad X1", "Lenovo", 2000, "EUR")
        });

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
    }
}
