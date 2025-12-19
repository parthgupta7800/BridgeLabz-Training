import java.util.*;
public class LargestAmongThree {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int number1=ob.nextInt();
        int number2=ob.nextInt();
        int number3=ob.nextInt();
        if(number1>number2 && number1>number3)
        {
            System.out.println("Is the first number the largest? Yes");
            System.out.println("Is the second number the largest? No");
            System.out.println("Is the third number the largest? No");
        }
        if(number2>number1 && number2>number3)
        {
            System.out.println("Is the first number the largest? No");
            System.out.println("Is the second number the largest? Yes");
            System.out.println("Is the third number the largest? No");
        }
        else{
            System.out.println("Is the first number the largest? No");
            System.out.println("Is the second number the largest? No");
            System.out.println("Is the third number the largest? Yes");
        }
    }
}
