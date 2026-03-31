import java.util.*;
public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();
        int minLength = Math.min(s1.length(), s2.length());
        boolean differenceFound = false;
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println( s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                differenceFound = true;
                break;
            } 
            else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
                differenceFound = true;
                break;
            }
        }
    }
}
