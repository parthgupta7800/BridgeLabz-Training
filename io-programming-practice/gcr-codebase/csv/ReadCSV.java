import java.io.*;
public class ReadCSV {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            System.out.println("ID:"+data[0]);
            System.out.println("Name:"+data[1]);
            System.out.println("Age:"+data[2]);
            System.out.println("Marks:"+data[3]);
            System.out.println("--------------");
        }
        br.close();
    }
}
