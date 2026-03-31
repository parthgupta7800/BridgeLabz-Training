import java.util.*;
public class NumberDivisiblityByFive{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        if(number%5==0)
            System.out.println("Is the number "+number+" divisible by 5? True");
        else
            System.out.println("Is the number "+number+" divisible by 5? False");
        
    }
}