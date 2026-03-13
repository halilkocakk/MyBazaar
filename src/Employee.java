public abstract class Employee extends Person{
    private double salary;

    public Employee(String name, String email, String dateOfBirth, double salary) {
        super(name, email, dateOfBirth);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayStock(MyBazaar bazaar) {
        System.out.println("--STOCK LIST--");
        for (Item item : bazaar.getItems()) {
            item.displayInfo();
            System.out.println(" ");
        }
    }

    public void displayItemType(MyBazaar bazaar, String typeName) {
        System.out.println("--- ITEMS OF TYPE: " + typeName + " ---");

        for (Item item : bazaar.getItems()) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(typeName)) {
                item.displayInfo();
                System.out.println(" ");
            }
        }
    }

    public void listAvailableItem(MyBazaar bazaar) {
        System.out.println("--- AVAILABLE ITEMS ---");

        for (Item item : bazaar.getItems()) {
            if (item.getQuantity() > 0) {
                item.displayInfo();
                System.out.println(" ");
            }
        }
    }

    public void displayVIP(MyBazaar bazaar) {
        System.out.println("--- VIP CUSTOMERS ---");

        for (Person person : bazaar.getUsers()) {
            if (person instanceof Customer customer) {
                if ("GOLDEN".equalsIgnoreCase(customer.getStatus()) ||
                        "PLATINUM".equalsIgnoreCase(customer.getStatus())) {

                    customer.displayPersonData();
                    System.out.println(" ");
                }
            }
        }
    }

    @Override
    public void displayPersonData() {
        super.displayPersonData();
        System.out.println("Salary: " + salary);
    }
}
