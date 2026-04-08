import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CustomerOrderTest {

    @Test
    public void createNewCustomerOrderTest(){
        // Create Customer 
        Customer customer = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO IOP");
        // Create new SellItems
        SellItem sellBrick = new SellItem("brick", "red brick", 3, null, 10, 4.5);
        SellItem sellScrew = new SellItem("screw", "crosshead screw", 1, null, 20, 1.5);
        // Create basket of SellItems  
        ArrayList<SellItem> basket = new ArrayList<>();
        basket.add(sellBrick);
        basket.add(sellScrew);
        // Place CustomerOrder
        CustomerOrder order = new CustomerOrder(customer, basket);
        // Check that order has the correct attributes
        assertEquals(order.getId(), 1);
        assertEquals(order.getCustomer(), customer);
        assertEquals(order.getStatus(), OrderStatus.ORDERED);
    }
    

    @Test
    public void calculateTotalCostTest(){
        // Create Customer 
        Customer customer = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO IOP");
        // Create new SellItems
        SellItem sellBrick = new SellItem("brick", "red brick", 3, null, 10, 4.5);
        SellItem sellScrew = new SellItem("screw", "crosshead screw", 1, null, 20, 1.5);
        // Create basket of SellItems  
        ArrayList<SellItem> basket = new ArrayList<>();
        basket.add(sellBrick);
        basket.add(sellScrew);
        // Place CustomerOrder
        CustomerOrder order = new CustomerOrder(customer, basket);
        // Check that order the has calculated the correct total cost
        assertEquals(order.getTotalCost(), 75, 0);
    }


    @Test
    public void markAsDeliveredTest(){
        // Create Customer 
        Customer customer = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO IOP");
        // Create new SellItems
        SellItem sellBrick = new SellItem("brick", "red brick", 3, null, 10, 4.5);
        SellItem sellScrew = new SellItem("screw", "crosshead screw", 1, null, 20, 1.5);
        // Create basket of SellItems  
        ArrayList<SellItem> basket = new ArrayList<>();
        basket.add(sellBrick);
        basket.add(sellScrew);
        // Place CustomerOrder
        CustomerOrder order = new CustomerOrder(customer, basket);
        // Check that order has been placed 
        assertEquals(order.getStatus(), OrderStatus.ORDERED);
        // Mark order as delivered 
        order.markAsDelivered();
        assertEquals(order.getStatus(), OrderStatus.DELIVERED);
    }
    
}
