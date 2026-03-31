import java.util.*;
class TaskNode{
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    TaskNode(int taskId,String taskName,int priority,String dueDate){
        this.taskId=taskId;
        this.taskName=taskName;
        this.priority=priority;
        this.dueDate=dueDate;
        this.next=null;
    }
}
class CircularTaskList{
    TaskNode head;
    TaskNode current;
    void addBeginning(int taskId,String taskName,int priority,String dueDate){
        TaskNode newNode=new TaskNode(taskId,taskName,priority,dueDate);
        if(head==null){
            head=newNode;
            newNode.next=head;
            current=head;
            return;
        }
        TaskNode temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        newNode.next=head;
        temp.next=newNode;
        head=newNode;
    }
    void addEnd(int taskId,String taskName,int priority,String dueDate){
        TaskNode newNode=new TaskNode(taskId,taskName,priority,dueDate);
        if(head==null){
            head=newNode;
            newNode.next=head;
            current=head;
            return;
        }
        TaskNode temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
    }
    void addAtPosition(int pos,int taskId,String taskName,int priority,String dueDate){
        if(pos==1){
            addBeginning(taskId,taskName,priority,dueDate);
            return;
        }
        TaskNode temp=head;
        for(int i=1;i<pos-1&&temp.next!=head;i++){
            temp=temp.next;
        }
        if(temp.next==head){
            addEnd(taskId,taskName,priority,dueDate);
            return;
        }
        TaskNode newNode=new TaskNode(taskId,taskName,priority,dueDate);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    void removeTask(int taskId){
        if(head==null){
            System.out.println("Task list is empty");
            return;
        }
        TaskNode temp=head;
        TaskNode prev=null;
        do{
            if(temp.taskId==taskId){
                if(prev==null){
                    TaskNode last=head;
                    while(last.next!=head){
                        last=last.next;
                    }
                    if(head.next==head){
                        head=null;
                        current=null;
                        return;
                    }
                    last.next=head.next;
                    head=head.next;
                    current=head;
                }else{
                    prev.next=temp.next;
                }
                System.out.println("Task removed");
                return;
            }
            prev=temp;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Task not found");
    }
    void viewNextTask(){
        if(current==null){
            System.out.println("No tasks available");
            return;
        }
        displayTask(current);
        current=current.next;
    }
    void displayAll(){
        if(head==null){
            System.out.println("No tasks available");
            return;
        }
        TaskNode temp=head;
        do{
            displayTask(temp);
            temp=temp.next;
        }while(temp!=head);
    }
    void searchByPriority(int priority){
        if(head==null){
            System.out.println("No tasks available");
            return;
        }
        TaskNode temp=head;
        boolean found=false;
        do{
            if(temp.priority==priority){
                displayTask(temp);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found) System.out.println("No task with this priority");
    }
    void displayTask(TaskNode t){
        System.out.println("Task ID:"+t.taskId);
        System.out.println("Task Name:"+t.taskName);
        System.out.println("Priority:"+t.priority);
        System.out.println("Due Date:"+t.dueDate);
        System.out.println("---------------------");
    }
}
public class TaskScheduler{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        CircularTaskList list=new CircularTaskList();
        boolean loop=true;
        while(loop){
            System.out.println("1.Add Task\n2.Remove Task\n3.View Next Task\n4.Display All Tasks\n5.Search by Priority\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter task id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter task name");
                    String name=sc.nextLine();
                    System.out.println("Enter priority");
                    int priority=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter due date");
                    String date=sc.nextLine();
                    System.out.println("1.Beginning 2.End 3.Position");
                    int posChoice=sc.nextInt();
                    if(posChoice==1) list.addBeginning(id,name,priority,date);
                    else if(posChoice==2) list.addEnd(id,name,priority,date);
                    else if(posChoice==3){
                        System.out.println("Enter position");
                        int pos=sc.nextInt();
                        list.addAtPosition(pos,id,name,priority,date);
                    }
                    break;
                case 2:
                    System.out.println("Enter task id to remove");
                    int rid=sc.nextInt();
                    list.removeTask(rid);
                    break;
                case 3:
                    list.viewNextTask();
                    break;
                case 4:
                    list.displayAll();
                    break;
                case 5:
                    System.out.println("Enter priority");
                    int p=sc.nextInt();
                    list.searchByPriority(p);
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
