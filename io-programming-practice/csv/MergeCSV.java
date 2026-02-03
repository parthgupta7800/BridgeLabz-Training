import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args)throws Exception{
        Map<String,String[]> map=new HashMap<>();
        BufferedReader br1=new BufferedReader(new FileReader("student1.csv"));
        String line=br1.readLine();
        while((line=br1.readLine())!=null){
            if(line.trim().isEmpty()){
                continue;
            }
            String[] d=line.split(",");
            String id=d[0].trim();
            map.put(id,d);
        }
        BufferedReader br2=new BufferedReader(new FileReader("student2.csv"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("merged.csv"));
        bw.write("ID,Name,Age,Marks,Grade\n");
        br2.readLine();
        while((line=br2.readLine())!=null){
            if(line.trim().isEmpty()){
                continue;
            }
            String[] d2=line.split(",");
            String id=d2[0].trim();
            String[] d1=map.get(id);
            if(d1==null){
                System.out.println("Skipping Missing ID:"+id);
                continue;
            }
            bw.write(d1[0]+","+d1[1]+","+d1[2]+","+d2[1]+","+d2[2]+"\n");
        }
        br1.close();
        br2.close();
        bw.close();
        System.out.println("Merge Completed Successfully");
    }
}
