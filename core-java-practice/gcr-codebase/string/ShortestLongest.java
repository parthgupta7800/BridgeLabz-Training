import java.util.Scanner;

public class ShortestLongest {
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
        int words = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }
        String[] arr = new String[words];
        int index = 0;
        String temp = "";
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                temp += text.charAt(i);
            } else {
                arr[index++] = temp;
                temp = "";
            }
        }
        arr[index] = temp;
        return arr;
    }
    static int[] findShortestLongest(String[] words) {
        int min = findLength(words[0]);
        int max = findLength(words[0]);
        for (String word : words) {
            int len = findLength(word);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitManually(text);
        int[] result = findShortestLongest(words);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
