import java.util.*;
class CircularBuffer {
    int[] buffer;
    int size;
    int front;
    int rear;
    int count;
    CircularBuffer(int size){
        this.size=size;
        buffer=new int[size];
        front=0;
        rear=0;
        count=0;
    }
    public void insert(int value){
        buffer[rear]=value;
        rear=(rear+1)%size;
        if(count<size){
            count++;
        }else{
            front=(front+1)%size;
        }
    }
    public void display(){
        if(count==0){
            System.out.println("Buffer is empty");
            return;
        }
        System.out.print("Buffer: [");
        for(int i=0;i<count;i++){
            int index=(front+i)%size;
            System.out.print(buffer[index]);
            if(i<count-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
public class Buffer{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int size=sc.nextInt();
        CircularBuffer buffer=new CircularBuffer(size);
        int choice=0;
        while(choice!=3){
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();
            if(choice==1){
                System.out.print("Enter value: ");
                int val=sc.nextInt();
                buffer.insert(val);
            }else if(choice==2){
                buffer.display();
            }
        }
    }
}
