import java.util.*;
class ExamTimeExpiredException extends Exception{
    ExamTimeExpiredException(String message){
        super(message);
    }
}
interface EvaluationStrategy{
    int evaluate(String answer,String correctAnswer);
}
class ObjectiveEvaluation implements EvaluationStrategy{
    public int evaluate(String answer,String correctAnswer){
        if(answer.equalsIgnoreCase(correctAnswer)){
            return 1;
        }
        return 0;
    }
}
class DescriptiveEvaluation implements EvaluationStrategy{
    public int evaluate(String answer,String correctAnswer){
        if(answer.length()>=correctAnswer.length()/2){
            return 1;
        }
        return 0;
    }
}
class Question{
    int questionId;
    String questionText;
    String correctAnswer;
    EvaluationStrategy strategy;
    Question(int questionId,String questionText,String correctAnswer,EvaluationStrategy strategy){
        this.questionId=questionId;
        this.questionText=questionText;
        this.correctAnswer=correctAnswer;
        this.strategy=strategy;
    }
    int evaluateAnswer(String answer){
        return strategy.evaluate(answer,correctAnswer);
    }
    void displayQuestion(){
        System.out.println("Q"+questionId+": "+questionText);
    }
}
class Student{
    int studentId;
    String name;
    ArrayList<String> answers=new ArrayList<>();
    Student(int studentId,String name){
        this.studentId=studentId;
        this.name=name;
    }
    void submitAnswer(String answer)throws ExamTimeExpiredException{
        if(answer==null||answer.length()==0){
            throw new ExamTimeExpiredException("Answer submission time expired");
        }
        answers.add(answer);
    }
}
class Exam{
    int examId;
    String examName;
    ArrayList<Question> questions=new ArrayList<>();
    ArrayList<Student> students=new ArrayList<>();
    Exam(int examId,String examName){
        this.examId=examId;
        this.examName=examName;
    }
    void addQuestion(Question q){
        questions.add(q);
    }
    void enrollStudent(Student s){
        students.add(s);
    }
    void conductExam()throws ExamTimeExpiredException{
        Scanner sc=new Scanner(System.in);
        for(Student s:students){
            System.out.println("Student:"+s.name);
            s.answers.clear();
            for(int i=0;i<questions.size();i++){
                questions.get(i).displayQuestion();
                String ans=sc.nextLine();
                s.submitAnswer(ans);
            }
        }
    }
    void generateResult(){
        for(Student s:students){
            int score=0;
            for(int i=0;i<questions.size();i++){
                score+=questions.get(i).evaluateAnswer(s.answers.get(i));
            }
            System.out.println("Student:"+s.name+" Score:"+score+"/"+questions.size());
        }
    }
}
public class OnlineExam{
    public static void main(String args[]){
        Exam exam=new Exam(1,"Java Online Test");
        exam.addQuestion(new Question(1,"What is JVM?","Java Virtual Machine",new DescriptiveEvaluation()));
        exam.addQuestion(new Question(2,"Java is platform independent? (yes/no)","yes",new ObjectiveEvaluation()));
        Student s1=new Student(101,"Parth");
        Student s2=new Student(102,"Amit");
        exam.enrollStudent(s1);
        exam.enrollStudent(s2);
        try{
            exam.conductExam();
        }catch(ExamTimeExpiredException e){
            System.out.println(e.getMessage());
        }
        exam.generateResult();
    }
}
