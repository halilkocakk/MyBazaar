public abstract class Computer extends Electronic{
    private String OS;
    private String CPUType;
    private int RAMCapacity;
    private int HDDCapacity;

    public Computer(double price, int quantity, String manufacturer, String brand,
                    int maxVoltage, int maxPower, String OS,
                    String CPUType, int RAMCapacity, int HDDCapacity) {
        super(price, quantity, manufacturer, brand, maxVoltage, maxPower);
        this.OS = OS;
        this.CPUType = CPUType;
        this.RAMCapacity = RAMCapacity;
        this.HDDCapacity = HDDCapacity;
    }

    public String getOS() {
        return OS;
    }

    public String getCPUType() {
        return CPUType;
    }

    public int getRAMCapacity() {
        return RAMCapacity;
    }

    public int getHDDCapacity() {
        return HDDCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("OS: " + this.OS + "CPUType: " + this.CPUType +
                "RAMCapacity: " + this.RAMCapacity + "HDDCapacity:  " + this.HDDCapacity);
    }
}
