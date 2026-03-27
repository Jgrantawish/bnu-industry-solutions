import java.util.ArrayList;

public class ContactManager <T extends Contact>{
    private ArrayList<T> contacts = new ArrayList<>();; 
    
    public ContactManager(){
    }

    public void addContact(T contact){
        this.contacts.add(contact);
    }

    public ArrayList<T> getContacts(){
        return this.contacts;
    }

    public T findContactByEmail(String email){
        for (T contact : this.contacts){
            if (contact.getEmail().equals(email)){
                return contact;
            }
        }
        return null;
    } 

    public void deleteContact(T contact){
        this.contacts.remove(contact);
    }

}
