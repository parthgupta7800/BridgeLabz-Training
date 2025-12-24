import java.util.*;
public class SpringSeasonMethod {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        SpringSeasonMethod obj=new SpringSeasonMethod();
        String month=ob.next();
        int day=ob.nextInt();
        obj.season(month,day);
    }
    void season(String month,int day){
         if(month.equals("March")&&day>=20&&day<=31||month.equals("April")&&day>=1&&day<=30||month.equals("May")&&day>=1&&day<=31||month.equals("June")&&day>=1&&day<=20)
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}
