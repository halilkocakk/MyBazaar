import java.util.Date;

public class Book extends OfficeSupplies{
    private String publisher;
    private String author;
    private int pages;

    public Book(double price, int quantity, int releaseYear,
                String coverTitle, String publisher, String author, int pages) {
        super(price, quantity, releaseYear, coverTitle);
        this.publisher = publisher;
        this.author = author;
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Publisher : " + publisher);
        System.out.println("Author : " + author);
        System.out.println("Pages : " + pages);
    }
}
