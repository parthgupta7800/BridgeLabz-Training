import java.util.*;
public class TraingularPark {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        TraingularPark obj=new TraingularPark();
        System.out.println("Enter the sides of the triangle");
        int side1=ob.nextInt();
        int side2=ob.nextInt();
        int side3=ob.nextInt();
        double no_of_rounds=obj.rounds(side1,side2,side3);
        System.out.println(no_of_rounds);
    }
    double rounds(int side1,int side2,int side3){
        double distance=(side1+side2+side3)/1000;
        double rounds=distance/5;
        return rounds;
    }
}
