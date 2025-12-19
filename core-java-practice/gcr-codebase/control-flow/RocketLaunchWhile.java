import java.util.*;
public class RocketLaunchWhile {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        while(number>0){
            System.out.println(number);
            number--;
        }
    }
}
