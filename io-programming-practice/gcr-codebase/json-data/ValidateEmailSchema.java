import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class ValidateEmailSchema{
    public static void main(String[]args)throws Exception{
        String content=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\sample.json")));
        JSONObject json=new JSONObject(content);

        String email=json.optString("email");

        String pattern="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if(email.matches(pattern)){
            System.out.println("Valid Email");
        }else{
            System.out.println("Invalid Email");
        }
    }
}
