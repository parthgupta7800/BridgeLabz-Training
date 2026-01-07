import java.util.*;
import java.time.LocalTime;
class NoDriverAvailableException extends Exception{
    NoDriverAvailableException(String message){
        super(message);
    }
}
class Driver{
    String name;
    int id;
    boolean isAvailable;
    Driver(String name,int id,boolean isAvailable){
        this.name=name;
        this.id=id;
        this.isAvailable=isAvailable;
    }
}
class Rides{
    String userName;
    int userId;
    String driverName;
    int driverId;
    String source;
    String destination;
    double distance;
    String vehicleType;
    double fare;
    Rides(String name,int id,String driverName,int driverId,String source,String destination,double distance,String vehicleType,double fare){
        this.userName=name;
        this.userId=id;
        this.driverName=driverName;
        this.driverId=driverId;
        this.source=source;
        this.destination=destination;
        this.distance=distance;
        this.vehicleType=vehicleType;
        this.fare=fare;
    }
    void displayRide(){
        System.out.println("Customer:"+userName);
        System.out.println("User ID:"+userId);
        System.out.println("Source:"+source);
        System.out.println("Destination:"+destination);
        System.out.println("Distance:"+distance);
        System.out.println("Vehicle Type:"+vehicleType);
        System.out.println("Fare:"+fare);
        System.out.println("Driver Assigned:"+driverName);
        System.out.println("Driver ID:"+driverId);
        System.out.println("----------------------");
    }
}
class Users{
    String name;
    int id;

    Users(String name,int id){
        this.name=name;
        this.id=id;
    }
}
interface FareCalculator{
    double fareCalculator(String type,double distance);
}
class NormalFare implements FareCalculator{
    public double fareCalculator(String type,double distance){
        double amount=0.0;
        if(type.equalsIgnoreCase("bike"))
            amount=8;
        if(type.equalsIgnoreCase("sedan"))
            amount=15;
        if(type.equalsIgnoreCase("suv"))
            amount=20;
        return distance*amount;
    }
}
class PeakFare implements FareCalculator{
    public double fareCalculator(String type,double distance){
        double amount=0.0;
        if(type.equalsIgnoreCase("bike"))
            amount=10;
        if(type.equalsIgnoreCase("sedan"))
            amount=20;
        if(type.equalsIgnoreCase("suv"))
            amount=30;
        return distance*amount;
    }
}
public class CabBooking{
    static ArrayList<Driver>drivers=new ArrayList<>();
    static ArrayList<Users>users=new ArrayList<>();
    static ArrayList<Rides>rides=new ArrayList<>();
    public static Driver assign()throws NoDriverAvailableException{
        for(Driver d:drivers){
            if(d.isAvailable){
                d.isAvailable=false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver available");
    }
    static boolean isPeakTime(){
        LocalTime now=LocalTime.now();
        LocalTime mStart=LocalTime.of(7,0);
        LocalTime mEnd=LocalTime.of(9,0);
        LocalTime eStart=LocalTime.of(17,0);
        LocalTime eEnd=LocalTime.of(20,0);
        return (now.isAfter(mStart)&&now.isBefore(mEnd)) ||(now.isAfter(eStart)&&now.isBefore(eEnd));
    }
    public static void showRideHistory(){
        if(rides.size()==0){
            System.out.println("No ride history available");
        }
        for(Rides r:rides){
            r.displayRide();
        }
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        drivers.add(new Driver("Amit",123,true));
        drivers.add(new Driver("Anmol",453,true));
        drivers.add(new Driver("Vaibhav",963,true));
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to book ride");
            System.out.println("Enter 2 to view ride history");
            System.out.println("Enter 0 to exit");
            int num=ob.nextInt();
            ob.nextLine();
            if(num==1){
                System.out.println("Enter the user name");
                String name=ob.nextLine();
                System.out.println("Enter the user Id");
                int id=ob.nextInt();
                ob.nextLine();
                System.out.println("Enter the source point");
                String source=ob.nextLine();
                System.out.println("Enter the destination");
                String destination=ob.nextLine();
                System.out.println("Enter the distance");
                double distance=ob.nextDouble();
                ob.nextLine();
                System.out.println("Enter vehicle type(bike/sedan/suv)");
                String vehicleType=ob.nextLine();
                users.add(new Users(name,id));
                try{
                    Driver driver=assign();
                    FareCalculator fareCalc;
                    if(isPeakTime())
                        fareCalc=new PeakFare();
                    else
                        fareCalc=new NormalFare();
                    double fare=fareCalc.fareCalculator(vehicleType,distance);
                    Rides ride=new Rides(name,id,driver.name,driver.id,source,destination,distance,vehicleType,fare);
                    rides.add(ride);
                    ride.displayRide();
                }catch(NoDriverAvailableException e){
                    System.out.println(e.getMessage());
                }
            }else if(num==2){
                showRideHistory();
            }else{
                loop=false;
            }
        }
        System.out.println("Thanks for choosing our services !!");
    }
}
