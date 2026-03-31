import java.util.*;
class InvalidMarkException extends Exception{
    InvalidMarkException(String message){
        super(message);
    }
}
class Student{
    String name;
    int[] marks;
    Student(String name,int[] marks){
        this.name=name;
        this.marks=marks;
    }
}
public class ReportCard{
    static void validateMarks(int[] marks)throws InvalidMarkException{
        for(int m:marks){
            if(m<0||m>100){
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
        }
    }
    static double calculateAverage(int[] marks){
        int sum=0;
        for(int m:marks){
            sum+=m;
        }
        return(double)sum/marks.length;
    }
    static char assignGrade(double avg){
        if(avg>=80)
            return 'A';
        else if(avg>=60)
            return 'B';
        else if(avg>=40)
            return 'C';
        else
            return 'F';
    }
    static void displayReport(Student s,String[] subjects){
        double avg=calculateAverage(s.marks);
        char grade=assignGrade(avg);
        System.out.println("Report Card");
        System.out.println("Student Name:"+s.name);
        for(int i=0;i<subjects.length;i++){
            System.out.println(subjects[i]+":"+s.marks[i]);
        }
        System.out.println("Average:"+avg);
        System.out.println("Grade:"+grade);
        System.out.println("---------------");
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        String[] subjects={"Maths","Science","English"};
        ArrayList<Student> students=new ArrayList<>();
        try{
            System.out.print("Enter number of students:");
            int n=ob.nextInt();
            for(int i=0;i<n;i++){
                ob.nextLine();
                System.out.print("Enter student name:");
                String name=ob.nextLine();
                int[] marks=new int[subjects.length];
                for(int j=0;j<subjects.length;j++){
                    System.out.print("Enter marks for "+subjects[j]+":");
                    marks[j]=ob.nextInt();
                }
                validateMarks(marks);
                students.add(new Student(name,marks));
            }
            for(Student s:students){
                displayReport(s,subjects);
            }
        }catch(InvalidMarkException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
