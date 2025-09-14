package product;

public class DigitalProduct extends Product {
    private int fileSizeMb;
    private String licenseKey;

    // constructors
    public DigitalProduct(String name, String brand, float price, String currency, int fileSizeMb) {
        this(name, brand, price, currency, fileSizeMb, null);
    }
    public DigitalProduct(String name, String brand, float price, String currency, int fileSizeMb, String licenseKey) {
        super(name, brand, price, currency);
        if (fileSizeMb < 0) {
            throw new IllegalArgumentException("file size must be >= 0");
        }
        this.fileSizeMb = fileSizeMb;
        this.licenseKey = (licenseKey != null && !licenseKey.isBlank()) ? licenseKey.trim() : null;
    }

    // methods
    @Override
    public void print() {
        super.print();
        customPrint("file size: " + getFileSizeMb() + "MB\n");
        if (licenseKey != null) {
            customPrint("license: " + licenseKey + "\n");
        }
    }

    @Override
    public void purchase() {
        customPrint("download link sent for: " + getName() + "\n");
        if (licenseKey != null) {
            customPrint("activation key: " + licenseKey + "\n");
        }
    }

    // getters
    public int getFileSizeMb() { return fileSizeMb; }
    public String getLicenseKey() { return licenseKey; }
}
