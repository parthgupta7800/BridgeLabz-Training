import java.util.*;
public class QuotientRemainder {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number1=ob.nextInt();
        int number2=ob.nextInt();
        int quo=number1/number2;
        int rem=number1%number2;
        System.out.println("The Quotient is "+quo+" and Reminder is "+rem+" of two number "+number1+" and "+number2);
    }
}
