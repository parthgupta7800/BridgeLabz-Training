import java.util.*;
class Fahrenheit
{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int cel=ob.nextInt();
        double fah=(cel*(9/5)+32);
        System.out.println(fah);
    }
}