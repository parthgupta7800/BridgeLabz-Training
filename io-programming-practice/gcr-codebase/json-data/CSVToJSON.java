import java.nio.file.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class CSVToJSON{
    public static void main(String[]args)throws Exception{
        List<String> lines=Files.readAllLines(Paths.get("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data\\data.csv"));

        String[] headers=lines.get(0).split(",");
        JSONArray array=new JSONArray();

        for(int i=1;i<lines.size();i++){
            String[] values=lines.get(i).split(",");
            JSONObject obj=new JSONObject();

            for(int j=0;j<headers.length;j++){
                obj.put(headers[j],values[j]);
            }

            array.put(obj);
        }

        System.out.println(array.toString(4));
    }
}
