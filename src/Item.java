public class Item {
    private int itemID;
    private double price;
    private int quantity;
    private static int nextID = 1; //itemID must be unique among all kinds of item, so I use static because of this.

    public Item(double price, int quantity) {
        this.itemID = nextID++; // this causes IDs start from 1 and increasing sequentlly
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemType() {
        return this.getClass().getSimpleName().toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount <= 0 || amount > quantity) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        this.quantity -= amount;
    }
    public void displayInfo() {
        System.out.println("ItemID: " + itemID + "\nPrice: " + price + "\nQuantity: " + quantity);
    }
}
