import java.util.*;
public class MaxValue {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> map=new HashMap<>();
        System.out.print("Enter number of entries: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter key: ");
            String key=sc.nextLine();
            System.out.print("Enter value: ");
            int value=sc.nextInt();
            sc.nextLine();
            map.put(key,value);
        }
        String maxKey=null;
        int maxValue=Integer.MIN_VALUE;
        for(String key:map.keySet()){
            int value=map.get(key);
            if(value>maxValue){
                maxValue=value;
                maxKey=key;
            }
        }
        System.out.println("Map: "+map);
        System.out.println("Key with Highest Value: "+maxKey);
    }
}
