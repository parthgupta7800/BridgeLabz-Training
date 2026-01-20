package dao;
import java.util.*;
import model.Contact;
// Use Case 5: Store and manage multiple contacts
public class AddressBookDAO {
    private List<Contact> contacts=new ArrayList<>();
    // Use Case 2,5: Add contact
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    // Use Case 3: Edit contact
    public boolean editContact(String firstName,Contact updatedContact){
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getFirstName().equalsIgnoreCase(firstName)){
                contacts.set(i,updatedContact);
                return true;
            }
        }
        return false;
    }
    // Use Case 4: Delete contact
    public boolean deleteContact(String firstName){
        Iterator<Contact> iterator=contacts.iterator();
        while(iterator.hasNext()){
            Contact contact=iterator.next();
            if(contact.getFirstName().equalsIgnoreCase(firstName)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    // Use Case 5: Get all contacts
    public List<Contact> getAllContacts(){
        return contacts;
    }
}
