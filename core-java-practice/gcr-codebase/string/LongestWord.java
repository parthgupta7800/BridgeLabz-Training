import java.util.*;
public class LongestWord {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        String[] words = str.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord);
    }
}
