public abstract class Electronic extends Item{
    private int maxVoltage;
    private int maxPower;
    private String manufacturer;
    private String brand;

    public Electronic(double price, int quantity,
                      String manufacturer, String brand,
                      int maxVoltage, int maxPower) {
        super(price, quantity);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.maxVoltage = maxVoltage;
        this.maxPower = maxPower;
    }

    public int getMaxVoltage() {
        return maxVoltage;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Manufacturer: " + manufacturer +
                "Brand: " + brand + "Max Voltage: "
                + maxVoltage + "Max Power: " + maxPower);
    }
}
