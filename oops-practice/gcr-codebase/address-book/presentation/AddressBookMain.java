package presentation;
import service.AddressBookService;
import model.Contact;
import java.util.Scanner;

// Use Case Start: Display Welcome Message
public class AddressBookMain {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        AddressBookService service=new AddressBookService();
        System.out.println("Welcome to Address Book Program");
        while(true){
            System.out.println("1.Create Address Book");
            System.out.println("2.Add Contact");
            System.out.println("3.Edit Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Search By City");
            System.out.println("6.Search By State");
            System.out.println("7.Count By City");
            System.out.println("8.Count By State");
            System.out.println("9.Exit");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Address Book Name:");
                    String bookName=scanner.nextLine();
                    service.createAddressBook(bookName);
                    System.out.println("Address Book Created");
                    break;
                case 2:
                    System.out.print("Enter Book Name:");
                    String addBook=scanner.nextLine();
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
                    if(service.addContact(addBook,contact)){
                        System.out.println("Contact Added Successfully");
                    }else{
                        System.out.println("Duplicate Contact Found");
                    }
                    break;
                case 3:
                    System.out.print("Book Name:");
                    String editBook=scanner.nextLine();
                    System.out.print("First Name to Edit:");
                    String editName=scanner.nextLine();
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
                    Contact updated=new Contact(editName,"",newAddress,newCity,newState,newZip,newPhone,newEmail);
                    if(service.editContact(editBook,editName,updated)){
                        System.out.println("Contact Updated");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 4:
                    System.out.print("Book Name:");
                    String deleteBook=scanner.nextLine();
                    System.out.print("First Name to Delete:");
                    String deleteName=scanner.nextLine();
                    if(service.deleteContact(deleteBook,deleteName)){
                        System.out.println("Contact Deleted");
                    }else{
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 5:
                    System.out.print("Enter City:");
                    String searchCity=scanner.nextLine();
                    service.searchByCity(searchCity).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter State:");
                    String searchState=scanner.nextLine();
                    service.searchByState(searchState).forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("Enter City:");
                    String countCity=scanner.nextLine();
                    System.out.println("Total:"+service.countByCity(countCity));
                    break;
                case 8:
                    System.out.print("Enter State:");
                    String countState=scanner.nextLine();
                    System.out.println("Total:"+service.countByState(countState));
                    break;
                case 9:
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
