import java.util.*;
public class PrimeNumberChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = ob.nextInt();
        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }
}
