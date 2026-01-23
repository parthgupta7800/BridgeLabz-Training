import java.util.*;
public class InvertMap {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> original=new HashMap<>();
        HashMap<Integer,List<String>> inverted=new HashMap<>();
        System.out.print("Enter number of entries: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter key: ");
            String key=sc.nextLine();
            System.out.print("Enter value: ");
            int value=sc.nextInt();
            sc.nextLine();
            original.put(key,value);
        }
        for(String key:original.keySet()){
            int value=original.get(key);
            if(!inverted.containsKey(value)){
                inverted.put(value,new ArrayList<>());
            }
            inverted.get(value).add(key);
        }
        System.out.println("Original Map: "+original);
        System.out.println("Inverted Map: "+inverted);
    }
}
