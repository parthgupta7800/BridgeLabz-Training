import java.util.*;
public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        System.out.println("Enter the charcter to be remove");
        char ch=ob.next().charAt(0);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=ch)
                sb.append(str.charAt(i));
        }
        System.out.println("New String :"+sb.toString());
   }
}
