import java.time.LocalDate;
import java.util.ArrayList;

 /**
 * The OrderManager Class maintains a list of all orders that have been placed. 
 * It provides the methods to filter orders based on the month they were placed or if they are yet to be delivered.
 * It also provides the method to find a specific order that has not yet been delivered.
 */
public class OrderManager <T extends Order> {
    private ArrayList<T> allOrders = new ArrayList<>();;
  
    public OrderManager(){
    }

    /** Adds either a CustomerOrder or SupplierOrder object to the list of current Orders */
    public void addOrder(T order){
        this.allOrders.add(order);
    }

    public ArrayList<T> getAllOrders(){
        return this.allOrders;
    }

    /** Returns a new ArrayList of orders that were placed in a given month of the current year. */
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

    /** Returns all orders that have been placed but are yet to be delivered. */
    public ArrayList<T> getOutstandingOrders(){
        ArrayList<T> outstandingOrders = new ArrayList<>();
        for (T order : this.allOrders){
            if (order.getStatus() == OrderStatus.ORDERED){
                outstandingOrders.add(order);
            }
        }
        return outstandingOrders;
    }

    /** Iterates through the list of orders that have not been delivered and returns the order object that matches the specified ID. 
     * Returns null if no Order with the specified ID exists.
     * */
    public T findOutstandingOrderById(int id){
        for (T order : this.getOutstandingOrders()){
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    } 

}
