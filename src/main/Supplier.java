import java.util.ArrayList;

public class Supplier extends Contact{
    private ArrayList<Item> items = new ArrayList<>();
    

    public Supplier(String supplierName, String email, String phone, String address, String postcode){
        super(supplierName, email, phone, address, postcode);
    }

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

    public Item findItemByName(String itemName){
        for (Item item: this.items){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    } 

    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getSupplierItems(){
        return this.items;
    }

    public void deleteItem(Item item){
        this.items.remove(item);
    }

    public String toString(){
        String itemsString = this.itemsToString();
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getPhoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode() + " -- Supplier of: " + itemsString;
    }

}

