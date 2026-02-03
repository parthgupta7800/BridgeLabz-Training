import com.fasterxml.jackson.databind.ObjectMapper;
public class ValidateJSONJackson{
    public static void main(String[]args){
        String json="{\"name\":\"Parth\",\"age\":22}";
        ObjectMapper mapper=new ObjectMapper();
        try{
            mapper.readTree(json);
            System.out.println("Valid JSON Format");
        }catch(Exception e){
            System.out.println("Invalid JSON Format");
        }
    }
}
