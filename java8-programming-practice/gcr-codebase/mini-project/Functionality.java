import java.util.*;
import java.time.*;
import java.util.stream.*;

public class Functionality {
    private ArrayList<Enrollment>enroll=new ArrayList<>();

    public void addEnrollment(Enrollment e){
        enroll.add(e);
    }

    public List<Enrollment> filterByCourse(String course){
        return enroll.stream()
            .filter(e->e.getCourseName().equalsIgnoreCase(course))
            .collect(Collectors.toList());
    }

    public List<Enrollment> filterByCourseCategory(String category){
        return enroll.stream()
            .filter(e->e.getCourseCategory().equalsIgnoreCase(category))
            .collect(Collectors.toList());
    }

    public Map<String,Long> groupByCourseName(){
        return enroll.stream()
            .collect(Collectors.groupingBy(e->e.getCourseName(),Collectors.counting()));
    }

    public Map<String,Long> countByCategory(){
        return enroll.stream()
            .collect(Collectors.groupingBy(Enrollment::getCourseCategory,Collectors.counting()));
    }

    public List<Enrollment> sortByDate(){
        return enroll.stream()
            .sorted(Comparator.comparing(e->e.getEnrollmentDate()))
            .collect(Collectors.toList());
    }
}
