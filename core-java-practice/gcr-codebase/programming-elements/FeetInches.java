import java.util.*;
public class FeetInches {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
        double height=ob.nextDouble();
        double inche=height/2.54;
        double feet=inche/12;
        System.out.println("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inche);
    }
}
