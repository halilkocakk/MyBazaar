public class TV extends Electronic{
    private double screenSize;

    public TV(double price, int quantity, String manufacturer, String brand,
              int maxVoltage, int maxPower, double screenSize) {
        super(price, quantity, manufacturer, brand, maxVoltage, maxPower);
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }
}
