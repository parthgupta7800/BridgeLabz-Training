import java.util.*;
class MovieNode{
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    MovieNode(String title,String director,int year,double rating){
        this.title=title;
        this.director=director;
        this.year=year;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
}
class MovieDoublyLinkedList{
    MovieNode head;
    MovieNode tail;
    void addBeginning(String title,String director,int year,double rating){
        MovieNode newNode=new MovieNode(title,director,year,rating);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    void addEnd(String title,String director,int year,double rating){
        MovieNode newNode=new MovieNode(title,director,year,rating);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    void addAtPosition(int pos,String title,String director,int year,double rating){
        if(pos==1){
            addBeginning(title,director,year,rating);
            return;
        }
        MovieNode temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid Position");
            return;
        }
        if(temp==tail){
            addEnd(title,director,year,rating);
            return;
        }
        MovieNode newNode=new MovieNode(title,director,year,rating);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next.prev=newNode;
        temp.next=newNode;
    }
    void removeByTitle(String title){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        MovieNode temp=head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                if(temp==head){
                    head=head.next;
                    if(head!=null) head.prev=null;
                }
                else if(temp==tail){
                    tail=tail.prev;
                    tail.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Movie removed");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie not found");
    }
    void searchByDirector(String director){
        MovieNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.director.equalsIgnoreCase(director)){
                displayMovie(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("No movie found for this director");
    }
    void searchByRating(double rating){
        MovieNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.rating==rating){
                displayMovie(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found) System.out.println("No movie found with this rating");
    }
    void updateRating(String title,double newRating){
        MovieNode temp=head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                temp.rating=newRating;
                System.out.println("Rating updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie not found");
    }
    void displayForward(){
        if(head==null){
            System.out.println("No movies available");
            return;
        }
        MovieNode temp=head;
        while(temp!=null){
            displayMovie(temp);
            temp=temp.next;
        }
    }
    void displayReverse(){
        if(tail==null){
            System.out.println("No movies available");
            return;
        }
        MovieNode temp=tail;
        while(temp!=null){
            displayMovie(temp);
            temp=temp.prev;
        }
    }
    void displayMovie(MovieNode m){
        System.out.println("Title:"+m.title);
        System.out.println("Director:"+m.director);
        System.out.println("Year:"+m.year);
        System.out.println("Rating:"+m.rating);
        System.out.println("-----------------");
    }
}
public class MovieSystem{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        MovieDoublyLinkedList list=new MovieDoublyLinkedList();
        boolean loop=true;
        while(loop){
            System.out.println("\n1.Add Movie\n2.Remove Movie\n3.Search by Director\n4.Search by Rating\n5.Update Rating\n6.Display Forward\n7.Display Reverse\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter title");
                    String title=sc.nextLine();
                    System.out.println("Enter director");
                    String director=sc.nextLine();
                    System.out.println("Enter year");
                    int year=sc.nextInt();
                    System.out.println("Enter rating");
                    double rating=sc.nextDouble();
                    System.out.println("1.Beginning 2.End 3.Position");
                    int posChoice=sc.nextInt();
                    if(posChoice==1) list.addBeginning(title,director,year,rating);
                    else if(posChoice==2) list.addEnd(title,director,year,rating);
                    else if(posChoice==3){
                        System.out.println("Enter position");
                        int pos=sc.nextInt();
                        list.addAtPosition(pos,title,director,year,rating);
                    }
                    break;
                case 2:
                    System.out.println("Enter movie title to remove");
                    String removeTitle=sc.nextLine();
                    list.removeByTitle(removeTitle);
                    break;
                case 3:
                    System.out.println("Enter director name");
                    String dir=sc.nextLine();
                    list.searchByDirector(dir);
                    break;
                case 4:
                    System.out.println("Enter rating");
                    double rate=sc.nextDouble();
                    list.searchByRating(rate);
                    break;
                case 5:
                    System.out.println("Enter movie title");
                    String t=sc.nextLine();
                    System.out.println("Enter new rating");
                    double newRate=sc.nextDouble();
                    list.updateRating(t,newRate);
                    break;
                case 6:
                    list.displayForward();
                    break;
                case 7:
                    list.displayReverse();
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
