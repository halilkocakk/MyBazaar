public class Laptop extends Computer{
    private boolean HDMISupport;

    public Laptop(double price, int quantity, String manufacturer, String brand,
                  int maxVoltage, int maxPower, String OS,
                  String CPUType, int RAMCapacity, int HDDCapacity, String boxColor, boolean HDMISupport){
        super(price, quantity, manufacturer, brand,
                maxVoltage, maxPower, OS,CPUType,RAMCapacity,HDDCapacity);

        this.HDMISupport = HDMISupport;
    }

    public boolean isHDMISupport() {
        return HDMISupport;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("HDMI support: " + HDMISupport);
    }
}
