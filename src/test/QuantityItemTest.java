
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class QuantityItemTest {

    @Test
    public void createNewQuantityItemFromItemTest(){
        // Create Item
        Item brick = new Item("brick", "red brick", 3, null);
        // Use Item to create QuantityItem
        QuantityItem quantBrick = new QuantityItem(brick, 3);
        // Check that the new QuantityItem has the correct attributes  
        assertEquals(quantBrick.getName(), "brick");
        assertEquals(quantBrick.getQuantity(), 3);
    }

    @Test
    public void createNewQuantityItemFromAttributesTest(){
        // Create QuantityItem from attributes
        QuantityItem quantBrick = new QuantityItem("brick", "red brick", 3, null, 3);
        // Check that the new QuantityItem has the correct attributes that were passed in on construction
        assertEquals(quantBrick.getName(), "brick");
        assertEquals(quantBrick.getQuantity(), 3);
    }

}
