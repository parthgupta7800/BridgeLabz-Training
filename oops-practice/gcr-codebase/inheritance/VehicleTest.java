class Vehicle{
    int maxSpeed;
    String fuelType;
    Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }
    void displayInfo(){
        System.out.println(maxSpeed+" "+fuelType);
    }
}
class Car extends Vehicle{
    int seatCapacity;
    Car(int maxSpeed,String fuelType,int seatCapacity){
        super(maxSpeed,fuelType);
        this.seatCapacity=seatCapacity;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Seats:"+seatCapacity);
    }
}
class Truck extends Vehicle{
    int loadCapacity;
    Truck(int maxSpeed,String fuelType,int loadCapacity){
        super(maxSpeed,fuelType);
        this.loadCapacity=loadCapacity;
    }
}
class Motorcycle extends Vehicle{
    boolean hasGear;
    Motorcycle(int maxSpeed,String fuelType,boolean hasGear){
        super(maxSpeed,fuelType);
        this.hasGear=hasGear;
    }
}
public class VehicleTest{
    public static void main(String[] args){
        Vehicle[] vehicles={new Car(180,"Petrol",5),new Truck(120,"Diesel",2000),new Motorcycle(150,"Petrol",true)};
        for(Vehicle v:vehicles){
            v.displayInfo();
        }
    }
}
