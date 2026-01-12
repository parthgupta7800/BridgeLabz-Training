import java.util.*;
class CourseLimitExceededException extends Exception{
    public CourseLimitExceededException(String message){
        super(message);
    }
}
interface RegistrationService{
    public void registerStudent(String name,String course) throws CourseLimitExceededException;
}
class Person{
    String name;
    int id;
    Person(int id,String name){
        this.id=id;
        this.name=name;
    }
}
class Student extends Person implements RegistrationService{
    private String studentName;
    private String grade;
    private ArrayList<String> courses=new ArrayList<>();
    int courseLimit=2;
    Student(int studentId,String studentName,String courseEnrolled,String grade){
        super(studentId,studentName);
        this.studentName=studentName;
        this.grade=grade;
    }
    
    public String getName(){
        return studentName;
    }
    public String getGrade(){
        return grade;
    }
    public void registerStudent(String name,String course) throws CourseLimitExceededException{
        if(courses.size()>=courseLimit){
            throw new CourseLimitExceededException("Course limit exceeded for student: "+name);
        }
        if(courses.contains(course)){
            System.out.println("Already enrolled in this course");
            return;
        }
        courses.add(course);
        System.out.println("Student "+name+" registered for course: "+course);
    }
    void displayDetails(){
        System.out.println("Student ID: "+id);
        System.out.println("Student Name: "+studentName);
        System.out.println("Course Enrolled: "+courses);
        System.out.println("Grade: "+grade);
    }
    void dropCourse(String name,String course){
        if(courses.contains(course)){
            courses.remove(course);
            System.out.println("Student "+name+" dropped course: "+course);
        }else{
            System.out.println("Student "+name+" is not enrolled in course: "+course);
        }
    }
}
public class StudentCourse {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);  
        ArrayList<Student> students=new ArrayList<>(); 
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to show available courses");
            System.out.println("Enter 2 to register a student in a course");
            System.out.println("Enter 3 to to drop a course for a student");
            System.out.println("Enter 4 to display student details");
            System.out.println("Enter 0 to exit");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Available Courses:");
                    System.out.println("GenAI");
                    System.out.println("MERN Stack");
                    System.out.println("Java");
                    break;
                case 2:
                    System.out.println("Enter Student Name:");
                    String name=ob.nextLine();
                    System.out.println("Enter Course to Enroll (GenAI/MERN Stack/Java):");
                    String course=ob.nextLine();
                    System.out.println("Enter the grade");
                    String grade=ob.nextLine();
                    Student existingStudent=null;
                    for(Student st:students){
                        if(st.getName().equals(name)){
                            existingStudent=st;
                            break;
                        }
                    }
                    try{
                        if(existingStudent!=null){
                            existingStudent.registerStudent(name,course);
                        }else{
                            Student s=new Student(students.size()+1,name,course,grade);
                            s.registerStudent(name,course);
                            students.add(s);
                        }
                    }catch(CourseLimitExceededException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter Student Name:");
                    String studentName=ob.nextLine();
                    System.out.println("Enter Course to Drop:");
                    String courseToDrop=ob.nextLine();
                    for(Student st:students){
                        if(st.getName().equals(studentName)){
                            st.dropCourse(studentName,courseToDrop);
                        }
                    }
                    break;
                case 4:
                    for(Student st:students){
                        st.displayDetails();
                    }
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
