import java.util.*;
public class BmiCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double weight=sc.nextDouble();
        double heightCm=sc.nextDouble();
        double heightMeter=heightCm/100;
        double bmi=weight/(heightMeter*heightMeter);
        System.out.println("\nBMI: "+bmi);
        if(bmi<=18.4){
            System.out.println("Status: Underweight");
        }
        else if(bmi>=18.5&&bmi<=24.9){
            System.out.println("Status: Normal");
        }
        else if(bmi>=25.0&&bmi<=39.9){
            System.out.println("Status: Overweight");
        }
        else{
            System.out.println("Status: Obese");
        }
    }
}
