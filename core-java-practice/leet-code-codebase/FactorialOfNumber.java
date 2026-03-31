import java.util.*;
public class FactorialOfNumber {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int n, f = 1;
        System.out.println("Enter the number");
        n = ob.nextInt();
        while (n > 0) {
            f = f * n;
            n--;
        }
        System.out.println(f);
    }
}
