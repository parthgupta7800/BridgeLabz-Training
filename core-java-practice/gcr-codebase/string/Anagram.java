import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine().toLowerCase();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine().toLowerCase();
        if (s1.length() != s2.length()) {
            System.out.println("Not an Anagram");
            return;
        }
        int[] freq = new int[26]; 
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            freq[ch - 'a']--;
        }
        boolean isAnagram = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                isAnagram = false;
                break;
            }
        }
        if (isAnagram) {
            System.out.println("Strings are Anagrams");
        } else {
            System.out.println("Strings are not Anagrams");
        }
    }
}
