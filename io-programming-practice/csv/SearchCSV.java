import java.io.*;
import java.util.*;
public class SearchCSV {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name:");
        String search=sc.next();
        BufferedReader br=new BufferedReader(new FileReader("employees.csv"));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            if(data[1].equalsIgnoreCase(search)){
                System.out.println("Department:"+data[2]);
                System.out.println("Salary:"+data[3]);
            }
        }
        br.close();
    }
}
