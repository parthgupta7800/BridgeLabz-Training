import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrintJSONRecursive{
    public static void main(String[]args)throws Exception{
        String content=new String(Files.readAllBytes(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\sample.json")));
        JSONObject json=new JSONObject(content);

        print(json,"");
    }

    static void print(Object obj,String indent){
        if(obj instanceof JSONObject){
            JSONObject json=(JSONObject)obj;
            for(String key:json.keySet()){
                System.out.println(indent+key+":");
                print(json.get(key),indent+"  ");
            }
        }else if(obj instanceof JSONArray){
            JSONArray arr=(JSONArray)obj;
            for(int i=0;i<arr.length();i++){
                print(arr.get(i),indent+"  ");
            }
        }else{
            System.out.println(indent+obj);
        }
    }
}
