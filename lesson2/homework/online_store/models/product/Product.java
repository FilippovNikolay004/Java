package product;

public class Product extends AbstractProduct  {
    // constructors
    public Product(String name, String brand) {
        super(name, brand);
    }
    public Product(String name, String brand, float price, String currency) {
        super(name, brand, price, currency);
    }
}
