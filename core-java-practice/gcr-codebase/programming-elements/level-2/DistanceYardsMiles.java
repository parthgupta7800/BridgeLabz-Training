import java.util.*;
public class DistanceYardsMiles{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double feet=ob.nextDouble();
        double yard=feet/3;
        double miles=yard/1760;
        System.out.println("The distance in feet "+feet+" while in yards is "+yard+" and in miles is"+miles);
    }
}