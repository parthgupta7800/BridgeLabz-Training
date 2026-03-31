import java.util.*;
public class SpringSeason {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        String month=ob.next();
        int day=ob.nextInt();
        if(month.equals("March")&&day>=20&&day<=31||month.equals("April")&&day>=1&&day<=30||month.equals("May")&&day>=1&&day<=31||month.equals("June")&&day>=1&&day<=20)
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}
