import java.util.*;
public class VolumeOfCylinder {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double h=ob.nextDouble();
        double r=ob.nextDouble();
        double vol=3.14*r*r*h;
        System.out.println(vol);
    }
}
