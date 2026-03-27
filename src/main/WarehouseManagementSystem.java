import java.util.ArrayList;

public class WarehouseManagementSystem {
    public ContactManager<Supplier> supplierManager = new ContactManager<Supplier>();
    // public CustomerManager customerManager = new CustomerManager();
    public InventoryManager inventoryManager = new InventoryManager();

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



}
