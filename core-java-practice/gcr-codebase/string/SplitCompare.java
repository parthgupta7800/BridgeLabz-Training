import java.util.Scanner;

public class SplitCompare {
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    static String[] splitManually(String text) {
        int length = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        String[] words = new String[wordCount];
        int index = 0;
        String word = "";
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                words[index++] = word;
                word = "";
            }
        }
        words[index] = word;
        return words;
    }
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] manual = splitManually(text);
        String[] builtIn = text.split(" ");
        System.out.println(compareArrays(manual, builtIn));
    }
}
