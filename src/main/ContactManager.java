import java.util.ArrayList;

 /**
 * The ContactManager Class is responsible for maintaining a list of Contacts (either Customers or Suppliers).
 * It also provides the method to find a given Contact.
 */
public class ContactManager <T extends Contact>{
    private ArrayList<T> contacts = new ArrayList<>();
    
    public ContactManager(){
    }

    /** Adds either a Customer or Supplier object to the list of current Contacts */
    public void addContact(T contact){
        this.contacts.add(contact);
    }

    public ArrayList<T> getContacts(){
        return this.contacts;
    }

    /** Iterates through the list of Contacts and returns the Contact object that matches the specified email. 
     * Returns null if no Contact with the specified email address exists.
     * */
    public T findContactByEmail(String email){
        for (T contact : this.contacts){
            if (contact.getEmail().equals(email)){
                return contact;
            }
        }
        return null;
    } 

    /** Removes the specified Contact from the list of current Contacts */
    public void deleteContact(T contact){
        this.contacts.remove(contact);
    }

}
