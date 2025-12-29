import java.util.*;
public class FactorialRecursion {
    public static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = ob.nextInt();
        long result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
