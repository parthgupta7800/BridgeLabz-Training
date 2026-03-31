import java.util.*;
public class DigitalWatch {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter stop hour (0-23): ");
        int stopHour = ob.nextInt();
        System.out.print("Enter stop minute (0-59): ");
        int stopMinute = ob.nextInt();
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (hour == stopHour && minute == stopMinute) {
                    System.out.println("Power cut at "+ hour + ":" + minute);
                    return;
                }
                System.out.println(hour + ":" + minute);
            }
        }
    }
}
