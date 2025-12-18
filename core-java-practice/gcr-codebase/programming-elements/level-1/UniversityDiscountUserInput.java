import java.util.*;
public class UniversityDiscountUserInput {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
        double fee=ob.nextDouble();
        double discountPercent=ob.nextInt();
        double amt=fee*(discountPercent/100);
        double price=fee-amt;
        System.out.println("The discount amount is INR "+amt+" and final discounted fee is INR "+price);
    }
}
