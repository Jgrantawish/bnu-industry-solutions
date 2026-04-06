import java.util.ArrayList;

 /**
 * The CustomerOrder class holds the details of a specific sale transaction.
 * This includes the customer, details about the goods ordered and the order status.
 */
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

    /** Returns the total amount that the Customer will pay for goods ordered.*/
    private double calculateTotalCost(){
        double cost = 0;
        for (SellItem sellItem : this.basket){
            cost += (sellItem.getQuantity() * sellItem.getUnitSellPrice());
        }
        return cost;
    }

    /** Returns a comma separated list summarising the goods purchased by the Customer in this order.*/
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

    /** Overrides toString method to give a summary of the CustomerOrder's attributes */
    public String toString(){
        String orderSummaryString = this.orderItemsToString();
        return "Order ID: " + this.getId() + " -- Ordered by " + this.customer.getName() + " on " + this.getDate() + " -- Summary: " + orderSummaryString + " -- Total: £" + this.totalCost + " -- Status: " + this.getStatus();
    }
    
}
