import java.util.*;
public class UserEnterZeroBreak {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double sum=0.0;
        while(true){
            double value=ob.nextDouble();
            if(value>0.0)
                sum=sum+value;
            else
                break;
        }
        System.out.println(sum);
    }
}
