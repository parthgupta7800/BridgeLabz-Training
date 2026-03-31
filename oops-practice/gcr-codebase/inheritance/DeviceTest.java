class Device{
    String deviceId;
    boolean status;
    Device(String deviceId,boolean status){
        this.deviceId=deviceId;
        this.status=status;
    }
}
class Thermostat extends Device{
    int temperatureSetting;
    Thermostat(String deviceId,boolean status,int temperatureSetting){
        super(deviceId,status);
        this.temperatureSetting=temperatureSetting;
    }
    void displayStatus(){
        System.out.println(deviceId+" "+status+" "+temperatureSetting);
    }
}
public class DeviceTest{
    public static void main(String[] args){
        Thermostat t=new Thermostat("TH101",true,24);
        t.displayStatus();
    }
}
