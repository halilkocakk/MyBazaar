import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
       this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
       this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getTotalSpent() {
        double total = 0;
        for(Order order : orders) {
            total += order.getTotalCost();
        }
        return total;
    }

    public void printOrders() {
        for (Order order : orders) {
            order.printOrder();
        }
    }
}
