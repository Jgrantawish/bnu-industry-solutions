import java.util.ArrayList;

 /**
 * The SupplierOrder class holds the details of a specific purchase transaction.
 * This includes the supplier, details about the goods ordered and the order status.
 */
public class SupplierOrder extends Order{
    private Supplier supplier;
    private ArrayList<QuantityItem> basket = new ArrayList<>();
    private double totalCost;

    public SupplierOrder(Supplier supplier, ArrayList<QuantityItem> basketItems){
        super();
        this.supplier = supplier;
        this.basket = basketItems;
        this.totalCost = calculateTotalCost();
    }

    /** Returns the total amount that BNU Industry Solutions will pay the Supplier for the goods in this order.*/
    private double calculateTotalCost(){
        double cost = 0;
        for (QuantityItem quantityItem : this.basket){
            cost += (quantityItem.getQuantity() * quantityItem.getUnitPurchasePrice());
        }
        return cost;
    }

    /** Returns a comma separated list summarising the goods purchased from the Supplier in this order.*/
    private String orderItemsToString(){
        String orderItemsString = "";
        for (int i = 0; i < this.basket.size(); i++){
            QuantityItem item = this.basket.get(i);
            orderItemsString += + item.getQuantity() + " x " + item.getName() + " @ £" + item.getUnitPurchasePrice() + " each";
            if (i < this.basket.size() - 1) {
                orderItemsString += ", ";
            }
        }
        return orderItemsString;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public ArrayList<QuantityItem> getBasket(){
        return this.basket;
    }

    public double getTotalCost(){
        return this.totalCost;
    }

    /** Overrides toString method to give a summary of the SupplierOrder's attributes */
    public String toString(){
        String orderSummaryString = this.orderItemsToString();
        return "Order ID: " + this.getId() + " -- From supplier " + this.supplier.getName() + " on " + this.getDate() + " -- Summary: " + orderSummaryString + " -- Total: £" + this.totalCost + " -- Status: " + this.getStatus();
    }
    
}
