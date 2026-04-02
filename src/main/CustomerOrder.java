import java.util.ArrayList;

public class CustomerOrder extends Order {
    private Customer customer;
    private ArrayList<SellItem> basket = new ArrayList<>();; 

    public CustomerOrder(Customer customer, ArrayList<SellItem> basketItems){
        super();
        this.customer = customer;
        this.basket = basketItems;
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

    public String toString(){
        String orderSummaryString = this.orderItemsToString();
        return "Order ID: " + this.getId() + " -- Ordered by " + this.customer.getName() + " on " + this.getDate() + " -- Summary: " + orderSummaryString + " -- Status: " + this.getStatus();
    }
    
}
