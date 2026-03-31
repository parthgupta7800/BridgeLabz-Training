import java.util.*;
public class BMIFitnessTracker {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the height");
        double height=ob.nextDouble();
        System.out.println("Enter the weight");
        double weight=ob.nextDouble();
        double  bmi = weight / (height * height);
        if(bmi<18.5)
            System.out.println("You are Underweight");
        if(bmi>=18.5&&bmi<=24.9)
            System.out.println("You are Normal");
        if(bmi>=25.0&&bmi<=29.9)
            System.out.println("You are OverWeight");
        if(bmi>=30.0)
            System.out.println("You are Obese");
    }    
}
