import java.util.*;
public class Employee {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int n=ob.nextInt();
        int employees[]=new int[n];
        System.out.println("Enter the employee IDs:");
        for(int i=0;i<n;i++){
            employees[i]=ob.nextInt();
        }
        sortEmployeeIDs(employees);
        System.out.println("Employee IDs in sorted order:");
        for(int i=0;i<n;i++){
            System.out.print(employees[i]+" ");
        }
    }
    public static int[] sortEmployeeIDs(int employees[]){
        for(int i=1;i<employees.length;i++){
            int key=employees[i];
            int j=i-1;
            while(j>=0 &&employees[j]>key){
                employees[j+1]=employees[j];
                j--;
            }
            employees[j+1]=key;
        }
        return employees;
    }
}
