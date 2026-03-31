import java.util.*;
public class PrintFactors {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        for(int i=1;i<number;i++){
            if(number%i==0)
                System.out.println(i);
        }
    }
}
