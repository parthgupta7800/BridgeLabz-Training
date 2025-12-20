import java.util.Scanner;
public class BMIMultidimensional {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        double[][] person=new double[number][3];
        String[] weightStatus=new String[number];
        for(int i=0;i<number;i++){
            double weight=sc.nextDouble();
            double height=sc.nextDouble();
            if(weight<=0||height<=0){
                i--;
                continue;
            }
            person[i][0]=weight;
            person[i][1]=height;
        }
        for(int i=0;i<number;i++){
            person[i][2]=person[i][0]/(person[i][1]*person[i][1]);
            if(person[i][2]<=18.4){
                weightStatus[i]="Underweight";
            }else if(person[i][2]>=18.5&&person[i][2]<=24.9){
                weightStatus[i]="Normal";
            }else if(person[i][2]>=25.0&&person[i][2]<=39.9){
                weightStatus[i]="Overweight";
            }else{
                weightStatus[i]="Obese";
            }
        }
        for(int i=0;i<number;i++){
            System.out.println(
                "Height = "+person[i][1]+
                " Weight = "+person[i][0]+
                " BMI = "+person[i][2]+
                " Status = "+weightStatus[i]
            );
        }
    }
}
