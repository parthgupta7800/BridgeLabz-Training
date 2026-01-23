import java.util.*;
public class BinaryQueue {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<String> queue=new LinkedList<>();
        System.out.print("Enter N: ");
        int n=sc.nextInt();
        queue.add("1");
        System.out.println("First "+n+" Binary Numbers:");
        for(int i=0;i<n;i++){
            String current=queue.remove();
            System.out.println(current);
            queue.add(current+"0");
            queue.add(current+"1");
        }
    }
}
