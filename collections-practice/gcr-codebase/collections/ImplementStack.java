import java.util.*;
class StackUsingQueues {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    public void push(int x){
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }
    public int pop(){
        if(q1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }
    public int top(){
        if(q1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }
}
public class ImplementStack {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StackUsingQueues stack=new StackUsingQueues();
        int choice=0;
        while(choice!=4){
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();
            if(choice==1){
                System.out.print("Enter value: ");
                int val=sc.nextInt();
                stack.push(val);
            }else if(choice==2){
                System.out.println("Popped: "+stack.pop());
            }else if(choice==3){
                System.out.println("Top: "+stack.top());
            }
        }
    }
}
