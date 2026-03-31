import java.util.*;
public class VowelsConsonant{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        String result = str.replace(" ", "");
        int vowel=0,consonant=0;
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)=='a'||result.charAt(i)=='e'||result.charAt(i)=='i'||result.charAt(i)=='o'||result.charAt(i)=='u'){
                vowel++;
            }
            else consonant++;
        }   
        System.out.println("Vowels: "+vowel);
        System.out.println("Consonant: "+consonant);
    }
}