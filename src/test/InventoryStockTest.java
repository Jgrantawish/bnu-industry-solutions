import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class InventoryStockTest {

    @Test
    public void createNewInventoryStockTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 3);
        InventoryStock brickStock = new InventoryStock(quantBrick, 1.5, 1);
        assertEquals(brickStock.getCurrentSellPrice(), 4.5);
    }

}
