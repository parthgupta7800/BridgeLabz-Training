import java.io.*;
import java.util.*;
public class DuplicateFinder {
    public static void main(String[] args)throws Exception{
        Set<String> seen=new HashSet<>();
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String id=line.split(",")[0];
            if(!seen.add(id)){
                System.out.println("Duplicate:"+line);
            }
        }
        br.close();
    }
}
