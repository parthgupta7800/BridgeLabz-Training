import java.util.*;
class TextState{
    String content;
    TextState prev;
    TextState next;
    TextState(String content){
        this.content=content;
        this.prev=null;
        this.next=null;
    }
}
class UndoRedoManager{
    TextState head;
    TextState tail;
    TextState current;
    int size;
    final int MAX_SIZE=10;
    void addState(String content){
        TextState newNode=new TextState(content);
        if(current!=null&&current.next!=null){
            current.next.prev=null;
            current.next=null;
            tail=current;
        }
        if(head==null){
            head=tail=current=newNode;
            size=1;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        current=newNode;
        size++;
        if(size>MAX_SIZE){
            head=head.next;
            head.prev=null;
            size--;
        }
    }
    void undo(){
        if(current==null||current.prev==null){
            System.out.println("Nothing to undo");
            return;
        }
        current=current.prev;
        displayCurrent();
    }
    void redo(){
        if(current==null||current.next==null){
            System.out.println("Nothing to redo");
            return;
        }
        current=current.next;
        displayCurrent();
    }
    void displayCurrent(){
        if(current==null){
            System.out.println("Editor is empty");
            return;
        }
        System.out.println("Current Text: "+current.content);
    }
    void displayHistory(){
        TextState temp=head;
        System.out.println("History:");
        while(temp!=null){
            if(temp==current)
                System.out.println("-> "+temp.content);
            else
                System.out.println("   "+temp.content);
            temp=temp.next;
        }
    }
}
public class TextEditor{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        UndoRedoManager manager=new UndoRedoManager();
        boolean loop=true;
        while(loop){
            System.out.println("1.Type Text\n2.Undo\n3.Redo\n4.Show Current Text\n5.Show History\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter text");
                    String text=sc.nextLine();
                    manager.addState(text);
                    manager.displayCurrent();
                    break;
                case 2:
                    manager.undo();
                    break;
                case 3:
                    manager.redo();
                    break;
                case 4:
                    manager.displayCurrent();
                    break;
                case 5:
                    manager.displayHistory();
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
