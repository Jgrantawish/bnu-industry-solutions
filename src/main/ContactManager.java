import java.util.ArrayList;

public abstract class ContactManager <T extends Contact>{
    private ArrayList<T> contacts; 
    
    public ContactManager(){
    }

    protected void addContact(T contact){
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

    public void deleteContactByEmail(String email){
        T contact = findContactByEmail(email);
        if (contact != null){
            this.contacts.remove(contact);
        }
    }

}
