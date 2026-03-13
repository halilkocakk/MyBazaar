public class Tablet extends Computer{
    private int dimension;

    public Tablet(double price, int quantity, String manufacturer, String brand,
                  int maxVoltage, int maxPower, String OS,
                  String CPUType, int RAMCapacity, int HDDCapacity, int dimension){
        super(price, quantity, manufacturer, brand,
                maxVoltage, maxPower, OS,CPUType,RAMCapacity,HDDCapacity);

        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Dimension: " + dimension);
    }
}
