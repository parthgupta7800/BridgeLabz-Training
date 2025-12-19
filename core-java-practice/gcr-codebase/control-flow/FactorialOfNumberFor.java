import java.util.Scanner;

public class FactorialOfNumberFor {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        int fact=1;
        if(n>0){
            for(int i=n;i>0;i--){
                fact*=i;
            }
            System.out.println("Factorial is "+fact);
        }
        else
            System.out.println("Value entered is negative");
    }
}
