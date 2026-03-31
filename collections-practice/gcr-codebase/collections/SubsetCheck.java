import java.util.*;
public class SubsetCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        System.out.print("Enter number of elements in Set1: ");
        int n1=sc.nextInt();
        for(int i=0;i<n1;i++){
            System.out.print("Enter element "+(i+1)+": ");
            set1.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in Set2: ");
        int n2=sc.nextInt();
        for(int i=0;i<n2;i++){
            System.out.print("Enter element "+(i+1)+": ");
            set2.add(sc.nextInt());
        }
        if(set2.containsAll(set1)){
            System.out.println("Set1 is a Subset of Set2: true");
        }else{
            System.out.println("Set1 is a Subset of Set2: false");
        }
    }
}
