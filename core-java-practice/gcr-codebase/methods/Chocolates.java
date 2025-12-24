import java.util.*;
public class Chocolates {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the number of chocolates");
        int choco=ob.nextInt();
        System.out.println("Enter the number of childrens");
        int child=ob.nextInt();
        Chocolates obj=new Chocolates();
        System.out.println(obj.findRemainderAndQuotient(choco,child));
    }
    public static int[] findRemainderAndQuotient(int choco,int child){
        int div=choco/child;
        int rem=choco%child;
        int arr[]={div,rem};
        return arr;
    }
}
