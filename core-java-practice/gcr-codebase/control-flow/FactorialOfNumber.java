import java.util.*;
public class FactorialOfNumber {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        int fact=1;
        if(n>0){
            while(n>0){
                fact*=n;
                n--;
            }
            System.out.println("Factorial is "+fact);
        }
        else
            System.out.println("Value entered is negative");
    }
}
