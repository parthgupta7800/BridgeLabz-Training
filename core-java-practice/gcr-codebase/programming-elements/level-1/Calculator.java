import java.util.*;
public class Calculator {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        float number1=ob.nextFloat();
        float number2=ob.nextFloat();
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+(number1+number2)+","+(number1-number2)+","+(number1*number2)+", and"+(number1/number2));
    }
}
