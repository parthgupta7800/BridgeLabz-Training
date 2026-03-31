import java.util.*;
public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[] salary=new double[10];
        double[] service=new double[10];
        double[] bonus=new double[10];
        double[] newSalary=new double[10];
        double totalBonus=0.0;
        double totalOldSalary=0.0;
        double totalNewSalary=0.0;
        for(int i=0;i<10;i++){
            double sal=sc.nextDouble();
            double yrs=sc.nextDouble();
            if(sal<=0||yrs<0){
                i--;
                continue;
            }
            salary[i]=sal;
            service[i]=yrs;
        }
        for(int i=0;i<10;i++){
            if(service[i]>5){
                bonus[i]=salary[i]*0.05;
            }else{
                bonus[i]=salary[i]*0.02;
            }
            newSalary[i]=salary[i]+bonus[i];
            totalBonus=totalBonus+bonus[i];
            totalOldSalary=totalOldSalary+salary[i];
            totalNewSalary=totalNewSalary+newSalary[i];
        }

        System.out.println("Total Bonus = "+totalBonus);
        System.out.println("Total Old Salary = "+totalOldSalary);
        System.out.println("Total New Salary = "+totalNewSalary);
    }
}
