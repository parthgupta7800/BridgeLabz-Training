import java.io.*;
public class StudentData {
    public static void main(String[] args) {
        try {
            DataOutputStream dos=new DataOutputStream(new FileOutputStream("input.txt"));
            dos.writeInt(101);
            dos.writeUTF("Parth");
            dos.writeDouble(8.9);
            dos.close();
            DataInputStream dis=new DataInputStream(new FileInputStream("input.txt"));
            int roll=dis.readInt();
            String name=dis.readUTF();
            double gpa=dis.readDouble();
            System.out.println("Roll:"+roll);
            System.out.println("Name:"+name);
            System.out.println("GPA:"+gpa);
            dis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
