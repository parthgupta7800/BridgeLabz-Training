import java.util.*;
public class GcdLcmCalculator {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = ob.nextInt();
        System.out.print("Enter second number: ");
        int num2 = ob.nextInt();
        System.out.println("GCD = " + findGCD(num1, num2));
        System.out.println("LCM = " + findLCM(num1, num2));
    }
}
