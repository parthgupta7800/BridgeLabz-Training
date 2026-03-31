import java.util.*;

class NoParkingSlotAvailableException extends Exception{
    public NoParkingSlotAvailableException(String message){
        super(message);
    }
}

abstract class Vehicle implements Comparable<Vehicle>{
    String number;
    Vehicle(String number){
        this.number=number;
    }
    @Override
    public int compareTo(Vehicle v){
        return this.number.compareTo(v.number);
    }
}

class Bike extends Vehicle{
    String bike_number;
    Bike(String bike_number){
        super(bike_number);
    }
}

class Car extends Vehicle{
    String car_number;
    Car(String car_number){
        super(car_number);
    }
}

class ParkingSlot{
    int slotId;
    Vehicle vehicle;
    boolean isFree=true;
    public ParkingSlot(int slotId) {
        this.slotId=slotId;
    }
}

class ParkingSystem{
    HashMap<Integer,ParkingSlot>slots=new HashMap<>();
    PriorityQueue<Vehicle> waiting=new PriorityQueue<>();
    ParkingSystem(int totalSlots){
        for(int i=1;i<=totalSlots;i++){
            slots.put(i,new ParkingSlot(i));
        }
    }
    void parkVehicle(Vehicle v)throws NoParkingSlotAvailableException{
        for(ParkingSlot s:slots.values()){
            if(s.isFree){
                s.isFree=false;
                s.vehicle=v;
                System.out.println("Slot allocated : "+s.slotId);
                return;
            }
        }
        waiting.add(v);
        throw new NoParkingSlotAvailableException("No Free Slot. Added to waiting queue");
    }
}

public class SmartVehicle {
    public static void main(String args[]){
        ParkingSystem system=new ParkingSystem(2);
        try {
            system.parkVehicle(new Car("UP32CJ1517"));
            system.parkVehicle(new Bike("UP32MZ4521"));
            system.parkVehicle(new Car("UP78MX1478"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
