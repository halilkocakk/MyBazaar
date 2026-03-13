public class Desktop extends Computer{
    private String boxColor;

    public Desktop(double price, int quantity, String manufacturer, String brand,
                   int maxVoltage, int maxPower, String OS,
                   String CPUType, int RAMCapacity, int HDDCapacity, String boxColor){
        super(price, quantity, manufacturer, brand, maxVoltage, maxPower, OS,CPUType,RAMCapacity,HDDCapacity);
        this.boxColor = boxColor;
    }

    public String getBoxColor() {
        return boxColor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Box Color: " + boxColor);
    }
}
