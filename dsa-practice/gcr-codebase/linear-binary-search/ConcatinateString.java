import java.util.*;
public class ConcatinateString {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
        System.out.println("Enter size of array");
        int n=ob.nextInt();
        ob.nextLine();
        String arr[]=new String[n];
        System.out.println("Enter the strings:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextLine();
        }
    }
    public static String concatinateStrings(String arr[]){
        StringBuffer result=new StringBuffer();
        for(String str:arr){
            result.append(str);
        }
        return result.toString();
    }
}
