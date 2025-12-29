import java.util.*;
public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = ob.nextLine();
        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is not a Palindrome");
        }
    }
}
