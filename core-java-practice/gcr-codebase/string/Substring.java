import java.util.*;
public class Substring {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        System.out.println("Enter the String to checked");
        String check=ob.next();
        int count=0;
        String word[]=str.split(" ");
        for(int i=0;i<word.length;i++){
            if(word[i].equals(check))
                count++;
        }
        System.out.println("The mentioned string occurs "+count+" times");
    }
}
