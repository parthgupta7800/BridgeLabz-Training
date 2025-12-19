import java.util.*;
public class SumOfNNaturalNumber {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        if(number>0){
            int sum= number*(number+1)/2;
        System.out.println("The sum of "+ number+" natural numbers is "+sum); 
        }
        else
            System.out.println("The number "+number+" is not a natural number");

    }
}
