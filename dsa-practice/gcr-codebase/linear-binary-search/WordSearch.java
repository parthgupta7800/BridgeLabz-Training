import java.util.*;
public class WordSearch {
    public static String findSentence(String sentences[],String word){
        for(int i=0;i<sentences.length;i++){
            if(sentences[i].toLowerCase().contains(word.toLowerCase())){
                return sentences[i];
            }
        }
        return "Not Found";
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of sentences:");
        int n=ob.nextInt();
        ob.nextLine();
        String sentences[]=new String[n];
        System.out.println("Enter the sentences:");
        for(int i=0;i<n;i++){
            sentences[i]=ob.nextLine();
        }
        System.out.println("Enter word to search:");
        String word=ob.nextLine();
        String result=findSentence(sentences,word);
        if(result.equals("Not Found")){
            System.out.println("Not found");
        }else{
            System.out.println("Word found in sentence:");
            System.out.println(result);
        }
    }
}
