import java.util.*;
public class AreaTriangle {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        double base=ob.nextDouble();
        double height=ob.nextDouble();
        double area=0.5*base*height;
        double inche=area/12;
        System.out.println("Your Height in cm is "+(area)+" while in feet is "+(inche/12)+" and inches is "+inche);
    }
}
