import java.util.*;
public class Replace {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result = result + newWord;
            } else {
                result = result + words[i];
            }
            if (i < words.length - 1) {
                result = result + " ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();
        System.out.print("Enter new word: ");
        String newWord = sc.next();
        String updatedSentence = replaceWord(sentence, oldWord, newWord);
        System.out.println("Updated Sentence: " + updatedSentence);
    }
}
