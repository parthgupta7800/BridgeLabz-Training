import java.lang.reflect.Method;
class Calculator {
    private int multiply(int a,int b){
        return a*b;
    }
}
public class PrivateMethodCall {
    public static void main(String[] args)throws Exception {
        Calculator c=new Calculator();
        Method m=Calculator.class.getDeclaredMethod("multiply",int.class,int.class);
        m.setAccessible(true);
        int result=(int)m.invoke(c,5,4);
        System.out.println("Result:"+result);
    }
}
