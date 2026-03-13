import java.util.ArrayList;

public class CDDVD extends OfficeSupplies{
    private String composer;
    private String songs;

    public CDDVD(double price, int quantity,
                 int releaseYear, String coverTitle, String composer, String songs) {
        super(price, quantity, releaseYear, coverTitle);
        this.composer = composer;
        this.songs = songs;
    }

    public String getComposer() {
        return composer;
    }

    public String getSongs() {
        return songs;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Composer: " + composer + "Songs: " + songs);
    }
}
