import java.util.*;
public class BonusSalary {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int salary=ob.nextInt();
        int year=ob.nextInt();
        if(year>5){
            double bonus=0.05*salary;
            System.out.println("Bonus amount is "+bonus);
        }
        else System.out.println("Less year of experience");
    }
}
