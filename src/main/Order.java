import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
    private static int count = 0;
    private int orderId; 
    private LocalDate date;
    private Status status = Status.ORDERED; 
    
    public Order(){
        this.orderId = ++count;
        this.date = LocalDate.now();

    }

    public void markAsDelivered(){

    }
    
}
