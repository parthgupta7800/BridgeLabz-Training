import java.util.*;
public class Frequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String str = sc.nextLine();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }
        int maxCount = freq[0];
        char mostFrequentChar = 'a';
        for (int i = 1; i < 26; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                mostFrequentChar = (char) (i + 'a');
            }
        }
        System.out.println("Most Frequent Character: " + mostFrequentChar);
    }
}
