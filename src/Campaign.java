import java.util.Date;

public class Campaign {
    private Date startDate;
    private Date endDate;
    private String itemType;
    private double discountRate;

    public Campaign(Date startDate, Date endDate, String itemType, double discountRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemType = itemType;
        this.discountRate = discountRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getItemType() {
        return itemType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public boolean isActive(Date now) {
        return !now.before(startDate) && !now.after(endDate); // kampanya sürecinde aktif mi kontrol ettimm
    }
    public void displayInfo() {
        System.out.println(
                "Item Type: " + itemType +
                        "\nStart Date: " + startDate +
                        "\nEnd Date: " + endDate +
                        "\nDiscount Rate: %" + discountRate
        );
    }

    @Override
    public String toString() {
        return "Campaign: " + itemType + "discountRate: " + discountRate + "from: " + startDate + "to: " + endDate;
    }
}
