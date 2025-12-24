import java.util.*;
public class SmallestLargest {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        SmallestLargest obj=new SmallestLargest();
        System.out.println("Enter the three numbers");
        int num1=ob.nextInt();
        int num2=ob.nextInt();
        int num3=ob.nextInt();
        obj.find(num1,num2,num3);
    }
    void find(int num1,int num2,int num3){
        if(num1>num2 && num1>num3)
        {
            System.out.println("Is the first num the largest? Yes");
            System.out.println("Is the second num the largest? No");
            System.out.println("Is the third num the largest? No");
        }
        if(num2>num1 && num2>num3)
        {
            System.out.println("Is the first num the largest? No");
            System.out.println("Is the second num the largest? Yes");
            System.out.println("Is the third num the largest? No");
        }
        else{
            System.out.println("Is the first num the largest? No");
            System.out.println("Is the second num the largest? No");
            System.out.println("Is the third num the largest? Yes");
        }
    }
}
