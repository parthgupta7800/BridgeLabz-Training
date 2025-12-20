import java.util.*;
public class GradePercentTwoDimension {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int students=sc.nextInt();
        int[][] marks=new int[students][3];
        double[] percentage=new double[students];
        char[] grade=new char[students];
        for(int i=0;i<students;i++){
            int physics=sc.nextInt();
            int chemistry=sc.nextInt();
            int maths=sc.nextInt();
            if(physics<0||chemistry<0||maths<0){
                i--;
                continue;
            }
            marks[i][0]=physics;
            marks[i][1]=chemistry;
            marks[i][2]=maths;
        }
        for(int i=0;i<students;i++){
            int total=marks[i][0]+marks[i][1]+marks[i][2];
            percentage[i]=total/3.0;
            if(percentage[i]>=80){
                grade[i]='A';
            }
            else if(percentage[i]>=70){
                grade[i]='B';
            }
            else if(percentage[i]>=60){
                grade[i]='C';
            }
            else if(percentage[i]>=50){
                grade[i]='D';
            }
            else if(percentage[i]>=40){
                grade[i]='E';
            }
            else{
                grade[i]='R';
            }
        }
        for(int i=0;i<students;i++){
            System.out.println("Physics = "+marks[i][0]+" Chemistry = "+marks[i][1]+" Maths = "+marks[i][2]+" Percentage = "+percentage[i]+" Grade = "+grade[i]);
        }
    }
}
