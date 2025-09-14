package product;

public abstract class AbstractProduct implements Purchasable {
	private String name;
    private String brand;
    private float price;
    private String currency;

    // constructors
    public AbstractProduct(String name, String brand) {
        this(name, brand, 0, "EUR");
    }
    public AbstractProduct(String name, String brand, float price, String currency) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("brand is required");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must be >= 0");
        }

        this.name = name.trim();
        this.brand = brand.trim();
        this.price = price;
        this.currency = (currency == null || currency.isBlank()) ? "EUR" : currency;
    }

    // helpers
    protected void customPrint(String text) {
        System.out.print(text);
    }

    // methods
    public void print() {
        customPrint("brand: " + getBrand() + "\n");
        customPrint("name: " + getName() + "\n");
        customPrint("price: " + getPrice());
        customPrint(getCurrency() + "\n");
    }

    @Override
    public void purchase() {
        customPrint("purchased: " + toString() + "\n");
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing Product: " + toString());
        } finally {
            super.finalize();
        }
    }

    // getters
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public float getPrice() { return price; }
    public String getCurrency() { return currency; }

    @Override
    public String toString() {
        return "Product{brand='" + brand + "', name='" + name + "', price=" + price + currency + "}";
    }
}
