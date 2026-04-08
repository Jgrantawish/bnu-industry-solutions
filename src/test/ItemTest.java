import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class ItemTest {
    
    @Test
    public void createNewItemTest(){
        // Create Item
        Item brick = new Item("brick", "red brick", 3, null);
        // Check that the new Item has the correct attributes  
        assertEquals(brick.getName(), "brick");
    }

    @Test
    public void itemCopyConstructorTest(){
        // Create Item 
        Item brick1 = new Item("brick", "red brick", 3, null);
        // Use copy constructor to create an indentical Item
        Item identicalBrick = new Item(brick1);
        assertEquals(brick1.getName(), identicalBrick.getName());
    }

}
