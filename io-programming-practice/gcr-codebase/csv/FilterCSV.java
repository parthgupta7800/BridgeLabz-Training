import java.io.*;
public class FilterCSV {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            int marks=Integer.parseInt(data[3]);
            if(marks>80){
                System.out.println(data[1]+" "+marks);
            }
        }
        br.close();
    }
}
