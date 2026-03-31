import java.util.*;
public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int finePerDay = 5;
        for (int book = 1; book <= 5; book++) {
            System.out.println("Book " + book);
            System.out.println("Enter due date");
            int dueDate = ob.nextInt();
            System.out.println("Enter return date");
            int returnDate = ob.nextInt();
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * finePerDay;
                System.out.println("Late by " + lateDays + " days");
                System.out.println("Fine =" + fine);
            } else {
                System.out.println("Returned on time. No fine ");
            }
        }
    }
}
