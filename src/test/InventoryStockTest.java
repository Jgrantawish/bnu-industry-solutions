import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class InventoryStockTest {

    @Test
    public void createNewInventoryStockTest(){
         // Create Item
        Item brick = new Item("brick", "red brick", 3, null);
        // Use Item to create QuantityItem
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        // Create InventoryStock item from QuantityItem
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the InventoryStock item has the same name as the QuantityItem
        assertEquals(brickStock.getName(), "brick");
        // Check that the stock level has been set to the correct quantity 
        assertEquals(brickStock.getCurrentStockLevel(), 5);
    }

    @Test
    public void calculateAvgPurchasePriceTest(){
        // Create InventoryStock item 
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the correct average purchase price has been calculated 
        assertEquals(brickStock.getAveragePurchasePrice(), 3, 0);
    }

    @Test
    public void calculateCurrentSellPriceTest(){
        // Create InventoryStock item 
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the correct sell price has been calculated using the default mark-up multiplier
        assertEquals(brickStock.getCurrentSellPrice(), 4.5, 0);
    }

    @Test
    public void isLowTest(){
        // Create InventoryStock item with a quantity below the default 'Low in Stock' threshold
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 2);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the item is 'Low In Stock'
        assertEquals(brickStock.isLow(), true);

        // Create InventoryStock item with a quantity above the default 'Low in Stock' threshold
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 10);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        // Check that the item is not 'Low In Stock'
        assertEquals(screwStock.isLow(), false);
    }

    @Test
    public void isOutTest(){
        // Create InventoryStock item with no stock
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 0);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the item is 'Out of Stock'
        assertEquals(brickStock.isOut(), true);

        // Create InventoryStock item with some stock left
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 1);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        // Check that the item is not 'Out of Stock'
        assertEquals(screwStock.isOut(), false);
    }

    @Test
    public void enoughInStockTest(){
        // Create InventoryStock item
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        // Check that the item is has more stock than we need
        assertEquals(brickStock.enoughInStock(2), true);

        // Create InventoryStock item
        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 5);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        // Check that the item does not have enough stock
        assertEquals(screwStock.enoughInStock(7), false);
    }

    @Test
    public void addStockTest(){
        // Create InventoryStock item with a quantity of 5 
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.getCurrentStockLevel(), 5);
        // Create another QuantityItem with a quantity of 2 
        QuantityItem newQuantBrick = new QuantityItem(brick, 2);
        brickStock.addStock(newQuantBrick);
        assertEquals(brickStock.getCurrentStockLevel(), 7);
    }

    @Test
    public void reduceStockTest(){
        // Create InventoryStock item with a quantity of 5 
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.getCurrentStockLevel(), 5);
        // Create SellItem with a quantity of 2 
        SellItem sellBrick = new SellItem("brick", "red brick", 3, null, 2, 4.5);
        brickStock.reduceStock(sellBrick);
        assertEquals(brickStock.getCurrentStockLevel(), 3);

    }

}
