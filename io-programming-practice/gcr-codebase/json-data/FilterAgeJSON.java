import org.json.JSONArray;
import org.json.JSONObject;

public class FilterAgeJSON{
    public static void main(String[]args){
        JSONArray users=new JSONArray();

        users.put(new JSONObject().put("name","Parth").put("age",22));
        users.put(new JSONObject().put("name","Aman").put("age",28));
        users.put(new JSONObject().put("name","Rohit").put("age",30));

        JSONArray filtered=new JSONArray();

        for(int i=0;i<users.length();i++){
            JSONObject obj=users.getJSONObject(i);

            if(obj.getInt("age")>25){
                filtered.put(obj);
            }
        }

        System.out.println(filtered.toString(4));
    }
}
