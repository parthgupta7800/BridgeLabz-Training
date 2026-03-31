import java.io.*;
import java.util.*;
public class CountWord {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        try {
            BufferedReader br=new BufferedReader(new FileReader("text.txt"));
            String line;
            while((line=br.readLine())!=null) {
                String[] words=line.toLowerCase().replaceAll("[^a-z ]","").split("\\s+");
                for(String word:words) {
                    if(word.isEmpty()) continue;
                    map.put(word,map.getOrDefault(word,0)+1);
                }
            }
            br.close();
            map.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).limit(5).forEach(e->System.out.println(e.getKey()+"="+e.getValue()));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
