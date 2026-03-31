import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class PrintAllJSONKeys{
    public static void main(String[]args)throws Exception{
        String content=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\sample.json")));

        JSONObject json=new JSONObject(content);

        for(String key:json.keySet()){
            System.out.println(key+":"+json.get(key));
        }
    }
}
