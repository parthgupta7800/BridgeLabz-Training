import java.io.*;
import java.util.Base64;
public class SecureCSV {
    public static void main(String[] args)throws Exception{
        writeEncryptedCSV();
        readDecryptedCSV();
    }
    static void writeEncryptedCSV()throws Exception{
        BufferedWriter bw=new BufferedWriter(new FileWriter("secure.csv"));
        bw.write("ID,Name,Salary,Email\n");
        String salary=encode("50000");
        String email=encode("parth@gmail.com");
        bw.write("1,Parth,"+salary+","+email+"\n");
        bw.close();
        System.out.println("Encrypted CSV Written");
    }
    static void readDecryptedCSV()throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("secure.csv"));
        br.readLine();
        String line;
        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            String salary=decode(d[2]);
            String email=decode(d[3]);
            System.out.println("ID:"+d[0]+" Name:"+d[1]+" Salary:"+salary+" Email:"+email);
        }
        br.close();
        System.out.println("Decrypted CSV Read");
    }
    static String encode(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
    static String decode(String data){
        return new String(Base64.getDecoder().decode(data));
    }
}
