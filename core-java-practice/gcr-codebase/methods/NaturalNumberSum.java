import java.util.*;
public class NaturalNumberSum {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        NaturalNumberSum obj=new NaturalNumberSum();
        int number=ob.nextInt();
        obj.sum(number);
    }
    void sum(int number){
        int sum=0;
        for(int i=1;i<=number;i++)
            sum+=i;
        System.out.println(sum);
    }
}
