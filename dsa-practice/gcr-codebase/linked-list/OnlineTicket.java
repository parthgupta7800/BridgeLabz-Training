import java.util.*;
class TicketNode{
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;
    TicketNode(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        this.ticketId=ticketId;
        this.customerName=customerName;
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.bookingTime=bookingTime;
        this.next=null;
    }
}
class TicketCircularList{
    TicketNode head;
    void addTicket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        TicketNode newNode=new TicketNode(ticketId,customerName,movieName,seatNumber,bookingTime);
        if(head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        TicketNode temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
    }
    void removeTicket(int ticketId){
        if(head==null){
            System.out.println("No tickets booked");
            return;
        }
        TicketNode curr=head;
        TicketNode prev=null;
        do{
            if(curr.ticketId==ticketId){
                if(prev==null){
                    TicketNode last=head;
                    while(last.next!=head){
                        last=last.next;
                    }
                    if(head.next==head){
                        head=null;
                        System.out.println("Ticket removed");
                        return;
                    }
                    last.next=head.next;
                    head=head.next;
                }else{
                    prev.next=curr.next;
                }
                System.out.println("Ticket removed");
                return;
            }
            prev=curr;
            curr=curr.next;
        }while(curr!=head);
        System.out.println("Ticket not found");
    }
    void displayTickets(){
        if(head==null){
            System.out.println("No tickets booked");
            return;
        }
        TicketNode temp=head;
        do{
            displayTicket(temp);
            temp=temp.next;
        }while(temp!=head);
    }
    void searchTicket(String key){
        if(head==null){
            System.out.println("No tickets booked");
            return;
        }
        TicketNode temp=head;
        boolean found=false;
        do{
            if(temp.customerName.equalsIgnoreCase(key)||temp.movieName.equalsIgnoreCase(key)){
                displayTicket(temp);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found) System.out.println("No matching ticket found");
    }
    void countTickets(){
        if(head==null){
            System.out.println("Total Tickets:0");
            return;
        }
        int count=0;
        TicketNode temp=head;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Total Tickets:"+count);
    }
    void displayTicket(TicketNode t){
        System.out.println("Ticket ID:"+t.ticketId);
        System.out.println("Customer:"+t.customerName);
        System.out.println("Movie:"+t.movieName);
        System.out.println("Seat:"+t.seatNumber);
        System.out.println("Time:"+t.bookingTime);
        System.out.println("---------------");
    }
}
public class OnlineTicket{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        TicketCircularList list=new TicketCircularList();
        boolean loop=true;
        while(loop){
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Display Tickets\n4.Search Ticket\n5.Count Tickets\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter ticket id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter customer name");
                    String cname=sc.nextLine();
                    System.out.println("Enter movie name");
                    String mname=sc.nextLine();
                    System.out.println("Enter seat number");
                    String seat=sc.nextLine();
                    System.out.println("Enter booking time");
                    String time=sc.nextLine();
                    list.addTicket(id,cname,mname,seat,time);
                    break;
                case 2:
                    System.out.println("Enter ticket id to cancel");
                    list.removeTicket(sc.nextInt());
                    break;
                case 3:
                    list.displayTickets();
                    break;
                case 4:
                    System.out.println("Enter customer or movie name");
                    sc.nextLine();
                    list.searchTicket(sc.nextLine());
                    break;
                case 5:
                    list.countTickets();
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
