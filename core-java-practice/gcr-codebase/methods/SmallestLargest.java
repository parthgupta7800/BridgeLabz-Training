import java.util.*;
public class SmallestLargest {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        SmallestLargest obj=new SmallestLargest();
        System.out.println("Enter the three numbers");
        int num1=ob.nextInt();
        int num2=ob.nextInt();
        int num3=ob.nextInt();
        System.out.println(obj.findSmallestAndLargest(num1,num2,num3));
    }
    public static int[] findSmallestAndLargest(int num1,int num2,int num3){
        int largest=0;
        int smallest=0;
        if(num1>num2)
        {
            if(num1>num3)
                largest=num1;
            else largest=num3;
        }
        else largest=num2;
        if(num1<num2)
        {
            if(num1<num3)
                smallest=num1;
            else smallest=num3;
        }
        else smallest=num2;
        int arr[]={largest,smallest};
        return arr;
    }
}
