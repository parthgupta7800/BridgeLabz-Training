import java.util.*;
import java.time.*;
public class Enrollment {
    private String student_name;
    private String course_name;
    private String course_category;
    private LocalDate enrollment_date;

    public Enrollment(String student_name,String course_name,String course_category,LocalDate enrollment_date) {
        this.student_name=student_name;
        this.course_category=course_category;
        this.course_name=course_name;
        this.enrollment_date=enrollment_date;
    }

    public String getStudentName(){
        return student_name;
    }
    public String getCourseName(){
        return course_name;
    }
    public String getCourseCategory(){
        return course_category;
    }
    public LocalDate getEnrollmentDate(){
        return enrollment_date;
    }
    @Override
    public String toString(){
        return student_name+" "+course_name+" "+course_category+" "+enrollment_date;
    }
}
