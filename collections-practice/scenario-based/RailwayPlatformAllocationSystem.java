import java.util.*;

class PlatformUnavailableException extends Exception{
    public PlatformUnavailableException(String message){
        super(message);
    }
}

class Train implements Comparable<Train>{
    private String name;
    private int arrivalTime;

    public Train(String name,int arrivalTime){
        this.name=name;
        this.arrivalTime=arrivalTime;
    }

    public String getName(){
        return name;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    @Override
    public int compareTo(Train other){
        return this.arrivalTime-other.arrivalTime;
    }
}

class Platform{
    private int number;
    private boolean occupied;

    public Platform(int number){
        this.number=number;
        this.occupied=false;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public void occupy(){
        occupied=true;
    }

    public int getNumber(){
        return number;
    }
}

public class RailwayPlatformAllocationSystem{

    private Map<Integer,Platform> platforms=new HashMap<>();
    private PriorityQueue<Train> trains=new PriorityQueue<>();

    public RailwayPlatformAllocationSystem(int totalPlatforms){
        for(int i=1;i<=totalPlatforms;i++){
            platforms.put(i,new Platform(i));
        }
    }

    public void addTrain(Train train){
        trains.offer(train);
    }

    public void allocate()throws PlatformUnavailableException{
        while(!trains.isEmpty()){
            Train train=trains.poll();
            boolean allocated=false;

            for(Platform platform:platforms.values()){
                if(!platform.isOccupied()){
                    platform.occupy();
                    System.out.println("Train "+train.getName()+" allocated to Platform "+platform.getNumber());
                    allocated=true;
                    break;
                }
            }

            if(!allocated){
                throw new PlatformUnavailableException("No platform available for "+train.getName());
            }
        }
    }

    public static void main(String[] args){
        RailwayPlatformAllocationSystem system=new RailwayPlatformAllocationSystem(2);

        system.addTrain(new Train("Rajdhani",10));
        system.addTrain(new Train("Shatabdi",5));
        system.addTrain(new Train("Duronto",8));

        try{
            system.allocate();
        }catch(PlatformUnavailableException e){
            System.out.println(e.getMessage());
        }
    }
}