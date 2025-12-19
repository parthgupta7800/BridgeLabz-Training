import java.util.*;
public class AgeEligibleToVote {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int age=ob.nextInt();
        if(age>=18)
            System.out.println("The person's age is "+age+" and can vote.");
        else
            System.out.println("The person's age is "+age+" and cannot vote.");
    }
}
