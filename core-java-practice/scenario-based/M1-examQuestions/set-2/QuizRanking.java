import java.util.*;

class Student{

    String name;
    String department;
    int q1;
    int q2;
    int q3;

    public Student(String name,String department,int q1,int q2,int q3){
        this.name=name;
        this.department=department;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
    }

    public int getTotal(){
        return q1+q2+q3;
    }
}

public class QuizRanking{

    static List<Student> records=new ArrayList<>();

    public static void record(String name,String dept,int q1,int q2,int q3){

        records.add(new Student(name, dept, q1, q2, q3));
        System.out.println("Record Added: "+ name);

    }

    public static void topDepartment(String dept){
        if(records.isEmpty()){
            System.out.println("No Records Available");
            return;
        }
        int max=-1;
        for(Student student:records){
            if(student.department.equals(dept)){
                max=Math.max(max,student.getTotal());
            }
        }
        if(max==-1)System.out.println("Department not found");
        for(Student student:records){
            if(student.department.equals(dept)&&student.getTotal()==max){
                System.out.println(student.name+" "+max);
            }
        }

    }

    public static void topQuiz(String quiz){
        if(records.isEmpty()){
            System.out.println("No Records Available");
            return;
        }

        int max=-1;
        for(Student student:records){
            if(quiz.equals("Q1")){
                max=Math.max(max,student.q1);
            }
            if(quiz.equals("Q2")){
                max=Math.max(max,student.q2);
            }
            if(quiz.equals("Q3")){
                max=Math.max(max,student.q3);
            }
        }
        for(Student s:records){
            if(quiz.equals("Q1") && s.q1==max)
                System.out.println(s.name+" "+max);
            else if(quiz.equals("Q2") && s.q2==max)
                System.out.println(s.name+" "+max);
            else if(quiz.equals("Q3") && s.q3==max)
                System.out.println(s.name+" "+max);
        }
    }

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String line=sc.nextLine();
            String parts[]=line.split(" ");

            if(parts[0].equals("Record")){

                String name=parts[1];
                String dept=parts[2];
                int q1=Integer.parseInt(parts[3]);
                int q2=Integer.parseInt(parts[4]);
                int q3=Integer.parseInt(parts[5]);

                record(name,dept,q1,q2,q3);
            }

            else if(parts[0].equals("Top")){

                if(parts[1].startsWith("Q")){
                    topQuiz(parts[1]);
                }
                else{
                    topDepartment(parts[1]);
                }

            }
        }
    }
}