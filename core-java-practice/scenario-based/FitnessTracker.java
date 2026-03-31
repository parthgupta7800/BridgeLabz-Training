import java.util.*;
public class FitnessTracker {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int[] pushUps = new int[7];
        int totalPushUps = 0;
        int activeDays = 0;
        for (int day = 0; day < 7; day++) {
            System.out.print("Enter push-ups for day " + (day + 1) + " (0 for rest): ");
            pushUps[day] = ob.nextInt();
        }
        for (int count : pushUps) {
            if (count == 0) {
                continue;
            }
            totalPushUps += count;
            activeDays++;
        }
        double average = (double) totalPushUps / activeDays;
        System.out.println("Total Push-ups: " + totalPushUps);
        System.out.println("Average Push-ups per active day: " + average);
    }
}
