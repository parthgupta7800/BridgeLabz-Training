import java.io.*;
import java.util.*;
public class WordFrequency {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> map=new HashMap<>();
        System.out.print("Enter file path: ");
        String path=sc.nextLine();
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null){
                line=line.toLowerCase().replaceAll("[^a-z ]"," ");
                String[] words=line.split("\\s+");
                for(String word:words){
                    if(word.length()>0){
                        map.put(word,map.getOrDefault(word,0)+1);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error reading file");
        }
        System.out.println("Word Frequencies:");
        System.out.println(map);
    }
}
