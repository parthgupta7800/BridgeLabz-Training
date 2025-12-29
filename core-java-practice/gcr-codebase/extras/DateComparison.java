import java.time.LocalDate;
import java.util.*;
public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate firstDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate secondDate = LocalDate.parse(scanner.nextLine());
        if (firstDate.isBefore(secondDate)) {
            System.out.println("First date is BEFORE second date");
        }
        else if (firstDate.isAfter(secondDate)) {
            System.out.println("First date is AFTER second date");
        }
        else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are SAME");
        }
    }
}
