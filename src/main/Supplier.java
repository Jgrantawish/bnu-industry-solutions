import java.util.ArrayList;

 /**
 * The Supplier Class holds details about a Supplier - a person who BNU Industry Solutions buys stock from.
 */
public class Supplier extends Contact{
    private ArrayList<Item> items = new ArrayList<>();
    

    public Supplier(String supplierName, String email, String phone, String address, String postcode){
        super(supplierName, email, phone, address, postcode);
    }

    /** Returns a comma separated list of items sold by the Supplier */
    private String itemsToString(){
        String itemsString = "";
        for (int i = 0; i < this.items.size(); i++){
            Item item = this.items.get(i);
            itemsString += item.getName();
            if (i < this.items.size() - 1) {
                itemsString += ", ";
            }
        }
        return itemsString;
    }

    /** Gets the item matching the specified name that is sold by this Supplier.
     * Returns null if no item with the specified name exists / is sold by this Supplier.
     */
    public Item findItemByName(String itemName){
        for (Item item: this.items){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    } 

    /** Adds an Item to the list of items sold by the Supplier */
    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getSupplierItems(){
        return this.items;
    }

    /** Removes an Item from the current list of items sold by the Supplier */
    public void deleteItem(Item item){
        this.items.remove(item);
    }

    /** Overrides toString method to give a summary of the Supplier's attributes */
    public String toString(){
        String itemsString = this.itemsToString();
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getPhoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode() + " -- Supplier of: " + itemsString;
    }

}

