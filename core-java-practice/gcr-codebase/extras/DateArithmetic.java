import java.time.LocalDate;
import java.util.*;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Original Date : " + date);
        System.out.println("Final Date    : " + updatedDate);
    }
}
