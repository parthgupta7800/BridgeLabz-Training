import java.util.*;
public class UserEnterZero {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double sum=0.0;
        double value=ob.nextDouble();
        while(value!=0)
        {
            sum=sum+value;
            value=ob.nextDouble();
        }
        System.out.println(sum);
    }
}
