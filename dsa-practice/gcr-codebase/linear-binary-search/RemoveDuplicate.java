import java.util.*;
public class RemoveDuplicate {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the string");
        String str=ob.nextLine();
        System.out.println("String after removing duplicates:"+RemoveDuplicate(str));
    }
    public static String RemoveDuplicate(String str){
        StringBuilder string=new StringBuilder();
        Set<Character> seen=new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!seen.contains(ch)){
                string.append(ch);
                seen.add(ch);
            }
        }
        return string.toString();
    }
}
