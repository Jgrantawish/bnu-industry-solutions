public class Customer extends Contact {    

    public Customer(String customerName, String email, String phone, String address, String postcode){
        super(customerName, email, phone, address, postcode);
    }

    public String toString(){
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getPhoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode();
    }
    
}
