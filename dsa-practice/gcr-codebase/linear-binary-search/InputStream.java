import java.io.*;
public class InputStream {
    public static void main(String[] args) {
        BufferedReader line = null;
        try {
            FileInputStream file = new FileInputStream("sample.txt");
            InputStreamReader isr=new InputStreamReader(file,"UTF-8");
            int ch;
            line = new BufferedReader(isr);
            while((ch=line.read())!=-1){
                System.out.println((char)ch);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (line != null) {
                    line.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader: " + e.getMessage());
            }
        }
    }
}
