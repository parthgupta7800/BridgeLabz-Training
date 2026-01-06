import java.util.*;
class BookNotAvailableException extends Exception{
    BookNotAvailableException(String message){
        super(message);
    }
}
class Book{
    String title;
    String author;
    boolean available;
    Book(String title,String author,boolean available){
        this.title=title;
        this.author=author;
        this.available=available;
    }
}
public class Library{
    static ArrayList<Book> books=new ArrayList<>();
    static void loadBooks(){
        Book[] bookArray={new Book("Java Programming","James Gosling",true),new Book("Data Structures","Mark Allen",true),new Book("Operating Systems","Andrew Tanenbaum",false),new Book("Clean Code","Robert Martin",true)};
        for(Book b:bookArray){
            books.add(b);
        }
    }
    static void displayBooks(){
        System.out.println("Available Books:");
        for(Book b:books){
            System.out.println(b.title+" | "+b.author+" | "+(b.available?"Available":"Checked Out"));
        }
    }
    static void searchByTitle(String keyword){
        boolean found=false;
        for(Book b:books){
            if(b.title.toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(b.title+" | "+b.author+" | "+(b.available?"Available":"Checked Out"));
                found=true;
            }
        }
        if(!found){
            System.out.println("No books found with title containing:"+keyword);
        }
    }
    static void checkoutBook(String title)throws BookNotAvailableException{
        for(Book b:books){
            if(b.title.equalsIgnoreCase(title)){
                if(!b.available){
                    throw new BookNotAvailableException("Book is already checked out");
                }
                b.available=false;
                System.out.println("Book checked out successfully:"+b.title);
                return;
            }
        }
        System.out.println("Book not found");
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        loadBooks();
        boolean loop=true;
        while(loop){
            System.out.println("1.Display Books");
            System.out.println("2.Search Book by Title");
            System.out.println("3.Checkout Book");
            System.out.println("4.Exit");
            System.out.print("Enter choice:");
            int choice=ob.nextInt();
            ob.nextLine();
            try{
                if(choice==1){
                    displayBooks();
                }else if(choice==2){
                    System.out.print("Enter partial title:");
                    searchByTitle(ob.nextLine());
                }else if(choice==3){
                    System.out.print("Enter full title to checkout:");
                    checkoutBook(ob.nextLine());
                }else if(choice==4){
                    loop=false;
                    System.out.println("Exiting Library System");
                }else{
                    System.out.println("Invalid choice");
                }
            }catch(BookNotAvailableException e){
                System.out.println("Error:"+e.getMessage());
            }
        }
    }
}
