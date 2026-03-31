import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}
class Engine {
    public void start(){
        System.out.println("Engine Started");
    }
}
class Car {
    @Inject
    private Engine engine;
    public void drive(){
        engine.start();
        System.out.println("Car Running");
    }
}
public class DIContainer {
    public static void inject(Object obj)throws Exception {
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                Object dependency=field.getType().getDeclaredConstructor().newInstance();
                field.set(obj,dependency);
            }
        }
    }
    public static void main(String[] args)throws Exception {
        Car car=new Car();
        inject(car);
        car.drive();
    }
}
