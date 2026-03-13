import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date orderDate;
    private double totalCost;
    private List<Item> purchasedItems;
    private int customerID;

    public Order(int customerID, List<Item> purchasedItems, double totalCost) {
        this.orderDate = new Date();
        this.customerID = customerID;
        this.purchasedItems = new ArrayList<>(purchasedItems);
        this.totalCost = totalCost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemCount() {
        return purchasedItems.size();
    }


    public void printOrder(){
        System.out.println("Order Date: " + orderDate + "Customer  ID: " + customerID +
                "Total Price: " + totalCost);
        }
}

