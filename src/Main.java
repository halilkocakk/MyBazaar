import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        String usersFile = "Users.txt";
        String itemsFile = "Items.txt";
        String commandsFile = "Commands.txt";

        MyBazaar bazaar = new MyBazaar();

        bazaar.loadUsers(usersFile, MyBazaar.users);


        try {
            Scanner sc = new Scanner(new File(itemsFile));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    bazaar.loadItems(line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Items file not found: " + itemsFile);
        }


        bazaar.processCommand(commandsFile, MyBazaar.users, MyBazaar.items, MyBazaar.orders, MyBazaar.campaigns);
    }
}