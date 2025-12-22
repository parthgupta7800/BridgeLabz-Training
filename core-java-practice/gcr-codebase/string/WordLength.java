import java.util.Scanner;

public class WordLength {
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
    static String[][] create2DArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitManually(text);
        String[][] data = create2DArray(words);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + Integer.parseInt(data[i][1]));
        }
    }
}
