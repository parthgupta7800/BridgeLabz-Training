import java.util.*;
public class PositiveNegativeZero {
    public static void main(String arg[]){
        Scanner ob=new Scanner(System.in);
        PositiveNegativeZero obj=new PositiveNegativeZero();
        int number=ob.nextInt();
        obj.check(number);
    }
    void check(int number){
        if(number>0)System.out.println("Positive");
        else if(number<0)System.out.println("Negative");
        else System.out.println("Zero");
    }
}
