import java.lang.reflect.Method;
import java.util.*;
class MathOperations {
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
}
public class DynamicMethod {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        MathOperations obj=new MathOperations();
        System.out.print("Enter method name:");
        String methodName=sc.next();
        Method method=MathOperations.class.getMethod(methodName,int.class,int.class);
        int result=(int)method.invoke(obj,10,5);
        System.out.println("Result:"+result);
    }
}
