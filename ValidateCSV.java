import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        String line;
        br.readLine();

        Pattern emailPattern=Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Pattern phonePattern=Pattern.compile("\\d{10}");

        while((line=br.readLine())!=null){
            String[] data=line.split(",");

            if(!emailPattern.matcher(data[4]).matches()||!phonePattern.matcher(data[5]).matches()){
                System.out.println("Invalid Row:"+line);
            }
        }
        br.close();
    }
}
