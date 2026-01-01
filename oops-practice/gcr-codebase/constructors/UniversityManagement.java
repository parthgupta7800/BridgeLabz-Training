class Student {
    public String rollNumber;
    protected String name;
    private double cgpa;
    Student(String rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }
    public double getCGPA() {
        return cgpa;
    }
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
}
class PostgraduateStudent extends Student {
    PostgraduateStudent(String rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }
    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber); 
        System.out.println("Name: " + name);  
        System.out.println("CGPA: " + getCGPA());
    }
}
public class UniversityManagement {
    public static void main(String[] args) {
        PostgraduateStudent pg =new PostgraduateStudent("39", "Parth", 8.5);
        pg.displayDetails();
        pg.setCGPA(8.9);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
