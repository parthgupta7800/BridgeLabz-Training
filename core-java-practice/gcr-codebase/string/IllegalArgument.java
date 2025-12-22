import java.util.Scanner;

public class IllegalArgument {
    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }
    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);

    }
   }
