import java.util.*;
public class SmallestAmongThree {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int number1=ob.nextInt();
        int number2=ob.nextInt();
        int number3=ob.nextInt();
        if(number1<number2&&number1<number3)
            System.out.println(" Is the first number the smallest? True");
        else
            System.out.println(" Is the first number the smallest? No");
    }
}
