import java.util.*;
public class MaximumOfThree {
    public static int getInput(Scanner ob, String message) {
        System.out.print(message);
        return ob.nextInt();
    }
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int num1 = getInput(ob, "Enter first number: ");
        int num2 = getInput(ob, "Enter second number: ");
        int num3 = getInput(ob, "Enter third number: ");
        int maximum = findMaximum(num1, num2, num3);
        System.out.println("Maximum number is: " + maximum);
    }
}
