import java.lang.reflect.*;
interface Greeting {
    void sayHello();
}
class GreetingImpl implements Greeting {
    public void sayHello(){
        System.out.println("Hello Parth");
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting target=new GreetingImpl();
        Greeting proxy=(Greeting)Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (Object p,Method method,Object[] args1)->{
                System.out.println("Calling:"+method.getName());
                return method.invoke(target,args1);
            }
        );
        proxy.sayHello();
    }
}
