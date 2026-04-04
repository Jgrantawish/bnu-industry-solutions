import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class InventoryStockTest {

    @Test
    public void createNewInventoryStockTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.getCurrentStockLevel(), 5);
    }

    @Test
    public void calculateAvgPurchasePriceTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.getAveragePurchasePrice(), 3, 0);
    }

    @Test
    public void calculateCurrentSellPriceTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.getCurrentSellPrice(), 4.5, 0);
    }

    @Test
    public void isLowTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 2);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.isLow(), true);

        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 10);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        assertEquals(screwStock.isLow(), false);
    }

    @Test
    public void isOutTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 0);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.isOut(), true);

        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 1);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        assertEquals(screwStock.isOut(), false);
    }

    @Test
    public void enoughInStockTest(){
        Item brick = new Item("brick", "red brick", 3, null);
        QuantityItem quantBrick = new QuantityItem(brick, 5);
        InventoryStock brickStock = new InventoryStock(quantBrick);
        assertEquals(brickStock.enoughInStock(2), true);

        Item screw = new Item("screw", "crosshead screw", 3, null);
        QuantityItem quantScrew = new QuantityItem(screw, 5);
        InventoryStock screwStock = new InventoryStock(quantScrew);
        assertEquals(screwStock.enoughInStock(7), false);
    }

    @Test
    public void addStockTest(){
        // Create a StockItem with a quantity of 5 
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
        // Create a StockItem with a quantity of 5 
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
