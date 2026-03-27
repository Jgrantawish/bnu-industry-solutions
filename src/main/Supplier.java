import java.util.ArrayList;

public class Supplier extends Contact{
    private ArrayList<SupplierOrder> orderHistory = new ArrayList<>();;
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

    public void addItem(Item item){
        this.items.add(item);
    }

    public void updateSupplierInfo(){
    ///
    }

    public void updateOrderHistory(SupplierOrder order){
        this.orderHistory.add(order);
    }

    public ArrayList<SupplierOrder> getOrderHistory(){
        return this.orderHistory;

    }

    public String toString(){
        String itemsString = itemsToString();
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getphoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode() + " -- Supplier of: " + itemsString;
    }



}

