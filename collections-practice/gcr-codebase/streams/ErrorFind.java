import java.io.*;
public class ErrorFind {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
            String line;
            while((line=br.readLine())!=null) {
                if(line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
