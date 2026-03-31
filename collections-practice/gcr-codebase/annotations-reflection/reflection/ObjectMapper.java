import java.lang.reflect.Field;
import java.util.*;
class Student {
    private String name;
    private int age;
}
public class ObjectMapper {
    public static<T>T toObject(Class<T> clazz,Map<String,Object> properties)throws Exception {
        T obj=clazz.getDeclaredConstructor().newInstance();
        for(Map.Entry<String,Object> entry:properties.entrySet()){
            Field field=clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj,entry.getValue());
        }
        return obj;
    }
    public static void main(String[] args)throws Exception {
        Map<String,Object> data=new HashMap<>();
        data.put("name","Parth");
        data.put("age",22);
        Student student=toObject(Student.class,data);
        System.out.println("Object Created Using Reflection:");
        System.out.println("Name:"+getFieldValue(student,"name"));
        System.out.println("Age:"+getFieldValue(student,"age"));
    }
    private static Object getFieldValue(Object obj,String fieldName)throws Exception {
        Field field=obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
