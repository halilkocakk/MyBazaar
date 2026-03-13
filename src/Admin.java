public class Admin extends Employee{
    private String password;

    public Admin(String name, String email, String dateOfBirth, double salary, String password) {
        super(name, email, dateOfBirth, salary);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void addCustomer(MyBazaar bazaar, Customer customer) {

    }

    public void addEmployee(MyBazaar bazaar, Employee employee) {

    }

    public void displayUserData(Customer customer) {

    }

    public void displayCustomers() {

    }

    public void launchCampaign(String itemType, double rate) {

    }

    @Override
    public void displayPersonData() {
        System.out.println("Admin");
        super.displayPersonData();
    }
}
