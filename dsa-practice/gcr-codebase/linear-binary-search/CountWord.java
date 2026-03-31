import java.util.*;
import java.io.*;
public class CountWord {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the Word to be counted:");
        String word=ob.nextLine();
        System.out.print("Count: "+count(word));
    }
    public static int count(String word){
        int count=0;
        BufferedReader read=null;
        try{
            FileReader file=new FileReader("sample.txt");
            read=new BufferedReader(file);
            String line;
            while((line=read.readLine())!=null){
                String words[]=line.split(" ");
                for(String w:words){
                    if(w.equals(word)){
                        count++;
                    }
                }
            }
            read.close();
        }catch(IOException e){
            System.out.println("An error occurred: "+e.getMessage());
        }
        return count;
    }

}
