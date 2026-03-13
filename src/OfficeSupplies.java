public abstract class OfficeSupplies extends Item{
    private int releaseYear;
    private String coverTitle;

    public OfficeSupplies(double price, int quantity, int releaseYear, String coverTitle) {

        super(price, quantity);
        this.releaseYear = releaseYear;
        this.coverTitle = coverTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCoverTitle() {
        return coverTitle;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Release Year: " + releaseYear + "Cover Title: " + coverTitle);
    }
}
