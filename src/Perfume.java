public class Perfume extends Cosmetic{
    private int lastingDuration;

    public Perfume(double price, int quantity, String manufacturer, String brand,
                   boolean organic, int expirationYear, double weight, int lastingDuration) {
        super(price, quantity, manufacturer, brand, organic, expirationYear, weight);
        this.lastingDuration = lastingDuration;
    }

    public int getLastingDuration() {
        return lastingDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Lasting Duration: " + lastingDuration);
    }
}
