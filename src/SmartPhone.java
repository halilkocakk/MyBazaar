public class SmartPhone extends Electronic {
    private String screenType;

    public SmartPhone(double price, int quantity, String manufacturer, String brand,
                      int maxVoltage, int maxPower, String screenType) {
        super(price, quantity, manufacturer, brand, maxVoltage, maxPower);
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }
}
