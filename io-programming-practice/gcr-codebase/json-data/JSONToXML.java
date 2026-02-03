import org.json.JSONObject;
import org.json.XML;

public class JSONToXML{
    public static void main(String[]args){
        JSONObject json=new JSONObject();
        json.put("name","Parth");
        json.put("age",22);
        json.put("city","Mathura");

        String xml=XML.toString(json,"student");

        System.out.println(xml);
    }
}
