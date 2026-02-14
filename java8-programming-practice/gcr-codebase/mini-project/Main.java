
import java.time.LocalDate;

public class Main {
    public static void main(String args[]){
        Functionality function=new Functionality();
        function.addEnrollment(new Enrollment("Parth", "GenAI", "AI", LocalDate.now()));
        function.addEnrollment( new Enrollment("Aryan", "GenAI", "AI", LocalDate.now()));
        function.addEnrollment(new Enrollment("Aman", "HTML", "Web", LocalDate.now()));
        function.addEnrollment(new Enrollment("Abhinav", "HTML", "AI", LocalDate.now()));
        System.out.println(function.countByCategory());
        System.out.println(function.groupByCourseName());
        System.out.println(function.filterByCourse("GenAI"));
        System.out.println(function.sortByDate());
    }
}
