import java.util.Scanner;

public class PrintFactorWhile {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        int i=0;
        while(i<number){
            if(number%i==0)
                System.out.println(i);
            i++;
        }
    }
}
