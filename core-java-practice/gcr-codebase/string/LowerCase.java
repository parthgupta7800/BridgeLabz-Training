import java.util.Scanner;

public class LowerCase {
    static String toLowerManually(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
        }
        return result;
    }
    static boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String manual = toLowerManually(text);
        String builtIn = text.toLowerCase();
        System.out.println(compare(manual, builtIn));
    }
}
