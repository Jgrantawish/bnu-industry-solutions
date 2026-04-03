import java.util.ArrayList;

public class CustomerOrder extends Order {
    private Customer customer;
    private ArrayList<SellItem> basket = new ArrayList<>();
    private double totalCost;

    public CustomerOrder(Customer customer, ArrayList<SellItem> basketItems){
        super();
        this.customer = customer;
        this.basket = basketItems;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost(){
        double cost = 0;
        for (SellItem sellItem : this.basket){
            cost += (sellItem.getQuantity() * sellItem.getUnitSellPrice());
        }
        return cost;
    }

    private String orderItemsToString(){
        String orderItemsString = "";
        for (int i = 0; i < this.basket.size(); i++){
            SellItem item = this.basket.get(i);
            orderItemsString += + item.getQuantity() + " x " + item.getName() + " @ £" + item.getUnitSellPrice() + " each";
            if (i < this.basket.size() - 1) {
                orderItemsString += ", ";
            }
        }
        return orderItemsString;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public double getTotalCost(){
        return this.totalCost;
    }

    public String toString(){
        String orderSummaryString = this.orderItemsToString();
        return "Order ID: " + this.getId() + " -- Ordered by " + this.customer.getName() + " on " + this.getDate() + " -- Summary: " + orderSummaryString + " -- Status: " + this.getStatus();
    }
    
}
