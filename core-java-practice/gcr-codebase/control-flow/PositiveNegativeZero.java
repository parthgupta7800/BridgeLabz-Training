import java.util.*;
public class PositiveNegativeZero {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        if(number>0)System.out.println("Positive");
        if(number<0)System.out.println("Negative");
        else System.out.println("Zero");
    }
}
