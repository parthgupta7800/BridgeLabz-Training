import java.util.Scanner;

public class NumberFormat {
    static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }
    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }
}
