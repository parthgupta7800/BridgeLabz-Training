import java.util.*;
public class QuotientRemainder {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        QuotientRemainder obj=new QuotientRemainder();
        System.out.println("Enter the two numbers");
        int number=ob.nextInt();
        int divisor=ob.nextInt();
        System.out.println(obj.findRemainderAndQuotient(number,divisor));
        
    }
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int quo=number/divisor;
        int rem=number%divisor;
        int arr[]={quo,rem};
        return arr;
    }
}
