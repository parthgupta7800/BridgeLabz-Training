import java.util.*;
public class Reverse {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        System.out.println("Reversed String:"+reverseString(str));
    }
    public static String reverseString(String str){
        StringBuilder reversed=new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
