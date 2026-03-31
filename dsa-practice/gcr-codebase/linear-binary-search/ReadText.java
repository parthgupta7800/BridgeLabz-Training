import java.util.*;
import java.io.*;
public class ReadText {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            FileReader read=new FileReader("sample.txt");
            reader = new BufferedReader(read);
            String line="";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader: " + e.getMessage());
            }
        }
    }
}
