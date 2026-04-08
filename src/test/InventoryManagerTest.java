import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class InventoryManagerTest {

    @Test
    public void addInventoryStockTest(){
        // Create InventoryManager
        InventoryManager inventoryManager = new InventoryManager();
        // Create InventoryStock item
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Add InventoryStock to InventoryManager 
        inventoryManager.addInventoryStock(brickStock);
        assertEquals(inventoryManager.getAllItemsInStock().size(), 1);
        // Check that the InventoryStock item attributes are correct
        InventoryStock addedStock = inventoryManager.getAllItemsInStock().get(0);
        assertEquals(addedStock.getName(), "brick");
        assertEquals(addedStock.getCurrentStockLevel(), 5);
    }

    @Test
    public void getItemsLowInStockTest(){
        // Create InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Create InventoryStock items and add them to InventoryManager
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 10);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        inventoryManager.addInventoryStock(screwStock);

        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 2);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        inventoryManager.addInventoryStock(brickStock);

        // Check that the brick item is low in stock (assume low in stock threshold is default 5 items left)
        assertEquals(inventoryManager.getItemsLowInStock().size(), 1);
        InventoryStock outOfStockProduct = inventoryManager.getItemsLowInStock().get(0);
        assertEquals(outOfStockProduct.getName(), "brick");
    }

    @Test
    public void getItemsOutOfStockTest(){
        // Create InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Create InventoryStock items and add them to InventoryManager
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 10);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        inventoryManager.addInventoryStock(screwStock);

        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 0);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        inventoryManager.addInventoryStock(brickStock);

        // Check that the brick item is out of stock
        assertEquals(inventoryManager.getAllItemsInStock().size(), 1);
        InventoryStock inStockProduct = inventoryManager.getAllItemsInStock().get(0);
        assertEquals(inStockProduct.getName(), "screw");

        assertEquals(inventoryManager.getItemsOutOfStock().size(), 1);
        InventoryStock outOfStockProduct = inventoryManager.getItemsOutOfStock().get(0);
        assertEquals(outOfStockProduct.getName(), "brick");
    }
    

    @Test
    public void findInventoryStockTest(){
        // Create InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Create InventoryStock items and add them to InventoryManager
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 10);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        inventoryManager.addInventoryStock(screwStock);

        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        inventoryManager.addInventoryStock(brickStock);

        // Find InventoryStock using the product name and check it is the correct item
        InventoryStock item = inventoryManager.findInventoryStockItemByName("brick");
        assertEquals(item.getCurrentStockLevel(), 5);
    }

}
