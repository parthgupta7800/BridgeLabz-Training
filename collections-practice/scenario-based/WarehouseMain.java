import java.util.*;

class SensorFailureException extends RuntimeException{
    public SensorFailureException(String msg){
        super(msg);
    }
}

class TemperatureLog{
    List<Double>readings=new ArrayList<>();

    public void addReading(double temp){
        if(temp==-999){
            throw new SensorFailureException("Sensor failure");
        }
        readings.add(temp);
    }

    public double calculateAverage(){
        double sum=0;
        for(double t:readings){
            sum+=t;
        }
        return readings.size()==0?0:sum/readings.size();
    }

    public void checkAlert(double safeMax){
        for(double t:readings){
            if(t>safeMax){
                System.out.println("Alert! Temperature exceeded: "+t);
            }
        }
    }
}

class WarehouseMonitor{
    Map<Integer,TemperatureLog>rooms=new HashMap<>();

    public void addRoom(int id){
        rooms.put(id,new TemperatureLog());
    }
}

public class WarehouseMain{
    public static void main(String[] args){

        WarehouseMonitor monitor=new WarehouseMonitor();
        monitor.addRoom(101);

        TemperatureLog log=monitor.rooms.get(101);

        log.addReading(4.5);
        log.addReading(5.2);
        log.addReading(9.0);

        System.out.println("Average:"+log.calculateAverage());
        log.checkAlert(8.0);
    }
}