import java.util.*;
public class OddEvenCompare {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
        int arr[]=new int[5];
        for(int i=0;i<5;i++){
            System.out.println("Enter the number");
            arr[i]=ob.nextInt();
        }
        for(int i=0;i<5;i++){
            if(arr[i]<0)System.out.println("Negative");
            else{
                if(arr[i]%2==0)System.out.println("Even");
                else System.out.println("Odd");
            }
        }
        if(arr[0]>arr[4])System.out.println("First element is greater than last");
        if(arr[0]<arr[4])System.out.println("First element is less than last element");
        else
            System.out.println("First element is equal to last element");
    }    
}
