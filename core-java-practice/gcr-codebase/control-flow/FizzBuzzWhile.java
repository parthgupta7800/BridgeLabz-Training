import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        if(number>0)
        {
            while(number>0){
                if(number%3==0&&number%5==0)System.out.println("FizzBuzz");
                if(number%3==0)System.out.println("Fizz");
                if(number%5==0)System.out.println("Buzz");
                number--;
            }
        }
    }
}
