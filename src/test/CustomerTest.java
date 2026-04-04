import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void createNewCustomerTest(){
        // Create Customer
        Customer customer = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO IOP");
        // Check that the new customer has the correct attributes  
        assertEquals(customer.getName(), "Kim Kardashian");
        assertEquals(customer.getEmail(), "kimmy@hotmail.com");
    }
    
}
