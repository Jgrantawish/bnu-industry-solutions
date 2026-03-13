import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class InventoryItemTest {
    @Test
    public void test(){
        InventoryItem brick = new InventoryItem("brick", "red brick", 3, 5, 10, 3, null);
        assertEquals(brick.getName(), "brick");
    }
}
