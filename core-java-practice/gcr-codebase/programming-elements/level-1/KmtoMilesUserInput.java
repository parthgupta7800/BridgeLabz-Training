import java.util.*;
public class KmtoMilesUserInput {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int km=ob.nextInt();
        double miles=km*1.6;
        System.out.println("The total miles is "+miles+" for the given "+km+" km");
    }
}
