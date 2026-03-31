import java.util.*;
public class MergeMap {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        HashMap<String,Integer> result=new HashMap<>();
        System.out.print("Enter number of entries in Map1: ");
        int n1=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n1;i++){
            System.out.print("Enter key: ");
            String key=sc.nextLine();
            System.out.print("Enter value: ");
            int value=sc.nextInt();
            sc.nextLine();
            map1.put(key,value);
        }
        System.out.print("Enter number of entries in Map2: ");
        int n2=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n2;i++){
            System.out.print("Enter key: ");
            String key=sc.nextLine();
            System.out.print("Enter value: ");
            int value=sc.nextInt();
            sc.nextLine();
            map2.put(key,value);
        }
        result.putAll(map1);
        for(String key:map2.keySet()){
            int value=map2.get(key);
            result.put(key,result.getOrDefault(key,0)+value);
        }
        System.out.println("nMerged Map: "+result);
    }
}
