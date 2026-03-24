import java.util.ArrayList;

public class Supplier extends Contact{
    private ArrayList<Item> items = new ArrayList<>();;
    

    public Supplier(String supplierName, String email, String phone, String address, String postcode){
        super(supplierName, email, phone, address, postcode);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void updateSupplierInfo(){
    ///
    }

}

