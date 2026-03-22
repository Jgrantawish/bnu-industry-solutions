import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactManagerTest {

    @Test
    public void testAddSupplier(){
        ContactManager contactManager = new ContactManager();
        contactManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        Supplier newSupplier = contactManager.getSuppliers().get(0);
        assertEquals(newSupplier.getName(), "jo");
    }

    @Test
    public void testFindSupplierByName(){
        ContactManager contactManager = new ContactManager();
        contactManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        contactManager.addSupplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        contactManager.addSupplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        Supplier supplier = contactManager.findSupplierByName("bob");
        assertEquals(supplier.getName(), "bob");
    }

     @Test
    public void testDeleteSupplierByName(){
        ContactManager contactManager = new ContactManager();
        contactManager.addSupplier("jo", "jo@bricks.com", null, null, null);
        contactManager.addSupplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        contactManager.addSupplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        assertEquals(contactManager.getSuppliers().size(), 3);
        contactManager.deleteSupplierByName("bob");
        assertEquals(contactManager.getSuppliers().size(), 3);
    }
    
}
