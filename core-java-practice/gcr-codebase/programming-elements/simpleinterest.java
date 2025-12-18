import java.util.*;
public class Simpleinterest {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        double p=ob.nextDouble();
        double r=ob.nextDouble();
        double t=ob.nextDouble();
        System.out.println((p*r*t)/100);
    }
}
