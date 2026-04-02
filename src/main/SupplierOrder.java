import java.util.ArrayList;

public class SupplierOrder extends Order{
    private Supplier supplier;
    private ArrayList<QuantityItem> basket = new ArrayList<>();; 

    public SupplierOrder(Supplier supplier, ArrayList<QuantityItem> basketItems){
        super();
        this.supplier = supplier;
        this.basket = basketItems;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public ArrayList<QuantityItem> getBasket(){
        return this.basket;
    }

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

    public String toString(){
        String orderSummaryString = this.orderItemsToString();
        return "Order ID: " + this.getId() + " -- From supplier " + this.supplier.getName() + " on " + this.getDate() + " -- Summary: " + orderSummaryString + " -- Status: " + this.getStatus();
    }
    
}
