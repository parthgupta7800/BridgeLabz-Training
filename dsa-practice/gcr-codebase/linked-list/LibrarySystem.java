import java.util.*;
class BookNode{
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    BookNode(int bookId,String title,String author,String genre,boolean isAvailable){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.isAvailable=isAvailable;
        this.next=null;
        this.prev=null;
    }
}
class LibraryDoublyLinkedList{
    BookNode head;
    BookNode tail;
    void addBeginning(int bookId,String title,String author,String genre,boolean isAvailable){
        BookNode newNode=new BookNode(bookId,title,author,genre,isAvailable);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    void addEnd(int bookId,String title,String author,String genre,boolean isAvailable){
        BookNode newNode=new BookNode(bookId,title,author,genre,isAvailable);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    void addAtPosition(int pos,int bookId,String title,String author,String genre,boolean isAvailable){
        if(pos==1){
            addBeginning(bookId,title,author,genre,isAvailable);
            return;
        }
        BookNode temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid position");
            return;
        }
        if(temp==tail){
            addEnd(bookId,title,author,genre,isAvailable);
            return;
        }
        BookNode newNode=new BookNode(bookId,title,author,genre,isAvailable);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next.prev=newNode;
        temp.next=newNode;
    }
    void removeById(int bookId){
        if(head==null){
            System.out.println("Library is empty");
            return;
        }
        BookNode temp=head;
        while(temp!=null){
            if(temp.bookId==bookId){
                if(temp==head){
                    head=head.next;
                    if(head!=null) head.prev=null;
                    else tail=null;
                }
                else if(temp==tail){
                    tail=tail.prev;
                    tail.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Book removed");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Book not found");
    }
    void searchByTitle(String title){
        BookNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                displayBook(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Book not found");
    }
    void searchByAuthor(String author){
        BookNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.author.equalsIgnoreCase(author)){
                displayBook(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("Book not found");
    }
    void updateAvailability(int bookId,boolean status){
        BookNode temp=head;
        while(temp!=null){
            if(temp.bookId==bookId){
                temp.isAvailable=status;
                System.out.println("Availability updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Book not found");
    }
    void displayForward(){
        if(head==null){
            System.out.println("No books available");
            return;
        }
        BookNode temp=head;
        while(temp!=null){
            displayBook(temp);
            temp=temp.next;
        }
    }
    void displayReverse(){
        if(tail==null){
            System.out.println("No books available");
            return;
        }
        BookNode temp=tail;
        while(temp!=null){
            displayBook(temp);
            temp=temp.prev;
        }
    }
    void countBooks(){
        int count=0;
        BookNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("Total books:"+count);
    }
    void displayBook(BookNode b){
        System.out.println("Book ID:"+b.bookId);
        System.out.println("Title:"+b.title);
        System.out.println("Author:"+b.author);
        System.out.println("Genre:"+b.genre);
        System.out.println("Available:"+b.isAvailable);
        System.out.println("--------------");
    }
}
public class LibrarySystem{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        LibraryDoublyLinkedList library=new LibraryDoublyLinkedList();
        boolean loop=true;
        while(loop){
            System.out.println("1.Add Book\n2.Remove Book\n3.Search by Title\n4.Search by Author\n5.Update Availability\n6.Display Forward\n7.Display Reverse\n8.Count Books\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter book id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter title");
                    String title=sc.nextLine();
                    System.out.println("Enter author");
                    String author=sc.nextLine();
                    System.out.println("Enter genre");
                    String genre=sc.nextLine();
                    System.out.println("Available(true/false)");
                    boolean avail=sc.nextBoolean();
                    System.out.println("1.Beginning 2.End 3.Position");
                    int posChoice=sc.nextInt();
                    if(posChoice==1) library.addBeginning(id,title,author,genre,avail);
                    else if(posChoice==2) library.addEnd(id,title,author,genre,avail);
                    else if(posChoice==3){
                        System.out.println("Enter position");
                        int pos=sc.nextInt();
                        library.addAtPosition(pos,id,title,author,genre,avail);
                    }
                    break;
                case 2:
                    System.out.println("Enter book id");
                    library.removeById(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter title");
                    sc.nextLine();
                    library.searchByTitle(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Enter author");
                    sc.nextLine();
                    library.searchByAuthor(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Enter book id");
                    int bid=sc.nextInt();
                    System.out.println("Enter availability(true/false)");
                    boolean st=sc.nextBoolean();
                    library.updateAvailability(bid,st);
                    break;
                case 6:
                    library.displayForward();
                    break;
                case 7:
                    library.displayReverse();
                    break;
                case 8:
                    library.countBooks();
                    break;
                case 0:
                    loop=false;
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
