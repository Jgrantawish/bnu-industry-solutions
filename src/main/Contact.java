import java.util.ArrayList;

public abstract class Contact {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String postcode;
    private ArrayList<Order> orderHistory = new ArrayList<>();;
    

    public Contact(String name, String email, String phone, String address, String postcode){
        this.name = name;
        this.email = email;
        this.phoneNumber = phone; 
        this.address = address;
        this.postcode = postcode; 
    }

    protected void updateOrderHistory(Order order){
        this.orderHistory.add(order);
    }

    public String getEmail(){
        return email;
    }


    public void update(){
        
    }

    public void viewOrderHistory(){

    }
}