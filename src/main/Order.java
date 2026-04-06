import java.time.LocalDate;
 
 /**
 * The Order Class holds the common details and attributes shared by Customer Orders and Supplier Orders.
 * The orderId unique identifier for an Order.
 */
public abstract class Order {
    private static int count = 0;
    private int orderId; 
    private LocalDate date;
    private OrderStatus status = OrderStatus.ORDERED; 
    
    public Order(){
        this.orderId = ++count;
        this.date = LocalDate.now();
    }

    public int getId(){
        return this.orderId;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public OrderStatus getStatus(){
        return this.status;
    }

    public void markAsDelivered(){
        this.status = OrderStatus.DELIVERED; 
    }

}
