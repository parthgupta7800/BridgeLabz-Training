import java.util.*;
public class OddEvenPrint {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        for(int i=1;i<=number;i++)
        {
            if(i%2==0)
                System.out.println(number+" is even");
            else System.out.println(number+" is odd");
        }
    }
}
