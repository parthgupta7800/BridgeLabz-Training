import java.util.*;

public class KeyGeneration {
    public static String validateString(String str){
        if(str.contains(" "))
            return "Invalid Input (contains space)";

        if(str.matches(".*\\d.*"))
            return "Invalid Input (contains digits)";

        if(!str.matches("[a-zA-Z]*"))
            return "Invalid Input (contains special character)";

        if(str.length()<6)
            return "Invalid Input (length < 6)";

        return "VALID";
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        ob.nextLine();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            String str=ob.nextLine();
            String check=validateString(str);
            if(check.equals("VALID")){
                str=str.toLowerCase();
                char ch[]=str.toCharArray();
                for(int j=0;j<ch.length;j++){
                    if((int)ch[j]%2!=0){
                        sb.append(ch[j]);
                    }
                }
                String reverse=sb.reverse().toString();
                char last[]=reverse.toCharArray();
                for(int j=0;j<last.length;j++){
                    if(j%2==0){
                        last[j]=Character.toUpperCase(last[j]);
                    }
                }
                String ans=new String(last);
                System.out.println(ans);
            }
            else System.out.println(check);
        }
    }
}
