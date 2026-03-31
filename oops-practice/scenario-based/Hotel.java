import java.util.*;
class RoomNotAvailableException extends Exception{
    RoomNotAvailableException(String message){
        super(message);
    }
}
interface PricingStrategy{
    double calculatePrice(double basePrice,int days);
}
class NormalPricing implements PricingStrategy{
    public double calculatePrice(double basePrice,int days){
        return basePrice*days;
    }
}
class SeasonalPricing implements PricingStrategy{
    public double calculatePrice(double basePrice,int days){
        return basePrice*days*1.25;
    }
}
class Guest{
    String name;
    String phone;
    String address;
    Guest(String name,String phone,String address){
        this.name=name;
        this.phone=phone;
        this.address=address;
    }
}
class Rooms{
    int roomNumber;
    double basePrice;
    Guest guest;
    boolean checkedIn;
    PricingStrategy pricing;
    Rooms(int roomNumber,double basePrice,Guest guest,PricingStrategy pricing){
        this.roomNumber=roomNumber;
        this.basePrice=basePrice;
        this.guest=guest;
        this.pricing=pricing;
        this.checkedIn=false;
    }
    double calculateBill(int days){
        return pricing.calculatePrice(basePrice,days);
    }
}
class StandardRoom extends Rooms{
    StandardRoom(int roomNumber,Guest guest){
        super(roomNumber,1500.0,guest,new NormalPricing());
    }
}
class DeluxRoom extends Rooms{
    DeluxRoom(int roomNumber,Guest guest){
        super(roomNumber,2500.0,guest,new SeasonalPricing());
    }
}
class CheckIn{
    void performCheckIn(Rooms room){
        if(room.checkedIn){
            System.out.println("Already checked in");
            return;
        }
        room.checkedIn=true;
        System.out.println("Checked in to room number:"+room.roomNumber);
    }
}
class CheckOut{
    void performCheckOut(Rooms room,int days){
        if(!room.checkedIn){
            System.out.println("Room not checked in");
            return;
        }
        room.checkedIn=false;
        double bill=room.calculateBill(days);
        System.out.println("Checked out from room number:"+room.roomNumber);
        System.out.println("Total Bill:"+bill);
    }
}
public class Hotel{
    public static void main(String[] args){
        System.out.println("Welcome to the Hotel Management System");
        Scanner ob=new Scanner(System.in);
        ArrayList<Rooms> bookedRooms=new ArrayList<>();
        int deluxAvailable=2;
        int standardAvailable=2;
        int standardRoomNo=101;
        int deluxRoomNo=201;
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to Book Room");
            System.out.println("Enter 2 for check-in");
            System.out.println("Enter 3 for check-out");
            System.out.println("Enter 4 to generate invoice");
            System.out.println("Enter 0 to Exit");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter 1 for Standard Room for 1500rs/night");
                    System.out.println("Enter 2 for Delux Room for 2500rs/night");
                    int subChoice=ob.nextInt();
                    ob.nextLine();
                    System.out.println("Enter guest name:");
                    String name=ob.nextLine();
                    System.out.println("Enter phone number:");
                    String phone=ob.nextLine();
                    System.out.println("Enter address:");
                    String address=ob.nextLine();
                    Guest guest=new Guest(name,phone,address);
                    if(subChoice==1){
                        if(standardAvailable==0){
                            System.out.println("Standard Rooms not available");
                            break;
                        }
                        Rooms sr=new StandardRoom(standardRoomNo++,guest);
                        bookedRooms.add(sr);
                        standardAvailable--;
                        System.out.println("Standard Room booked.Room No:"+sr.roomNumber);
                    }
                    else if(subChoice==2){
                        if(deluxAvailable==0){
                            System.out.println("Delux Rooms not available");
                            break;
                        }
                        Rooms dr=new DeluxRoom(deluxRoomNo++,guest);
                        bookedRooms.add(dr);
                        deluxAvailable--;
                        System.out.println("Delux Room booked.Room No:"+dr.roomNumber);
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("Enter room number to check-in:");
                    int inRoom=ob.nextInt();
                    boolean foundIn=false;
                    for(Rooms r:bookedRooms){
                        if(r.roomNumber==inRoom){
                            new CheckIn().performCheckIn(r);
                            foundIn=true;
                            break;
                        }
                    }
                    if(!foundIn){
                        System.out.println("Room not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter room number to check-out:");
                    int outRoom=ob.nextInt();
                    System.out.println("Enter number of days stayed:");
                    int days=ob.nextInt();
                    boolean foundOut=false;
                    for(Rooms r:bookedRooms){
                        if(r.roomNumber==outRoom){
                            new CheckOut().performCheckOut(r,days);
                            foundOut=true;
                            break;
                        }
                    }
                    if(!foundOut){
                        System.out.println("Room not found");
                    }
                    break;
                case 4:
                    System.out.println("Booked Rooms:");
                    for(Rooms r:bookedRooms){
                        System.out.println("Room:"+r.roomNumber+" Guest:"+r.guest.name+" CheckedIn:"+r.checkedIn);
                    }
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
