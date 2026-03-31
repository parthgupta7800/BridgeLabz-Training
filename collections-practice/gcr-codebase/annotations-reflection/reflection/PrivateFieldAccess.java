import java.lang.reflect.Field;
class Person {
    private int age;
}
public class PrivateFieldAccess {
    public static void main(String[] args)throws Exception {
        Person p=new Person();
        Field field=Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.setInt(p,25);
        System.out.println("Age:"+field.getInt(p));
    }
}
