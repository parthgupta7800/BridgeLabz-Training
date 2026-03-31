import java.util.*;
public class ReverseString {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        StringBuilder reverse=new StringBuilder();
        for(int i=str.length()-1;i<=0;i--){
            reverse.append(str.charAt(i));
        }
        System.out.println("Reversed string :"+reverse.toString());
    }
}
