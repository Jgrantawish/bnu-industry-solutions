import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class SupplierOrderTest {

    @Test
    public void createNewSupplierOrderTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Create Items sold by supplier
        Item brick = new Item("brick", "red brick", 3, supplier);
        Item screw = new Item("screw", "crosshead screw", 1, supplier);
        // Create basket of QuantityItems 
        ArrayList<QuantityItem> basket = new ArrayList<>();
        basket.add(new QuantityItem(brick, 15));
        basket.add(new QuantityItem(screw, 35));
        // Place SupplierOrder
        SupplierOrder order = new SupplierOrder(supplier, basket);
        // Check that order has the correct attributes
        assertEquals(order.getId(), 1);
        assertEquals(order.getSupplier(), supplier);
        assertEquals(order.getBasket(), basket);
    }
    
    @Test
    public void calculateTotalCostTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Create Items sold by supplier
        Item brick = new Item("brick", "red brick", 3, supplier);
        Item screw = new Item("screw", "crosshead screw", 1, supplier);
        // Create basket of QuantityItems 
        ArrayList<QuantityItem> basket = new ArrayList<>();
        basket.add(new QuantityItem(brick, 5));
        basket.add(new QuantityItem(screw, 10));
        // Place SupplierOrder
        SupplierOrder order = new SupplierOrder(supplier, basket);
        // Check that order the has calculated the correct total cost
        assertEquals(order.getTotalCost(), 25, 0);
    }
}
