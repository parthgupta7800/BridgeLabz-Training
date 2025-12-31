import java.util.*;
public class LongestWord{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        int max=0;
        String ans="";
        String word[]=str.split(" ");
        for(int i=0;i<word.length;i++){
            String w=word[i];
            if(max<w.length()){
                ans=w;
                max=w.length();
            }
        }
        System.out.println("Longest word: "+ans);
        System.out.println("Length: "+max);
    }
}