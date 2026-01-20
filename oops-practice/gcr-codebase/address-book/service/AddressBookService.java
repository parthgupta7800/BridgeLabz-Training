package service;
import dao.AddressBookDAO;
import model.Contact;
import java.util.List;
// Business Logic Layer
public class AddressBookService {
    private AddressBookDAO dao=new AddressBookDAO();
    // Use Case 2,5
    public void addContact(Contact contact){
        dao.addContact(contact);
    }
    // Use Case 3
    public boolean editContact(String firstName,Contact updatedContact){
        return dao.editContact(firstName,updatedContact);
    }
    // Use Case 4
    public boolean deleteContact(String firstName){
        return dao.deleteContact(firstName);
    }
    // Use Case 5
    public List<Contact> getAllContacts(){
        return dao.getAllContacts();
    }
}
