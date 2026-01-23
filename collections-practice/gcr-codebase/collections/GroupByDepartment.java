import java.util.*;
class Employee {
    String name;
    String department;
    Employee(String name,String department){
        this.name=name;
        this.department=department;
    }
}
public class GroupByDepartment {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,List<Employee>> map=new HashMap<>();
        System.out.print("Enter number of employees: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter employee name: ");
            String name=sc.nextLine();
            System.out.print("Enter department: ");
            String dept=sc.nextLine();
            Employee emp=new Employee(name,dept);
            if(!map.containsKey(dept)){
                map.put(dept,new ArrayList<>());
            }
            map.get(dept).add(emp);
        }
        System.out.println("Employees Grouped by Department:");
        for(String dept:map.keySet()){
            System.out.print(dept+": ");
            List<Employee> list=map.get(dept);
            for(Employee e:list){
                System.out.print(e.name+" ");
            }
            System.out.println();
        }
    }
}
