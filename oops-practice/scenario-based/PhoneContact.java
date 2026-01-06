import java.util.*;
class Contact{
    String name;
    String number;
}
class InvalidPhoneNumberException extends Exception{
    InvalidPhoneNumberException(String message){
        super(message);
    }
}
public class PhoneContact{
    static ArrayList<Contact> contact=new ArrayList<>();
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to add a number");
            System.out.println("Enter 2 to delete a number");
            System.out.println("Enter 3 to search a number");
            System.out.println("Enter 4 to display contacts");
            System.out.println("Enter 5 to exit");
            int choice=ob.nextInt();
            ob.nextLine();
            try{
                switch(choice){
                    case 1:
                        System.out.println("Enter the number to add");
                        String number=ob.nextLine();
                        System.out.println("Enter the name for this number");
                        String name=ob.nextLine();
                        addNumber(name,number);
                        break;
                    case 2:
                        System.out.println("Enter the number to be deleted");
                        deleteNumber(ob.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter the number to be searched");
                        searchNumber(ob.nextLine());
                        break;
                    case 4:
                        System.out.println("Displaying the contacts");
                        display();
                        break;
                    case 5:
                        System.out.println("You are now exited");
                        loop=false;
                        break;
                    default:
                        System.out.println("Invalid choice entered");
                }
            }catch(InvalidPhoneNumberException e){
                System.out.println("Error:"+e.getMessage());
            }
        }
    }
    public static void addNumber(String name,String number)throws InvalidPhoneNumberException{
        if(number.length()!=10){
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }
        for(Contact c:contact){
            if(c.number.equals(number)){
                System.out.println("Duplicate number not allowed");
                return;
            }
        }
        Contact c=new Contact();
        c.name=name;
        c.number=number;
        contact.add(c);
        System.out.println("Contact added successfully");
    }
    public static void deleteNumber(String delete){
        for(int i=0;i<contact.size();i++){
            if(contact.get(i).number.equals(delete)){
                contact.remove(i);
                System.out.println("Contact deleted successfully");
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public static void searchNumber(String search){
        for(Contact c:contact){
            if(c.number.equals(search)){
                System.out.println("Name:"+c.name);
                System.out.println("Number:"+c.number);
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public static void display(){
        if(contact.isEmpty()){
            System.out.println("No contacts available");
            return;
        }
        for(Contact c:contact){
            System.out.println(c.name+" - "+c.number);
        }
    }
}
