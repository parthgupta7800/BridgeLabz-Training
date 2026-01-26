import java.io.*;
public class LowerCaseConverter {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
            String line;
            while((line=br.readLine())!=null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            br.close();
            bw.close();
            System.out.println("Conversion completed.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
