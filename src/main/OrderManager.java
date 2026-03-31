import java.util.ArrayList;

public class OrderManager {
    private ArrayList<SupplierOrder> allSupplierOrders = new ArrayList<>();;
    private ArrayList<CustomerOrder> allCustomerOrders = new ArrayList<>();;
  
    public OrderManager(){
    }

    public ArrayList<SupplierOrder> getAllSupplierOrders(){
        return this.allSupplierOrders;
    }

    public ArrayList<CustomerOrder> getAllCustomerOrders(){
        return this.allCustomerOrders;
    }

    public ArrayList<SupplierOrder> getOutstandingSupplierOrders(){
        ArrayList<SupplierOrder> outstandingSupplierOrders = new ArrayList<>();
        for (SupplierOrder order : this.allSupplierOrders){
            if (order.getStatus() == Status.ORDERED){
                outstandingSupplierOrders.add(order);
            }
        }
        return outstandingSupplierOrders;
    }

    public ArrayList<CustomerOrder> getOutstandingCustomerOrders(){
        ArrayList<CustomerOrder> outstandingCustomerOrders = new ArrayList<>();
        for (CustomerOrder order : this.allCustomerOrders){
            if (order.getStatus() == Status.ORDERED){
                outstandingCustomerOrders.add(order);
            }
        }
        return outstandingCustomerOrders;
    }

}
