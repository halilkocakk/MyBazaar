public abstract class Cosmetic extends Item{
    // cosmetic is abstract because it represents a general category.
    private String manufacturer;
    private String brand;
    private boolean organic;
    private int expirationYear;
    private double weight;

    public Cosmetic(double price, int quantity, String manufacturer, String brand,
                    boolean organic, int expirationYear, double weight) {

        super(price, quantity);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.organic = organic;
        this.expirationYear = expirationYear;
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isOrganic() {
        return organic;
    }
    public int getExpirationYear() {
        return expirationYear;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // calls first parent class' displayInfo methods, then calls child class'
        System.out.println("Manufacturer: " + manufacturer +
                "\nBrand: " + brand + "\nOrganic: " + organic +
                "\nExpiration Year: " + expirationYear + "\nWeight: " + weight);
    }
}

