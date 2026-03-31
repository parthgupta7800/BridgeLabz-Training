import java.util.*;

public class MetroSmartCard {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        System.out.println("Welcome to Delhi Metro Smart Card !");
        System.out.println("You have 300 rupees in your card");
        System.out.println("Enter -1 to exit");
        double card = 300;
        boolean flag = true;
        while (flag) {
            if (card <= 0) {
                System.out.println("Balance exhausted. Please recharge.");
                break;
            }
            System.out.print("Enter the distance (in km): ");
            int distance = ob.nextInt();
            if (distance == -1) {
                flag = false;
            } 
            else if (distance <= 0) {
                System.out.println("Invalid distance entered.");
            } 
            else {
                double amount = (distance <= 5) ? 1: (distance <= 10) ? 20: (distance <= 20) ? 30: 40;
                if (amount > card) {
                    System.out.println("Insufficient balance for this trip.");
                } else {
                    card = card - amount;
                    System.out.println("Fare deducted: " + amount);
                    System.out.println("Remaining balance: " + card);
                }
            }
        }
        System.out.println("Thank you for using Delhi Metro");
    }
}
