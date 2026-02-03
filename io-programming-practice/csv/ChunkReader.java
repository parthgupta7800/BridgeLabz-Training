import java.io.*;
public class ChunkReader {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("big.csv"));
        String line;
        int count=0;
        int chunk=0;
        br.readLine();
        while((line=br.readLine())!=null){
            count++;
            chunk++;
            if(chunk==100){
                System.out.println("Processed:"+count);
                chunk=0;
            }
        }
        if(chunk>0){
            System.out.println("Processed:"+count);
        }
        br.close();
    }
}
