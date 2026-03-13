public class SkinCare extends Cosmetic{
    private boolean babySensitive;

    public SkinCare(double price, int quantity, String manufacturer, String brand,
                     boolean organic, int expirationYear, double weight, boolean babySensitive) {
        super(price, quantity, manufacturer, brand, organic, expirationYear, weight);
        this.babySensitive =  babySensitive;
    }

    public boolean isBabySensitive() {
        return babySensitive;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Baby Sensitive: " + babySensitive);
    }
}
