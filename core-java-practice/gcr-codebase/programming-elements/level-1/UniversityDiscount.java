public class UniversityDiscount {
    public static void main(String args[]){
        int fee=125000;
        double disc=0.1;
        double amt=fee*disc;
        double price=fee-amt;
        System.out.println("The discount amount is INR "+amt+" and final discounted fee is INR "+price);
    }
}
