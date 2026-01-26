import java.io.*;
public class ImageByte {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("download.jpeg");
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int data;
            while((data=fis.read())!=-1) {
                baos.write(data);
            }
            byte[] imageBytes=baos.toByteArray();
            ByteArrayInputStream bais=new ByteArrayInputStream(imageBytes);
            FileOutputStream fos=new FileOutputStream("output.jpg");
            while((data=bais.read())!=-1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
            bais.close();
            baos.close();
            System.out.println("Image copied successfully.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
