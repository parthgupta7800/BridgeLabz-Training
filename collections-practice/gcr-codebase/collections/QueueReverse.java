import java.util.*;
public class QueueReverse{
    public static void reverse(Queue<Integer> queue){
        if(queue.isEmpty()){
            return;
        }
        int front=queue.remove();
        reverse(queue);
        queue.add(front);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<Integer> queue=new LinkedList<>();
        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter element "+(i+1)+": ");
            queue.add(sc.nextInt());
        }
        reverse(queue);
        System.out.println("Reversed Queue: "+queue);
    }
}
