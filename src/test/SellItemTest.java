import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class SellItemTest {

    @Test
    public void createNewQuantityItemTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 3);
        SellItem sellBrick = new SellItem(quantBrick, 4.5);
        assertEquals(sellBrick.getName(), "brick");
        assertEquals(sellBrick.getQuantity(), 3);
        assertEquals(sellBrick.getUnitSellPrice(), 4.5);
    }
    
}
