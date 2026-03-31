import org.json.JSONObject;

public class MergeJSON{
    public static void main(String[]args){
        JSONObject json1=new JSONObject();
        json1.put("name","Parth");
        json1.put("age",22);

        JSONObject json2=new JSONObject();
        json2.put("email","parth@gmail.com");
        json2.put("city","Mathura");

        for(String key:json2.keySet()){
            json1.put(key,json2.get(key));
        }

        System.out.println(json1.toString(4));
    }
}
