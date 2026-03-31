import java.util.*;
public class SimpleInterestMethod {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double principal=ob.nextDouble();
        double rate=ob.nextDouble();
        double time=ob.nextDouble();
        SimpleInterestMethod obj=new SimpleInterestMethod();
        double Simple_Interest=obj.interest(principal,rate,time);
        System.out.println(Simple_Interest);
    }
    double interest(double principal,double rate,double time){
        double si=(principal*rate*time)/100;
        return si;
    }

}
