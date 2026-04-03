import java.util.ArrayList;

public class OrderManager <T extends Order> {
    private ArrayList<T> allOrders = new ArrayList<>();;
  
    public OrderManager(){
    }

    public void addOrder(T order){
        this.allOrders.add(order);
    }

    public ArrayList<T> getAllOrders(){
        return this.allOrders;
    }

    public ArrayList<T> getOutstandingOrders(){
        ArrayList<T> outstandingOrders = new ArrayList<>();
        for (T order : this.allOrders){
            if (order.getStatus() == OrderStatus.ORDERED){
                outstandingOrders.add(order);
            }
        }
        return outstandingOrders;
    }

    public T findOutstandingOrderById(int id){
        for (T order : this.getOutstandingOrders()){
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    } 

}
