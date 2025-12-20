import java.util.*;
public class VotingElegibility {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int arr[]=new int[10];
        for(int i=0;i<10;i++)
        {
            System.out.println("Enter the age");
            arr[i]=ob.nextInt();
        }
        for(int i=0;i<10;i++)
        {
            if(arr[i]<0)System.out.println("Invalid age");
            if(arr[i]>=0&arr[i]<18)System.out.println("The student with the age "+arr[i]+" can vote");
            else
                System.out.println("The student with the age "+arr[i]+" cannot vote");
        }
    }    
}
