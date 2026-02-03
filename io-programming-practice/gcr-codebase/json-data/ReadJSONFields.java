import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class ReadJSONFields{
    public static void main(String[]args)throws Exception{
        String content=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\sample.json")));

        JSONObject json=new JSONObject(content);

        System.out.println("Name:"+json.getString("name"));
        System.out.println("Email:"+json.getString("email"));
    }
}
