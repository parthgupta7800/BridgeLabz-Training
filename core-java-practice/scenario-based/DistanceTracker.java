import java.util.*;
public class DistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = 0;
        int stop;
        char choice = 'n';
        while (choice != 'y') {
            System.out.print("Enter distance traveled to next stop (in km): ");
            stop = sc.nextInt();
            distance = distance + stop;
            System.out.println("Total distance traveled so far: " + distance + " km");
            System.out.print("Do you want to get off at this stop? (y/n): ");
            choice = sc.next().charAt(0);
        }
        System.out.println("Passenger got off.");
        System.out.println("Final distance traveled: " + distance + " km");
    }
}
