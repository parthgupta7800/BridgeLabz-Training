import java.util.*;
public class ComputeNaturalNumberWhile {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        int sum2=0;
        if(number>0)
        {
            int sum1= number*(number+1)/2;
            while(number>0){
                sum2+=number;
                number--;
            }
            if(sum1==sum2)System.out.println(sum1);
            else
                System.out.println("Sum from formula and sum from while is different");
        }
    }
}
