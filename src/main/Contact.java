public abstract class Contact {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String postcode; 
    

    public Contact(String name, String email, String phone, String address, String postcode){
        this.name = name;
        this.email = email;
        this.phoneNumber = phone; 
        this.address = address;
        this.postcode = postcode; 
    }

    public String getName(){
        return name;
    }


    public void update(){
        
    }


    public void viewOrderHistory(){

    }
}