import java.io.*;
public class UserInfoToFile {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer=null;
        try {
            System.out.print("Enter Name:");
            String name=reader.readLine();
            System.out.print("Enter Age:");
            String age=reader.readLine();
            System.out.print("Enter Favorite Language:");
            String language=reader.readLine();
            writer=new FileWriter("output.txt");
            writer.write("Name:"+name+"\n");
            writer.write("Age:"+age+"\n");
            writer.write("Favorite Language:"+language+"\n");
            System.out.println("Data saved successfully.");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null) writer.close();
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
