import java.util.ArrayList;

public class WarehouseManagementSystem {
    public ContactManager<Supplier> supplierManager = new ContactManager<Supplier>();
    public ContactManager<Customer> customerManager = new ContactManager<Customer>();
    public InventoryManager inventoryManager = new InventoryManager();
    public OrderManager<SupplierOrder> supplierOrderManager = new OrderManager<SupplierOrder>();
    public OrderManager<CustomerOrder> customerOrderManager = new OrderManager<CustomerOrder>();


    public WarehouseManagementSystem(){


    }

    private ArrayList<Item> getAllSupplierItems(){
        ArrayList<Item> allSupplierItems = new ArrayList<Item>();
        for (Supplier supplier : this.supplierManager.getContacts()){
            ArrayList<Item> supplierItems = supplier.getSupplierItems();
            for (Item item : supplierItems){
                allSupplierItems.add(item);
            }
        }
        return allSupplierItems;
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

    public void placeCustomerOrder(){
        

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



}
