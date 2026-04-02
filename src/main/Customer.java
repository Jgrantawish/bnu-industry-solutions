import java.util.ArrayList;

public class Customer extends Contact {
    private ArrayList<CustomerOrder> orderHistory = new ArrayList<>();;
    

    public Customer(String customerName, String email, String phone, String address, String postcode){
        super(customerName, email, phone, address, postcode);
    }

    public void updateOrderHistory(CustomerOrder order){
        this.orderHistory.add(order);
    }

    public ArrayList<CustomerOrder> getOrderHistory(){
        return this.orderHistory;

    }

    public String toString(){
        return this.getName()+ " -- " + this.getEmail() + " -- " + this.getPhoneNumber() + " -- " + this.getAddress() + ", " + this.getPostcode();
    }
    
}
