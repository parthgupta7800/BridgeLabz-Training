import org.json.JSONArray;
import org.json.JSONObject;
class Student{
    String name;
    int age;
    String[] subjects;
    Student(String name,int age,String[] subjects){
        this.name=name;
        this.age=age;
        this.subjects=subjects;
    }
}
public class StudentJSON{
    public static void main(String[] args){
        String[] subjects={"Maths","Physics","Computer Science"};
        Student student=new Student("Parth",22,subjects);
        JSONArray subjectArray=new JSONArray();
        for(String s:student.subjects){
            subjectArray.put(s);
        }
        JSONObject json=new JSONObject();
        json.put("name",student.name);
        json.put("age",student.age);
        json.put("subjects",subjectArray);
        System.out.println(json.toString(4));
    }
}
