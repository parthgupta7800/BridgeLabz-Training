package presentation;
import service.AddressBookService;
import model.Contact;
import java.util.Scanner;
// Start: Display Welcome Message
public class AddressBookMain {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        AddressBookService service=new AddressBookService();
        System.out.println("Welcome to Address Book Program");
        while(true){
            System.out.println("\n1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.View All Contacts");
            System.out.println("5.Exit");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    // Use Case 2: Add new contact
                    System.out.print("First Name:");
                    String first=scanner.nextLine();
                    System.out.print("Last Name:");
                    String last=scanner.nextLine();
                    System.out.print("Address:");
                    String address=scanner.nextLine();
                    System.out.print("City:");
                    String city=scanner.nextLine();
                    System.out.print("State:");
                    String state=scanner.nextLine();
                    System.out.print("Zip:");
                    String zip=scanner.nextLine();
                    System.out.print("Phone:");
                    String phone=scanner.nextLine();
                    System.out.print("Email:");
                    String email=scanner.nextLine();
                    Contact contact=new Contact(first,last,address,city,state,zip,phone,email);
                    service.addContact(contact);
                    System.out.println("Contact Added Successfully");
                    break;
                case 2:
                    // Use Case 3: Edit existing contact
                    System.out.print("Enter First Name to Edit:");
                    String editName=scanner.nextLine();
                    System.out.print("New Last Name:");
                    String newLast=scanner.nextLine();
                    System.out.print("New Address:");
                    String newAddress=scanner.nextLine();
                    System.out.print("New City:");
                    String newCity=scanner.nextLine();
                    System.out.print("New State:");
                    String newState=scanner.nextLine();
                    System.out.print("New Zip:");
                    String newZip=scanner.nextLine();
                    System.out.print("New Phone:");
                    String newPhone=scanner.nextLine();
                    System.out.print("New Email:");
                    String newEmail=scanner.nextLine();
                    Contact updated=new Contact(editName,newLast,newAddress,newCity,newState,newZip,newPhone,newEmail);
                    if(service.editContact(editName,updated)){
                        System.out.println("Contact Updated Successfully");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 3:
                    // Use Case 4: Delete contact
                    System.out.print("Enter First Name to Delete:");
                    String deleteName=scanner.nextLine();
                    if(service.deleteContact(deleteName)){
                        System.out.println("Contact Deleted Successfully");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 4:
                    // Use Case 5: View all contacts
                    service.getAllContacts().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
