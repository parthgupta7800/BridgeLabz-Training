import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

class User{
    String name;
    int age;

    User(String name,int age){
        this.name=name;
        this.age=age;
    }
}

public class ListToJSONArray{
    public static void main(String[]args){
        List<User> users=new ArrayList<>();
        users.add(new User("Parth",22));
        users.add(new User("Aman",26));
        users.add(new User("Rohit",30));

        JSONArray array=new JSONArray();

        for(User u:users){
            JSONObject obj=new JSONObject();
            obj.put("name",u.name);
            obj.put("age",u.age);
            array.put(obj);
        }

        System.out.println(array.toString(4));
    }
}
