import java.util.*;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        char moreCustomers = 'y';
        while (moreCustomers == 'y') {
            int price = 0;
            System.out.print("Enter movie type (2D / 3D): ");
            String movieType = ob.next();
            System.out.print("Enter seat type (gold / silver): ");
            String seatType = ob.next();
            System.out.print("Do you want snacks? (yes / no): ");
            String snacks = ob.next();
            switch (movieType.toLowerCase()) {
                case "2d":
                    price += 150;
                    break;
                case "3d":
                    price += 250;
                    break;
                default:
                    System.out.println("Invalid movie type!");
            }
            if (seatType.equals("gold")) {
                price += 100;
            } else if (seatType.equals("silver")) {
                price += 50;
            }
            if (snacks.equals("yes")) {
                price += 80;
            }
            System.out.println("Total Ticket Price: ₹" + price);
            System.out.print("Next customer? (y/n): ");
            moreCustomers = ob.next().charAt(0);
        }
    }
}
