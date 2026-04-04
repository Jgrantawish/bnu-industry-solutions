
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class QuantityItemTest {

    @Test
    public void createNewQuantityItemFromItemTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 3);
        assertEquals(quantBrick.getName(), "brick");
        assertEquals(quantBrick.getQuantity(), 3);
    }

    @Test
    public void createNewQuantityItemFromAttributesTest(){
        QuantityItem quantBrick = new QuantityItem("brick", "red brick", 3, null, 3);
        assertEquals(quantBrick.getName(), "brick");
        assertEquals(quantBrick.getQuantity(), 3);
    }

    
}
