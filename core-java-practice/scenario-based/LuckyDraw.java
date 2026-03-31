import java.util.*;
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Welcome to Lucky Draw!!");
        System.out.println("Enter -1 to exit");
        boolean flag=true;
        while(flag){
            System.out.println("Enter the number");
            int number=ob.nextInt();
            if(number%3==0 && number%5==0)
                System.out.println("Congratulation !! You won a gift");
            else if(number==-1)flag=false;
            else System.out.println("Better Luck next time");
        }
    }
}
