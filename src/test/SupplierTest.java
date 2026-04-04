import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class SupplierTest {

    @Test
    public void createNewSupplierTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Check that the new supplier has the correct attributes  
        assertEquals(supplier.getName(), "SuperBricksRUs");
        assertEquals(supplier.getEmail(), "sales@superbricks.com");

    }

    @Test
    public void addSupplierItemTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Check that the supplierItemList is empty 
        assertEquals(supplier.getSupplierItems().size(), 0);
        // Create new supplier item 
        Item brick = new Item("brick", "red brick", 3, supplier);
        // Add item to Supplier 
        supplier.addItem(brick);
        // Check that the supplierItemList is now not empty 
        assertEquals(supplier.getSupplierItems().size(), 1);
        // Get the item in the supplierItemList and check it is the one that we added
        Item supplierItem = supplier.getSupplierItems().get(0);
        assertEquals(supplierItem, brick);

    }

    @Test
    public void deleteSupplierItemTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Create new supplier item and add it to supplier
        Item brick = new Item("brick", "red brick", 3, supplier);
        supplier.addItem(brick);
        // Check that the supplierItemList has that item in it 
        assertEquals(supplier.getSupplierItems().size(), 1);
        supplier.deleteItem(brick);
        // Check that the supplierItemList is now empty and the item has been removed 
        assertEquals(supplier.getSupplierItems().size(), 0);
    }

    @Test
    public void findSupplierItemByNameTest(){
        // Create Supplier 
        Supplier supplier = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        // Create new supplier items and add them to supplier
        Item brick = new Item("brick", "red brick", 3, supplier);
        supplier.addItem(brick);
        Item screw = new Item("screw", "crosshead screw", 3, supplier);
        supplier.addItem(screw);
        // Check supplier item can be found
        assertEquals(supplier.findItemByName("bob"), null);
        assertEquals(supplier.findItemByName("screw"), screw);

    }
    
}
