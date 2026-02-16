import java.text.Collator;
import java.util.*;
import java.util.stream.*;

class InvalidWaterLevelException extends Exception{
    public InvalidWaterLevelException(String message){
        super(message);
    }
}

class Tank{
    int tankId;
    double capacity;
    double currentLevel;
    Tank(int tankId,double capacity,double currentLevel)throws InvalidWaterLevelException{
        if(currentLevel>capacity){
            throw  new InvalidWaterLevelException("Level exceeds capacity for tank : "+tankId);
        }
        this.tankId=tankId;
        this.capacity=capacity;
        this.currentLevel=currentLevel;
    }

    @Override
    public String toString(){
        return tankId+" | "+capacity+" | "+currentLevel;
    }
}

class Manager{
    ArrayList<Tank>tanks=new ArrayList<>();
    void addTank(Tank t){
        tanks.add(t);
    }

    public int usagePercent(int id){
        int percent=0;
        for(int i=0;i<tanks.size();i++){
            if(tanks.get(i).tankId==id){
                percent=(int)((tanks.get(i).currentLevel/tanks.get(i).capacity)*100);
            }
        }
        return percent;
    }

    public List<Tank> sortByLevel(){
        return tanks.stream().sorted(Comparator.comparingDouble(e->e.currentLevel)).collect(Collectors.toList());
    }

}

public class SmartWaterTank {
    public static void main(String args[]){
        Manager manager=new Manager();
        try {
            manager.addTank(new Tank(1, 100, 89));
            manager.addTank(new Tank(2, 100, 99));
            manager.addTank(new Tank(3, 100, 29));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(manager.usagePercent(2));
        System.out.println(manager.sortByLevel());
    }
}
