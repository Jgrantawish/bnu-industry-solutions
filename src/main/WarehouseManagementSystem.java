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
