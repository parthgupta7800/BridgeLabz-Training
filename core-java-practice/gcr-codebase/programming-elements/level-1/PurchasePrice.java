import java.util.*;
public class PurchasePrice {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int unitPrice=ob.nextInt();
        int qty=ob.nextInt();
        System.out.println("The total purchase price is INR "+(unitPrice*qty)+" if the quantity is "+qty+" and unit price is INR "+unitPrice);
    }
}
