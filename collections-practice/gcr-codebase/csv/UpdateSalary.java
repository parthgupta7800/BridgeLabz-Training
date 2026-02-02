import java.io.*;
public class UpdateSalary {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("updated.csv"));
        String line;
        bw.write(br.readLine()+"\n");
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            double salary=Double.parseDouble(data[3]);
            if(data[2].equalsIgnoreCase("IT")){
                salary=salary+(salary*0.10);
            }
            bw.write(data[0]+","+data[1]+","+data[2]+","+salary+"\n");
        }
        br.close();
        bw.close();
    }
}
