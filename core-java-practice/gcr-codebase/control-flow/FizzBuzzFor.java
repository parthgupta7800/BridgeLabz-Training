import java.util.*;
public class FizzBuzzFor {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        if(number>0)
        {
            for(int i=1;i<number;i++){
                if(i%3==0&&i%5==0)System.out.println("FizzBuzz");
                if(i%3==0)System.out.println("Fizz");
                if(i%5==0)System.out.println("Buzz");
            }
        }
    }
}
