public class EarthVolume {
    public static void main(String args[]){
        int r=6378;
        double volkm=(4/3)*3.14*r*r*r;
        double volmiles=volkm*1.6;
        System.out.println("The volume of earth in cubic kilometers is "+volkm+" and cubic miles is "+volmiles);
    }
}
