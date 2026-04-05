 /**
 * The Customer Class holds details about a Customer - a person who buys products from BNU Industry Solutions.
 */
public class Customer extends Contact {    

    public Customer(String customerName, String email, String phone, String address, String postcode){
        super(customerName, email, phone, address, postcode);
    }

    /** Overrides toString method to give a summary of the Customer's attributes */
    public String toString(){
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getPhoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode();
    }
    
}
