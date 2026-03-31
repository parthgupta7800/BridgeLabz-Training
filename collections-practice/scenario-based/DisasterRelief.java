import java.util.*;

class InsufficientResourceException extends Exception{
    public InsufficientResourceException(String message){
        super(message);
    }
}

class AreaRequest{
    String areaName;
    String resourceName;
    int qty;
    public AreaRequest(String areaName,String resourceName,int qty) {
        this.areaName=areaName;
        this.resourceName=resourceName;
        this.qty=qty;
    }
}

class ReliefCenter{
    String centerName;
    Map<String,Integer>resource =new HashMap<>();
    public ReliefCenter(String centerName) {
        this.centerName=centerName;
    }
    void addResources(String name,int qty){
        resource.put(name,qty);
    }
    void allocate(AreaRequest req)throws InsufficientResourceException{
        int avaiable=resource.get(req.resourceName);
        if(avaiable<req.qty){
            throw new InsufficientResourceException("Resources Insufficient for the area:"+req.areaName);
        }
        resource.put(req.resourceName,avaiable-req.qty);
        System.out.println("Area supplied with the resource");
        System.out.println("Area:"+req.areaName);
        System.out.println("Resources:"+req.resourceName);
    }
}

public class DisasterRelief {
    public static void main(String args[]){
        Map<String,ReliefCenter>centers=new HashMap<>();
        Queue<AreaRequest>queue=new LinkedList<>();
        queue.add(new AreaRequest("AreaA","Food",5));
        queue.add(new AreaRequest("AreaB","Water",10));
        
        ReliefCenter c1=new ReliefCenter("Centre 1");
        c1.addResources("Food", 10);
        c1.addResources("Water", 20);
        c1.addResources("MedKit", 5);

        ReliefCenter c2=new ReliefCenter("Centre 2");
        c2.addResources("Food", 10);
        c2.addResources("Water", 20);
        c2.addResources("MedKit", 5);

        centers.put("c1",c1);
        centers.put("c2",c2);

        while(!queue.isEmpty()){
            AreaRequest req=queue.poll();
            try{
                centers.get("c1").allocate(req);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
