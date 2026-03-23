import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class ItemTest {
    
    @Test
    public void createNewItemTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        assertEquals(brick.getName(), "brick");
    }

    @Test
    public void itemCopyConstructorTest(){
        Item brick1 = new Item("brick", "red brick", 3, null);
        Item identicalBrick = new Item(brick1);
        assertEquals(brick1, identicalBrick);
    }

}
