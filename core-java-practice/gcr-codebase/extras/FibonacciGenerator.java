import java.util.*;
public class FibonacciGenerator {
    public static void printFibonacci(int terms) {
        int first = 0;
        int second = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = ob.nextInt();
        printFibonacci(terms);
    }
}

