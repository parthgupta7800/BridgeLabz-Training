import java.io.*;
public class JsonToCSV {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("students.json"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("result.csv"));
        bw.write("ID,Name,Age\n");
        String line;
        while((line=br.readLine())!=null){
            if(!line.contains("id")){
                continue;
            }
            line=line.replace("{","").replace("}","").replace("\"","");
            String[] p=line.split(",");
            String id=p[0].split(":")[1];
            String name=p[1].split(":")[1];
            String age=p[2].split(":")[1];
            bw.write(id+","+name+","+age+"\n");
        }
        br.close();
        bw.close();
        System.out.println("JSON To CSV Done");
    }
}
