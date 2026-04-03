import java.time.LocalDate;
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

    public ArrayList<T> getOrdersForGivenMonth(int monthNumber){
        ArrayList<T> ordersForGivenMonth = new ArrayList<>();
        for (T order : this.allOrders){
            LocalDate orderDate = order.getDate();
            // If the order was placed this year and in the given month, then add to the list.
            if ((orderDate.getMonthValue() == monthNumber) && (orderDate.getYear() == LocalDate.now().getYear())) {
                ordersForGivenMonth.add(order);
            }
        }
        return ordersForGivenMonth;
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
