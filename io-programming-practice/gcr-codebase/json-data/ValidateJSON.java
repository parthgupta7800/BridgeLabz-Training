import org.json.JSONObject;

public class ValidateJSON{
    public static void main(String[]args){
        String jsonData="{\"name\":\"Parth\",\"age\":22}";

        try{
            JSONObject json=new JSONObject(jsonData);

            if(json.has("name")&&json.has("age")){
                System.out.println("Valid JSON Structure");
            }else{
                System.out.println("Invalid JSON Structure");
            }

        }catch(Exception e){
            System.out.println("Invalid JSON Format");
        }
    }
}
