import java.util.*;

class NoChargingSlotAvailableException extends RuntimeException{
    public NoChargingSlotAvailableException(String message){
        super(message);
    }
}

interface PricingStrategy{
    double calculateBill(double units);
}

class NormalPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units*5;
    }
}

class PeakPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units*8;
    }
}

class Vehicle{
    String vehicleNumber;
    Vehicle(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
    }
}

class ChargingSlot{
    int slotId;
    boolean occupied=false;

    ChargingSlot(int slotId){
        this.slotId=slotId;
    }
}

class EVChargingStation{

    Map<Integer,ChargingSlot>slots=new HashMap<>();
    Queue<Vehicle>waitingVehicles=new LinkedList<>();

    EVChargingStation(int totalSlots){
        for(int i=1;i<=totalSlots;i++){
            slots.put(i,new ChargingSlot(i));
        }
    }

    public void bookSlot(Vehicle v){
        for(ChargingSlot s:slots.values()){
            if(!s.occupied){
                s.occupied=true;
                System.out.println(v.vehicleNumber+" allocated Slot "+s.slotId);
                return;
            }
        }
        waitingVehicles.add(v);
        throw new NoChargingSlotAvailableException("No slot available. Added to waiting queue");
    }

    public void releaseSlot(int slotId){
        ChargingSlot s=slots.get(slotId);
        if(s!=null){
            s.occupied=false;
            System.out.println("Slot "+slotId+" released");

            if(!waitingVehicles.isEmpty()){
                Vehicle next=waitingVehicles.poll();
                bookSlot(next);
            }
        }
    }

    public void generateBill(double units,PricingStrategy strategy){
        double amount=strategy.calculateBill(units);
        System.out.println("Bill Amount:"+amount);
    }
}

public class EVChargingMain{
    public static void main(String[] args){

        EVChargingStation station=new EVChargingStation(2);

        Vehicle v1=new Vehicle("UP81AB1234");
        Vehicle v2=new Vehicle("UP81XY7890");
        Vehicle v3=new Vehicle("UP81ZZ5555");

        station.bookSlot(v1);
        station.bookSlot(v2);
        station.bookSlot(v3);

        PricingStrategy pricing=new PeakPricing();
        station.generateBill(20,pricing);

        station.releaseSlot(1);
    }
}