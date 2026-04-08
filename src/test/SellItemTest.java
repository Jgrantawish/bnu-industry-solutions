import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class SellItemTest {

    @Test
    public void createNewSellItemTest(){
        // Create SellItem from attributes
        SellItem sellBrick = new SellItem("brick", "red brick", 3, null, 3, 4.5);
        // Check that the new SellItem has the correct attributes 
        assertEquals(sellBrick.getName(), "brick");
        assertEquals(sellBrick.getQuantity(), 3);
        assertEquals(sellBrick.getUnitSellPrice(), 4.5, 0);
    }
    
}
