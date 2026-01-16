import java.io.*;
public class FileWrite {
    public static void main(String[] args) {
        FileWriter writer = null;
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            System.out.println("Enter text to write to file (type 'exit' to finish)");
            writer = new FileWriter("output.txt");
            String line;
            while((line=reader.readLine())!=null){
                if(line.equalsIgnoreCase("exit")){
                    break;
                }
                writer.write(line);
                writer.write("\n");
                System.out.println("Line added to file");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
}
