import java.util.Scanner;

public class ComputeNaturalNumberFor {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        int sum2=0;
        if(number>0)
        {
            int sum1= number*(number+1)/2;
            for(int i=number;i>0;i--){
                sum2+=i;
            }
            if(sum1==sum2)System.out.println(sum1);
            else
                System.out.println("Sum from formula and sum from while is different");
        }
    }
}
