import java.util.ArrayList;

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
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPostcode(){
        return this.postcode;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhone){
        this.phoneNumber = newPhone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPostcode(String postcode){
        this.postcode = postcode;
    }

    

}