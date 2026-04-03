import java.util.ArrayList;

public class WarehouseManagementSystem {
    private ContactManager<Supplier> supplierManager = new ContactManager<Supplier>();
    private ContactManager<Customer> customerManager = new ContactManager<Customer>();
    private InventoryManager inventoryManager = new InventoryManager();
    private OrderManager<SupplierOrder> supplierOrderManager = new OrderManager<SupplierOrder>();
    private OrderManager<CustomerOrder> customerOrderManager = new OrderManager<CustomerOrder>();


    public WarehouseManagementSystem(){

    }

    private ArrayList<Item> getAllSupplierItems(){
        ArrayList<Item> allSupplierItems = new ArrayList<>();
        for (Supplier supplier : this.supplierManager.getContacts()){
            ArrayList<Item> supplierItems = supplier.getSupplierItems();
            for (Item item : supplierItems){
                allSupplierItems.add(item);
            }
        }
        return allSupplierItems;
    }

    public void createDummyData(){

        // Add Customers
        this.addCustomer("Mike Scott", "m.scott@gmail.com", "018467967", "6B Ready Road, Wilkshire", "Y78 OBF");
        this.addCustomer("Kim Kardashian", "kimmy@hotmail.com", "+1 4556 7998", "9 MoonBeam Lane, Icecream Central", "TPO ");

        // Create fake suppliers
        Supplier supplier1 = new Supplier("SuperBricksRUs", "sales@superbricks.com", "+1 568 67890", "69 Sue Lane, WaterBridge, Carringdon ", "CK67 069");
        Supplier supplier2 = new Supplier("Tom Drew", "tom@gmail.com", "+44 6789 077001", "5 Tung Street, Oxford", "OX4 3TZ");
        Supplier supplier3 = new Supplier("Screws4You", "bob@screws4you.co.uk","+44 5670 989100", "64 Zoo Lane, Sahor", "PGB 365");

        // Add suppliers to SupplierManager
        this.supplierManager.addContact(supplier1);
        this.supplierManager.addContact(supplier2);
        this.supplierManager.addContact(supplier3);

        // Create Supplier Items 
        Item item1 = new Item("Red Brick", "Lightweight multi-purpose red coloured brick - dimentions: 10cm x 10cm x 20cm", 1.95, supplier1);
        Item item2 = new Item("Grey Brick", "Lightweight multi-purpose grey coloured brick - dimentions: 10cm x 10cm x 20cm", 1.95, supplier1);
        Item item3 = new Item("Wooden Plank", "1m long plank of pine wood", 3.5, supplier2);
        Item item4 = new Item("Lightbulb", "10w lightbulb", 0.75, supplier2);
        Item item5 = new Item("Gloves", "One size leather gloves", 2, supplier2);
        Item item6 = new Item("Screw", "Crosshead wood screw", 0.2, supplier3);

        // Add Items to Suppliers 
        supplier1.addItem(item1);
        supplier1.addItem(item2);

        supplier2.addItem(item3);
        supplier2.addItem(item4);
        supplier2.addItem(item5);

        supplier3.addItem(item6);

        // Create Supplier Orders
        ArrayList<QuantityItem> basket1 = new ArrayList<>();
        basket1.add(new QuantityItem(item1, 20));
        basket1.add(new QuantityItem(item2, 15));
        this.placeSupplierOrder(supplier1, basket1);

        ArrayList<QuantityItem> basket2 = new ArrayList<>();
        basket2.add(new QuantityItem(item3, 30));
        basket2.add(new QuantityItem(item4, 10));
        basket2.add(new QuantityItem(item5, 5));
        this.placeSupplierOrder(supplier2, basket2);

        ArrayList<QuantityItem> basket3 = new ArrayList<>();
        basket3.add(new QuantityItem(item6, 100));
        this.placeSupplierOrder(supplier3, basket3);

        // Mark Supplier Orders as delivered and add stock to inventory 
        SupplierOrder order2 = this.supplierOrderManager.findOutstandingOrderById(2);
        this.markSupplierOrderAsDelivered(order2);

        SupplierOrder order3 = this.supplierOrderManager.findOutstandingOrderById(3);
        this.markSupplierOrderAsDelivered(order3);
    }




