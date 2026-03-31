import java.lang.reflect.Field;
class Employee {
    private String name;
    private int id;
    private double salary;
}

public class JsonGenerator {
    public static String toJson(Object obj)throws Exception {
        StringBuilder json=new StringBuilder("{");
        Field[] fields=obj.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":\"").append(fields[i].get(obj)).append("\"");
            if(i<fields.length-1){
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }
    public static void main(String[] args)throws Exception {
        Employee emp=new Employee();
        setField(emp,"name","Parth");
        setField(emp,"id",101);
        setField(emp,"salary",55000.5);
        String json=toJson(emp);
        System.out.println("Generated JSON:");
        System.out.println(json);
    }
    private static void setField(Object obj,String fieldName,Object value)throws Exception {
        Field field=obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj,value);
    }
}
