import java.lang.reflect.Field;
class Configuration {
    private static String API_KEY="OLD_KEY";
}
public class StaticFieldModify {
    public static void main(String[] args)throws Exception {
        Field field=Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null,"NEW_SECRET_KEY");
        System.out.println("Updated API Key:"+field.get(null));
    }
}
