public class Technician extends Employee {
    private boolean isSenior;

    public Technician(String name, String email, String dateOfBirth, double salary, boolean isSenior) {
        super(name, email, dateOfBirth, salary);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void displayOrders(MyBazaar bazaar){

        if (!isSenior) {
            System.out.println("Only senior technicians can view all orders.");
            return;
        }
    }

    public void displayItemInfo(MyBazaar bazaar, int itemID) {

    }

    public void addItem(MyBazaar bazaar, Item item) {

    }

    @Override
    public void displayPersonData() {
        super.displayPersonData();
        System.out.println("Is Senior: " + isSenior);
    }
}
