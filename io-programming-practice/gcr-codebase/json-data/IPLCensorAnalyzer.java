import java.nio.file.*;
import java.util.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class IPLCensorAnalyzer{

    public static void main(String[]args)throws Exception{
        censorJSON();
        censorCSV();
        System.out.println("Censorship Completed: output_censored.json & output_censored.csv generated");
    }

    static void censorJSON()throws Exception{
        String content=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\input.json")));
        JSONArray matches=new JSONArray(content);
        JSONArray output=new JSONArray();

        for(int i=0;i<matches.length();i++){
            JSONObject match=matches.getJSONObject(i);
            JSONObject censored=new JSONObject();

            String team1=maskTeam(match.getString("team1"));
            String team2=maskTeam(match.getString("team2"));

            censored.put("match_id",match.getInt("match_id"));
            censored.put("team1",team1);
            censored.put("team2",team2);

            JSONObject score=match.getJSONObject("score");
            JSONObject newScore=new JSONObject();

            for(String key:score.keySet()){
                newScore.put(maskTeam(key),score.getInt(key));
            }

            censored.put("score",newScore);
            censored.put("winner",maskTeam(match.getString("winner")));
            censored.put("player_of_match","REDACTED");

            output.put(censored);
        }

        FileWriter writer=new FileWriter("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\output_censored.json");
        writer.write(output.toString(4));
        writer.close();
    }

    static void censorCSV()throws Exception{
        List<String> lines=Files.readAllLines(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\input.csv"));
        List<String> output=new ArrayList<>();

        output.add(lines.get(0));

        for(int i=1;i<lines.size();i++){
            String[] parts=lines.get(i).split(",");

            parts[1]=maskTeam(parts[1]);
            parts[2]=maskTeam(parts[2]);
            parts[5]=maskTeam(parts[5]);
            parts[6]="REDACTED";

            output.add(String.join(",",parts));
        }

        Files.write(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\output_censored.csv"),output);
    }

    static String maskTeam(String team){
        String[] words=team.split(" ");
        if(words.length>1){
            return words[0]+" ***";
        }
        return "***";
    }
}
