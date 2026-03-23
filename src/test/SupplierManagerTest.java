import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierManagerTest {

    @Test
    public void testAddSupplier(){
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        Supplier newSupplier = supplierManager.getContacts().get(0);
        assertEquals(newSupplier.getEmail(), "jo@bricks.com");
    }

    @Test
    public void findContactByEmailTest(){
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        supplierManager.addSupplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        supplierManager.addSupplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        Supplier supplier = supplierManager.findContactByEmail("bob@screwdeliveroo.com");
        assertEquals(supplier.getEmail(), "bob@screwdeliveroo.com");
    }

     @Test
    public void testDeleteSupplierByName(){
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        supplierManager.addSupplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        supplierManager.addSupplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        assertEquals(supplierManager.getContacts().size(), 3);
        supplierManager.deleteContactByEmail("bob@screwdeliveroo.com");
        assertEquals(supplierManager.getContacts().size(), 2);
    }
    
}
