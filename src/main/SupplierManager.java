import java.util.ArrayList;

public class SupplierManager extends ContactManager<Supplier>{

    public void addSupplier(String supplierName, String email, String phone, String address, String postcode){
        Supplier supplier = new Supplier(supplierName, email, phone, address, postcode);
        this.addContact(supplier);
    }

    public void updateSupplier(String supplierName, String email, String phone, String address, String postcode){
     ///////
    }
    
}
