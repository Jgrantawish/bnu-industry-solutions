import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ContactManagerTest {

    @Test
    public void addSupplierTest(){
        // Create new SupplierManager
        ContactManager<Supplier> supplierManager = new ContactManager<>();
        // Create new Supplier and add it to SupplierManager
        Supplier supplier = new Supplier("jo", "jo@bricks.com", null, null, null);
        supplierManager.addContact(supplier);
        // Get the Contact added to the SupplierManager list and check it has the correct attributes  
        Supplier addedSupplier = supplierManager.getContacts().get(0);
        assertEquals(addedSupplier.getName(), "jo");
    }

    @Test
    public void addCustomerTest(){
        // Create new CustomerManager
        ContactManager<Customer> customerManager = new ContactManager<>();
        // Create new Customer and add it to CustomerManager
        Customer customer = new Customer("jo", "jo@bricks.com", null, null, null);
        customerManager.addContact(customer);
        // Get the Contact added to the CustomerManager list and check it has the correct attributes  
        Customer addedCustomer = customerManager.getContacts().get(0);
        assertEquals(addedCustomer.getName(), "jo");
    }

    @Test
    public void findSupplierByEmailTest(){
        // Create new SupplierManager
        ContactManager<Supplier> supplierManager = new ContactManager<>();
        // Create new Suppliers and add them to SupplierManager
        Supplier supplier = new Supplier("jo", "jo@bricks.com", null, null, null);
        supplierManager.addContact(supplier);
        Supplier supplier2 = new Supplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        supplierManager.addContact(supplier2);
        Supplier supplier3 = new Supplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        supplierManager.addContact(supplier3);
        // Find a supplier using their email address and check it is the correct supplier
        Supplier foundSupplier = supplierManager.findContactByEmail("bob@screwdeliveroo.com");
        assertEquals(foundSupplier.getName(), "bob");
    }

    @Test
    public void findCustomerByEmailTest(){
        // Create new CustomerManager
        ContactManager<Customer> customerManager = new ContactManager<>();
        // Create new Customers and add it to CustomerManager
        Customer customer = new Customer("jo", "jo@bricks.com", null, null, null);
        customerManager.addContact(customer);
        Customer customer2 = new Customer("Mike Scott", "m.scott@gmail.com", "018467967", "6B Ready Road, Wilkshire", "Y78 OBF");
        customerManager.addContact(customer2);
        Customer customer3 = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO ");
        customerManager.addContact(customer3);
        // Find a customer using their email address and check it is the correct customer
        Customer foundCustomer = customerManager.findContactByEmail("kimmy@hotmail.com");
        assertEquals(foundCustomer.getName(), "Kim Kardashian");
    }


    @Test
    public void deleteSupplierTest(){
        // Create new SupplierManager
        ContactManager<Supplier> supplierManager = new ContactManager<>();
        // Create new Suppliers and add them to SupplierManager
        Supplier supplier = new Supplier("jo", "jo@bricks.com", null, null, null);
        supplierManager.addContact(supplier);
        Supplier supplier2 = new Supplier("bob", "bob@screwdeliveroo.com", null, null, "A19 HPK");
        supplierManager.addContact(supplier2);
        Supplier supplier3 = new Supplier("Sustainable Wood Ltd", "info@sustainablewood.com", null, null, null);
        supplierManager.addContact(supplier3);
        // Check that 3 suppliers have been added to the list
        assertEquals(supplierManager.getContacts().size(), 3);
        // Delete supplier2 and check that they have been removed from the list
        supplierManager.deleteContact(supplier2);
        assertEquals(supplierManager.getContacts().size(), 2);
         // Try to find the deleted a supplier. It should no longer exist so null is returned
        Supplier foundSupplier = supplierManager.findContactByEmail("bob@screwdeliveroo.com");
        assertEquals(foundSupplier, null);
    }


    @Test
    public void deleteCustomerTest(){
        // Create new CustomerManager
        ContactManager<Customer> customerManager = new ContactManager<>();
        // Create new Customers and add it to CustomerManager
        Customer customer = new Customer("jo", "jo@bricks.com", null, null, null);
        customerManager.addContact(customer);
        Customer customer2 = new Customer("Mike Scott", "m.scott@gmail.com", "018467967", "6B Ready Road, Wilkshire", "Y78 OBF");
        customerManager.addContact(customer2);
        Customer customer3 = new Customer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO ");
        customerManager.addContact(customer3);
        // Check that 3 customers have been added to the list
        assertEquals(customerManager.getContacts().size(), 3);
        // Delete customer3 and check that they have been removed from the list
        customerManager.deleteContact(customer3);
        assertEquals(customerManager.getContacts().size(), 2);
         // Try to find the deleted a customer. It should no longer exist so null is returned
        Customer foundCustomer = customerManager.findContactByEmail("kimmy@hotmail.com");
        assertEquals(foundCustomer, null);
    }
    
}