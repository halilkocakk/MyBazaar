import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class MyBazaar {

    static ArrayList<Person> users = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Campaign> campaigns = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    //private static int nextCustomerID;
    private static int nextCustomerID = 1;




    private static Admin findAdmin(String name) {
        for (Person person : users) {
            if (person instanceof Admin admin && admin.getName().equals(name)) {
                return admin;
            }
        }
        return null;
    }

    private Customer findCustomer(int id) {
        for (Person person : users) {
            if (person instanceof Customer customer && customer.getCustomerID() == id) {
                return customer;
            }
        }
        return null;
    }

    private Item findItem(int id) {
        for (Item item : items) {
            if (item.getItemID() == id) {
                return item;
            }
        }
        return null;
    }

    private Campaign findCampaign(String itemType) {
        for (Campaign campaign : campaigns) {
            if (campaign.getItemType().equals(itemType)) {
                return campaign;
            }
        }
        return null;
    }

    public void addAdmin(String adminName,
                         String name,
                         String email,
                         String dateOfBirth,
                         double salary,
                         String password) {

        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        Admin newAdmin = new Admin(name, email, dateOfBirth, salary, password);
        users.add(newAdmin);

        System.out.println("Admin " + name + " added successfully.");
    }

    public void addTechnician(String adminName,
                              String name,
                              String email,
                              String dateOfBirth,
                              double salary,
                              int isSenior) {

        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        Technician tech = new Technician(
                name,
                email,
                dateOfBirth,
                salary,
                isSenior == 1
        );

        users.add(tech);
        System.out.println("Technician " + name + " added successfully.");
    }


    public void showCustomer(String adminName, int customerID) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is customer with ID " + customerID + " exists!");
            return;
        }
        customer.displayPersonData();
    }

    public void showCustomers(String adminName) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }
        for (Person person : users) {
            if (person instanceof Customer customer) {
                customer.displayPersonData();
                System.out.println();
            }
        }
    }

    public void showAdminInfo(String adminName) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }
        admin.displayPersonData();
    }

    public void showOrders(String adminName) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }
        for (Order order : orders) {
            order.printOrder();
            System.out.println();
        }
    }

    public void showItemsLowOnStock(String adminName, int threshold) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }
        for (Item item : items) {
            if (item.getQuantity() < threshold) {
                item.displayInfo();
                System.out.println();
            }
        }
    }

    public static void showVIPCustomers(String adminName) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        for (Person person : users) {
            if (person instanceof Customer customer && customer.getStatus().equals("GOLDEN")) {
                customer.displayPersonData();
            }


        }

    }

    public void depositMoney(int customerID, double amount) {
        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is no customer with ID " + customerID + " exists!");
            return;
        }
        customer.depositMoney(amount);
        System.out.println("Money deposited");
    }

    public void changePassword(int customerID, String oldPW, String newPW) {
        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is no customer with ID " + customerID + " exists!");
            return;
        }
        customer.changePassword(oldPW, newPW);
        System.out.println("Password changed successfully");
    }


    public static void addCustomer(String adminName, String name, String email,
                                   String dateOfBirth, double balance, String password) {

        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        Customer customer = new Customer(name, email, dateOfBirth,  balance,password);
        nextCustomerID++;
        users.add(customer);

        System.out.println("Customer " + name + " added successfully");
    }

    public void addToCart(int customerID, int itemID) {
        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is no customer with ID: " + customerID);
            return;
        }
        Item item = findItem(itemID);
        if (item == null) {
            System.out.println("There is no item with ID: " + itemID);
            return;
        }

        if (item.getQuantity() <= 0) {
            System.out.println("Item " + itemID + "is stock out!");
            return;
        }

        customer.addToCart(item);
        System.out.println("Item " + itemID + " added to cart successfully");
    }

    public void emptyCart(int customerID) {
        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is no customer with ID: " + customerID);
            return;
        }

        customer.getShoppingCart().clear();
        System.out.println("Shopping cart emptied successfully");
    }

    public void createCampaign(String adminName, String startDateStr,
                               String endDateStr, String itemType, double discountRate) {
        Admin admin = findAdmin(adminName);
        if (admin == null) {
            System.out.println("There is no admin named " + adminName);
            return;
        }

        if (discountRate > 50) {
            System.out.println("Discount rate is cannot be greater than %50");
            return;
        }

        if (findCampaign(itemType) != null) {
            System.out.println("Campaign " + itemType + " already exists!");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            Campaign campaign = new Campaign(startDate, endDate, itemType, discountRate);
            campaigns.add(campaign);
            System.out.println(discountRate + "% sale of " + itemType + " to " + endDateStr +
                    " from " + startDateStr + " to " + endDateStr);

        } catch (Exception e) {
            System.out.println("Invalid date format.");

        }

    }

    public void placeOrder(int customerID, String password) {
        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("There is no customer with ID: " + customerID);
            return;
        }

        if (!customer.checkPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }

        if (customer.getShoppingCart().isEmpty()) {
            System.out.println("Shopping cart is empty!");
            return;
        }

        double totalCost = 0;
        Date now = new Date();
        for (Item item : customer.getShoppingCart().getItems()) {
            double itemPrice = item.getPrice();

            Campaign campaign = findCampaign(item.getItemType());
            if (campaign != null && campaign.isActive(now)) {
                itemPrice = itemPrice * (1 - campaign.getDiscountRate() / 100);
            }

            if (customer.getStatus().equals("SILVER")) {
                itemPrice = itemPrice * (1 - Customer.SILVER_RATE);

            }

            if (customer.getStatus().equals("GOLDEN")) {
                itemPrice = itemPrice * (1 - Customer.GOLDEN_RATE);

            }

            totalCost += itemPrice;

        }

        if (customer.getBalance() < totalCost) {
            System.out.println("Insufficient balance!");
            return;
        }

        for (Item item : customer.getShoppingCart().getItems()) {
            item.reduceQuantity(1);
        }

        Order order = new Order(customer.getCustomerID(),
                new ArrayList<>(customer.getShoppingCart().getItems()), totalCost);


        orders.add(order);
        customer.getOrderHistory().addOrder(order);
        customer.updateCustomerStatus();
        customer.getShoppingCart().clear();
        order.printOrder();

    }



    public void loadItems(String line) {

        String[] t = line.split("\t");
        String cmd = t[0];

        int itemID = items.size() + 1;
        int quantity = 1;

        switch (cmd) {

            case "BOOK": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);
                int releaseYear = Integer.parseInt(t[3]);
                String coverTitle = t[4];
                String publisher = t[5];
                String author = t[6];
                int pages = Integer.parseInt(t[7]);

                Book book = new Book(
                        price,
                        quantity,
                        releaseYear,
                        coverTitle,
                        publisher,
                        author,
                        pages
                );

                items.add(book);
                break;
            }

            case "CDDVD": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);
                int releaseYear = Integer.parseInt(t[3]);

                String title = t[4];
                String composer = t[5];
                String songs = t[6];

                CDDVD cd = new CDDVD(
                        price,
                        quantity,
                        releaseYear,
                        title,
                        composer,
                        songs
                );

                items.add(cd);
                break;
            }

            case "PERFUME": {
                double price = Double.parseDouble(t[1]);
                String manufacturer = t[2];
                String brand = t[3];
                boolean organic = t[4].equals("1");
                int expirationYear = Integer.parseInt(t[5]);
                double weight = Double.parseDouble(t[6]);
                int lastingDuration = Integer.parseInt(t[7]);

                Perfume perfume = new Perfume(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        organic,
                        expirationYear,
                        weight,
                        lastingDuration
                );

                items.add(perfume);
                break;
            }

            case "HAIRCARE": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                boolean organic = t[5].equals("1");
                int expirationYear = Integer.parseInt(t[6]);
                double weight = Double.parseDouble(t[7]);
                boolean medicated = t[8].equals("1");

                HairCare hairCare = new HairCare(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        organic,
                        expirationYear,
                        weight,
                        medicated
                );

                items.add(hairCare);
                break;
            }

            case "SKINCARE": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                boolean organic = t[5].equals("1");
                int expirationYear = Integer.parseInt(t[6]);
                double weight = Double.parseDouble(t[7]);
                boolean babySensitive = t[8].equals("1");

                SkinCare skinCare = new SkinCare(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        organic,
                        expirationYear,
                        weight,
                        babySensitive
                );

                items.add(skinCare);
                break;
            }


            case "DESKTOP": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                int maxVoltage = Integer.parseInt(t[5]);
                int maxPower = Integer.parseInt(t[6]);

                String OS = t[7];
                String CPUType = t[8];

                int RAMCapacity = Integer.parseInt(t[9]);
                int HDDCapacity = Integer.parseInt(t[10]);

                String boxColor = t[11];

                Desktop desktop = new Desktop(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        maxVoltage,
                        maxPower,
                        OS,
                        CPUType,
                        RAMCapacity,
                        HDDCapacity,
                        boxColor
                );

                items.add(desktop);
                break;
            }


            case "LAPTOP": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                int maxVoltage = Integer.parseInt(t[5]);
                int maxPower = Integer.parseInt(t[6]);

                String OS = t[7];
                String CPUType = t[8];

                int RAMCapacity = Integer.parseInt(t[9]);
                int HDDCapacity = Integer.parseInt(t[10]);

                String boxColor = t[11];
                boolean HDMISupport = t[12].equals("1");

                Laptop laptop = new Laptop(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        maxVoltage,
                        maxPower,
                        OS,
                        CPUType,
                        RAMCapacity,
                        HDDCapacity,
                        boxColor,
                        HDMISupport
                );

                items.add(laptop);
                break;
            }

            case "TABLET": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];
                int maxVoltage = Integer.parseInt(t[5]);
                int maxPower = Integer.parseInt(t[6]);
                String OS = t[7];
                String CPUType = t[8];
                int RAMCapacity = Integer.parseInt(t[9]);
                int HDDCapacity = Integer.parseInt(t[10]);
                int dimension = Integer.parseInt(t[11]);
                ;

                Tablet tablet = new Tablet(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        maxVoltage,
                        maxPower,
                        OS,
                        CPUType,
                        RAMCapacity,
                        HDDCapacity,
                        dimension
                );

                items.add(tablet);
                break;
            }


            case "SMARTPHONE": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                int maxVoltage = Integer.parseInt(t[5]);
                int maxPower = Integer.parseInt(t[6]);

                String screenType = t[7];

                SmartPhone smartPhone = new SmartPhone(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        maxVoltage,
                        maxPower,
                        screenType
                );

                items.add(smartPhone);
                break;
            }

            case "TV": {
                double price = Double.parseDouble(t[1]);
                quantity = Integer.parseInt(t[2]);

                String manufacturer = t[3];
                String brand = t[4];

                int maxVoltage = Integer.parseInt(t[5]);
                int maxPower = Integer.parseInt(t[6]);

                int screenSize = Integer.parseInt(t[7]);

                TV tv = new TV(
                        price,
                        quantity,
                        manufacturer,
                        brand,
                        maxVoltage,
                        maxPower,
                        screenSize
                );

                items.add(tv);
                break;
            }


            default:
                System.out.println("Item type not supported yet: " + t[0]);
        }
    }

    public static void loadUsers(String file, ArrayList<Person> users ) {
        users.clear();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\t");
                String type = parts[0].toUpperCase();

                // year -> String dateOfBirth formatına çeviriyorum
                String dateOfBirth = parts[3]; // sadece yıl string olarak

                if (type.equals("ADMIN")) {

                    Admin admin = new Admin(
                            parts[1],
                            parts[2],
                            parts[3],
                            Double.parseDouble(parts[4]),
                            parts[5]
                    );
                    users.add(admin);


                } else if (type.equals("CUSTOMER")) {

                    Customer cst = new Customer(
                            parts[1],
                            parts[2],
                            parts[3],
                            Double.parseDouble(parts[4]),
                            parts[5]

                    );
                    cst.setCustomerID(nextCustomerID++);
                    users.add(cst);


                } else if (type.equals("TECH")) {

                    String name = parts[1];
                    String email = parts[2];
                    double salary = Double.parseDouble(parts[4]);
                    boolean isSenior = parts[5].equals("1");

                    Technician technician = new Technician(
                            name,
                            email,
                            dateOfBirth,
                            salary,
                            isSenior
                    );

                    users.add(technician);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading users.txt: " + e.getMessage());
        }
    }


    public void processCommand(String commandsFile,
                        ArrayList<Person > users,
                        ArrayList<Item> items,
                        ArrayList<Order> orders,
                        ArrayList<Campaign> campaigns)
    {

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(commandsFile));

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] t = line.split("\t");
                String cmd = t[0];

                switch (cmd) {

                    case "ADDCUSTOMER":
                        addCustomer(t[1], t[2], t[3], t[4], Double.parseDouble(t[5]), t[6]);
                        break;

                    case "ADDADMIN":
                        addAdmin(t[1], t[2], t[3], t[4], Double.parseDouble(t[5]), t[6]);
                        break;

                    case "ADDTECH":
                        addTechnician(t[1], t[2], t[3], t[4], Double.parseDouble(t[5]), Integer.parseInt(t[6]));
                        break;


                    case "ADDTOCART":
                        addToCart(Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                        break;

                    case "EMPTYCART":
                        emptyCart(Integer.parseInt(t[1]));
                        break;

                    case "ORDER":
                        placeOrder(Integer.parseInt(t[1]), t[2]);
                        break;

                    case "CREATECAMPAIGN":
                        createCampaign(t[1], t[2], t[3], t[4], Double.parseDouble(t[5]));
                        break;

                    case "SHOWCUSTOMER":
                        showCustomer(t[1], Integer.parseInt(t[2]));
                        break;

                    case "SHOWCUSTOMERS":
                        showCustomers(t[1]);
                        break;

                    case "SHOWADMININFO":
                        showAdminInfo(t[1]);
                        break;

                    case "SHOWORDERS":
                        showOrders(t[1]);
                        break;

                    case "SHOWITEMSLOWONSTOCK":
                        showItemsLowOnStock(t[1], Integer.parseInt(t[2]));
                        break;

                    case "SHOWVIP":
                        System.out.println("Show VIP command received.");
                        showVIPCustomers(t[1]);
                        break;

                    case "DEPOSITMONEY":
                        depositMoney(Integer.parseInt(t[1]), Double.parseDouble(t[2]));
                        break;

                    case "CHPASS":
                        changePassword(Integer.parseInt(t[1]), t[2], t[3]);
                        break;

                    case "SHOWCAMPAIGNS":
                        System.out.println("Show campaigns command received.");
                        for (Campaign c : campaigns) {
                            c.displayInfo();
                            System.out.println(" ");
                        }

                        break;

                    default:
                        System.out.println("Unknown command: " + cmd);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading commands.txt: " + e.getMessage());
        }
    }
    public List<Item> getItems () {
        return items;
    }

    public List<Person> getUsers () {
        return users;
    }
}