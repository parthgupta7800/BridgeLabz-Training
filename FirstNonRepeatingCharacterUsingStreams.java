import java.util.*;
public class FirstNonRepeatingCharacterUsingStreams {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        Optional<String> result=Arrays.stream(str.split("")).
            filter(s->str.indexOf(s)==str.lastIndexOf(s)).
            findFirst();
        System.out.println(result.get());
    }
}
