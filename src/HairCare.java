public class HairCare extends Cosmetic{
    private boolean medicated;

    public HairCare(double price, int quantity, String manufacturer, String brand,
                     boolean organic, int expirationYear, double weight, boolean medicated){
        super(price, quantity, manufacturer, brand, organic, expirationYear, weight);
        this.medicated = medicated;
    }

    public boolean isMedicated() {
        return medicated;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Medicated: " + medicated);
    }
}
