import java.util.*;
class Version{
    String version;
    int size;
    public Version(String version,int size) {
        this.version=version;
        this.size=size;
    }
    
}

class Manager{
    static Map<String , List<Version>>storage=new HashMap<>();

    public static void upload(String fileName,String version,int size){
        storage.putIfAbsent(fileName,new ArrayList<>());
        List<Version>versions=storage.get(fileName);
        for(int i=0;i<versions.size();i++){
            if(versions.get(i).version.equals(version)){
                return;
            }
        }
        versions.add(new Version(version,size));
    }

    public static void fetch(String fileName){
        List<Version>list=new ArrayList<>(storage.get(fileName));
        if(!storage.containsKey(fileName)){
            System.out.println("File Not Found");
            return;
        }
        Collections.sort(list,(a,b)->{
            if(a.size!=a.size)return a.size-b.size;
            return a.version.compareTo(b.version);}
        );
        for(Version v:list){
            System.out.println(fileName+" "+v.version+" "+v.size);
        }
    }

    public static void latest(String fileName){
        List<Version>list=new ArrayList<>(storage.get(fileName));
        if(!storage.containsKey(fileName)){
        System.out.println("File Not Found");
        return;
}
        Version v=list.get(list.size()-1);
        System.out.println(v.version+" "+v.size);
    }

    public static void totalStorage(String fileName){
        int add=0;
        List<Version>list=new ArrayList<>(storage.get(fileName));
        for(Version v:list){
            add+=v.size;
        }
        System.out.println(fileName+" "+add);
    }
}

public class VersionControl {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        Manager manage=new Manager();
        int n=ob.nextInt();
        ob.nextLine();
        for (int i = 0; i < n; i++) {
            String command=ob.nextLine();
            String str[]=command.split(" ");
            if(str[0].equals("UPLOAD")){
                manage.upload(str[1], str[2], Integer.parseInt(str[3]));
            }
            else if(str[0].equals("FETCH")){
                manage.fetch(str[1]);
            }
            else if(str[0].equals("LATEST")){
                manage.latest(str[1]);
            }
            else if(str[0].equals("TOTAL_STORAGE")){
                manage.totalStorage(str[1]);
            }
        }
    }
}
