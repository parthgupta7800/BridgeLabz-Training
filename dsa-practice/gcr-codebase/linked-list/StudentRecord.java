import java.util.*;
class StudentNode{
    String name;
    String grade;
    int rollNumber;
    int age;
    StudentNode next;
    public StudentNode(int rollNumber,String name,String grade,int age) {
        this.name=name;
        this.grade=grade;
        this.rollNumber=rollNumber;
        this.age=age;
        this.next=null;
    }
}
class StudentLinkedList{
    StudentNode head;
    void addBeginning(int rollNumber,String name,String grade,int age){
        StudentNode newNode=new StudentNode(rollNumber,name,grade,age);
        newNode.next=head;
        head=newNode;
    }
    void addEnd(int rollNumber,String name,String grade,int age){
        StudentNode newNode=new StudentNode(rollNumber,name,grade,age);
        if(head==null){
            head=newNode;
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addposition(int rollNumber,String name,String grade,int age,int pos){
        if(pos==1){
            addBeginning(rollNumber, name, grade, age);
            return;
        }
        StudentNode newNode=new StudentNode(rollNumber,name,grade,age);
        StudentNode temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid Position");
            return;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    void search(int rollNumber){
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==rollNumber){
                System.out.println("Record found");
                displayStudent(temp);
                return;
            }
            temp=temp.next;
        }
        System.out.println("No such record found");
    }
    void displayStudent(StudentNode temp){
        System.out.println("Name: "+temp.name);
        System.out.println("RollNumber: "+temp.rollNumber);
        System.out.println("Age: "+temp.age);
        System.out.println("Grade: "+temp.grade);
    }
    void delete(int rollNumber){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.rollNumber==rollNumber){
            System.out.println("Student record deleted");
            head=head.next;
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null&&temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Student not found");
            return;
        }
        else{
            temp.next=temp.next.next;
            System.out.println("Student record deleted");
        }
    }
    void upgradeGrade(int rollNumber,String newGrade){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==rollNumber){
                temp.grade=newGrade;
                System.out.println("Student grade upgraded");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Student not found");
    }
    void displayAll(){
        if(head==null){
            System.out.println("No records available");
            return;
        }
        StudentNode temp=head;
        while(temp!=null){
            displayStudent(temp);
            temp=temp.next;
        }
    }
}
public class StudentRecord {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Welcome to Student Record Management System");
        boolean loop=true;
        int rollNumber=0;
        StudentLinkedList list=new StudentLinkedList();
        while(loop){
            System.out.println("Enter 1 to add student");
            System.out.println("Enter 2 to search student");
            System.out.println("Enter 3 to delete to delete a student record");
            System.out.println("Enter 4 to upgrade grade of a student");
            System.out.println("Enter 5 to display student record");
            System.out.println("Enter 0 to exit");
            int choice=ob.nextInt();
            switch(choice){
                case 1:System.out.println("Enter 7 to add at the beginning");
                System.out.println("Enter 8 to add at the end");
                System.out.println("Enter 9 to add at specific position");
                int add=ob.nextInt();
                ob.nextLine();
                System.out.println("Enter the name of student");
                String name=ob.nextLine();
                System.out.println("Enter the roll number of student");
                rollNumber=ob.nextInt();
                ob.nextLine();
                System.out.println("Enter the age of student");
                int age=ob.nextInt();
                ob.nextLine();
                System.out.println("Enter the grade of student");
                String grade=ob.next();
                switch(add){
                    case 7:list.addBeginning(rollNumber, name, grade, age);
                    break;
                    case 8:list.addEnd(rollNumber, name, grade, age);
                    break;
                    case 9:System.out.println("Enter position to add this student");
                        int pos=ob.nextInt();
                        list.addposition(rollNumber, name, grade, age,pos);
                    break;
                    default:System.out.println("Enter the right choice");
                }
                break;
                case 2:System.out.println("Enter the roll number to be search");
                    int roll=ob.nextInt();
                    ob.nextLine();
                    list.search(roll);
                break;
                case 3:System.out.println("Enter the roll number to be deleted");
                    int rollDelete=ob.nextInt();
                    list.delete(rollDelete);
                break;
                case 4:System.out.println("Enter the roll number to be upgraded");
                    int rollUpgrade=ob.nextInt();
                    System.out.println("Enter the new grade");
                    String newGrade=ob.next();
                    list.upgradeGrade(rollUpgrade,newGrade);
                break;
                case 5:list.displayAll();
                break;
                case 0:loop=false;
                    System.out.println("Thank you !!");
                break;
                default:System.out.println("Invalid choice");
            }
        }
    }
}
