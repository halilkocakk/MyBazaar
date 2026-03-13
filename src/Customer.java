public class Customer extends Person{

    public static final double SILVER_LIMIT = 1000;
    public static final double GOLDEN_LIMIT = 5000;

    public static final double SILVER_RATE = 0.10;
    public static final double GOLDEN_RATE = 0.15;

    public static final String CLASSIC = "CLASSIC";
    public static final String SILVER = "SILVER";
    public static final String GOLDEN = "GOLDEN";

    private int customerID;
    private String password;
    private double balance;
    private String status;

    private ShoppingCart shoppingCart;
    private OrderHistory orderHistory;
    int nextCustomerID=1;

    public Customer(String name, String email, String dateOfBirth, double balance,
                    String password) {
        super(name, email, dateOfBirth);
        this.customerID = nextCustomerID++;

        this.password = password;
        this.balance = balance;
        this.status = "CLASSIC";

        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new OrderHistory();

    }

    public void setCustomerID(int id) {
        this.customerID = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String oldPw, String newPw) {
        if (this.password.equals(oldPw)) {
            this.password = newPw;
        } else {
            System.out.println("Incorrect previous password!");
        }
    }

    public void depositMoney(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void addToCart(Item item) {
        shoppingCart.addItem(item);
    }

    public void emptyCart() {
        shoppingCart.clear();
    }

    public void updateCustomerStatus() {
        double spent = orderHistory.getTotalSpent();

        if (spent >= GOLDEN_LIMIT) {
            status = "GOLDEN";
        }
        else if (spent >= SILVER_LIMIT) {
            status = "SILVER";
        }
        else {
            status = "CLASSIC";
        }
    }

    public void viewCampaigns() {
        System.out.println("Available campaigns will be listed by MyBazaar...");
    }

    @Override
    public void displayPersonData() {
        super.displayPersonData();
        System.out.println("Customer ID: " + customerID +
                " Password: " + password + " Balance: " + balance + " Status: " + status);
    }

    @Override
    public String toString() {
        return  "Customer name: " + getName() + " ID: " + customerID +
                " e-mail: " + getEmail() +
                " Date of Birth: " + getDateOfBirth() +
                " Status: " + status;
    }
}
