import java.util.Scanner;

public class DoubleOpt {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        double a=ob.nextDouble();
        double b=ob.nextDouble();
        double c=ob.nextDouble();
        double op1=a + b *c;
        double op2=a * b + c;
        double op3= c + a / b;
        double op4=a % b + c;
        System.out.println("The results of Double Operations are "+op1+" ,"+op2+" ,"+op3+" ,and "+op4);
    }
}
