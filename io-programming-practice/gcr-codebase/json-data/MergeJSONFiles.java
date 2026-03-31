import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class MergeJSONFiles{
    public static void main(String[]args)throws Exception{
        String file1=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\file1.json")));
        String file2=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\file2.json")));

        JSONObject json1=new JSONObject(file1);
        JSONObject json2=new JSONObject(file2);

        for(String key:json2.keySet()){
            json1.put(key,json2.get(key));
        }

        System.out.println(json1.toString(4));
    }
}