import java.util.*;
public class LongestWordInAStringUsingStreams {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the String");
        String str=ob.nextLine();
        Optional<String> result=Arrays.stream(str.split(" ")).
            max(Comparator.comparingInt(String::length));
        System.out.println(result.get());
    }
}