    public void addSupplier(String name, String email, String phone, String address, String postcode){
        Supplier supplier = new Supplier(name, email, phone, address, postcode);
        this.supplierManager.addContact(supplier);
    }

    public Supplier findSupplierByEmail(String email){
        return this.supplierManager.findContactByEmail(email);
    }

    public ArrayList<Supplier> getSuppliers(){
        return this.supplierManager.getContacts();
    }

    public void deleteSupplier(Supplier supplier){
        this.supplierManager.deleteContact(supplier);
    }

    public ArrayList<SupplierOrder> getOrderHistoryOfSupplier(Supplier supplier){
        ArrayList<SupplierOrder> orderHistory = new ArrayList<>();
        for (SupplierOrder order : supplierOrderManager.getAllOrders()){
            if (order.getSupplier().equals(supplier)){
                orderHistory.add(order);
            }

        }
        return orderHistory;
    }


    public void addCustomer(String name, String email, String phone, String address, String postcode){
        Customer customer = new Customer(name, email, phone, address, postcode);
        this.customerManager.addContact(customer);
    }

    public Customer findCustomerByEmail(String email){
        return this.customerManager.findContactByEmail(email);
    }

    public ArrayList<Customer> getCustomers(){
        return this.customerManager.getContacts();
    }

    public void deleteCustomer(Customer customer){
        this.customerManager.deleteContact(customer);
    }

    public ArrayList<CustomerOrder> getOrderHistoryOfCustomer(Customer customer){
        ArrayList<CustomerOrder> orderHistory = new ArrayList<>();
        for (CustomerOrder order : customerOrderManager.getAllOrders()){
            if (order.getCustomer().equals(customer)){
                orderHistory.add(order);
            }

        }
        return orderHistory;
    }

    public Item findSupplierItemByName(String itemName){
        ArrayList<Item> allSupplierItems = getAllSupplierItems();
        for (Item item: allSupplierItems){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    } 

    public void addSupplierItem(String itemName, String description, double price, Supplier supplier){
        Item newItem = new Item(itemName, description, price, supplier);
        supplier.addItem(newItem);
    }

    public InventoryStock findInventoryStockItemByName(String name){
        return this.inventoryManager.findInventoryStockItemByName(name);
    }

    public ArrayList<InventoryStock> getInStockItems(){
        return this.inventoryManager.getAllItemsInStock();
    }

    public ArrayList<InventoryStock> getLowInStockItems(){
        return this.inventoryManager.getItemsLowInStock();
    }

    public ArrayList<InventoryStock> getOutOfStockItems(){
        return this.inventoryManager.getItemsOutOfStock();
    }


    public SupplierOrder findOutstandingSupplierOrderById(int id){
        return this.supplierOrderManager.findOutstandingOrderById(id);
    }

    public ArrayList<SupplierOrder> getOutstandingSupplierOrders(){
        return this.supplierOrderManager.getOutstandingOrders();
    }

    public void placeSupplierOrder(Supplier supplier, ArrayList<QuantityItem> basket){
        SupplierOrder order = new SupplierOrder(supplier, basket);
        this.supplierOrderManager.addOrder(order);
    }

    public void markSupplierOrderAsDelivered(SupplierOrder order){
        order.markAsDelivered();
        ArrayList<QuantityItem> orderedItems = order.getBasket();
        for (QuantityItem item: orderedItems){
            InventoryStock stockItem = inventoryManager.findInventoryStockItemByName(item.getName());
            if (stockItem != null){
                stockItem.addStock(item);
            }
            else {
                inventoryManager.addInventoryStock(new InventoryStock(item));
            }
        }
    }


    public CustomerOrder findOutstandingCustomerOrderById(int id){
        return this.customerOrderManager.findOutstandingOrderById(id);
    }

    public ArrayList<CustomerOrder> getOutstandingCustomerOrders(){
        return this.customerOrderManager.getOutstandingOrders();
    }

    public void placeCustomerOrder(Customer customer, ArrayList<SellItem> basket){
        customerOrderManager.addOrder(new CustomerOrder(customer , basket));
        for (SellItem item: basket){
            InventoryStock stockItem = inventoryManager.findInventoryStockItemByName(item.getName());
            stockItem.reduceStock(item);
        }
    }

    public void markCustomerOrderAsDelivered(CustomerOrder order){
        order.markAsDelivered();
    }

}
