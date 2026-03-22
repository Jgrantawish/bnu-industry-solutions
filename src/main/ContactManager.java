import java.util.ArrayList;

public class ContactManager{
    private ArrayList<Supplier> suppliers; 

    
    public ContactManager(){
    }

    public void addSupplier(String supplierName, String email, String phone, String address, String postcode){
        Supplier supplier = new Supplier(supplierName, email, phone, address, postcode);
        suppliers.add(supplier);
    }

    public ArrayList<Supplier> getSuppliers(){
        return suppliers;
    }

    public Supplier findSupplierByName(String name){
        for (Supplier supplier : suppliers){
            if (supplier.getName().equals(name)){
                return supplier;
            }
        }
        return null;
    } 

    public void deleteSupplierByName(String name){
        Supplier supplier = findSupplierByName(name);
        if (supplier != null){
            suppliers.remove(supplier);
        }
    }







}
