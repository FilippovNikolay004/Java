package product;

public class PhysicalProduct extends Product {
    private float weightKg;

    // constructors
    public PhysicalProduct(String name, String brand, float price, String currency, float weightKg) {
        super(name, brand, price, currency);
        if (weightKg < 0) {
            throw new IllegalArgumentException("weight must be >= 0");
        }
        this.weightKg = weightKg;
    }

    // methods
    @Override
    public void print() {
        super.print();
        customPrint("weight: " + getWeightKg() + "kg\n");
    }

    @Override
    public void purchase() {
        customPrint("shipping scheduled for: " + getName() + " (" + getWeightKg() + "kg)\n");
    }

    // getters
    public float getWeightKg() { return weightKg; }
}
