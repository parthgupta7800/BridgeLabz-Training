class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    Employee(int employeeID, String department, double salary) {
        this.employeeID=employeeID;
        this.department=department;
        this.salary=salary;
    }
    public void setSalary(double salary) {
        this.salary=salary;
    }
    public double getSalary() {
        return salary;
    }
}
class Manager extends Employee {
    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    void displayEmployeeDetails() {
        System.out.println("Employee ID: "+employeeID); 
        System.out.println("Department: "+department); 
        System.out.println("Salary: "+getSalary()); 
    }
}
public class EmployeeRecords {
    public static void main(String[] args) {
        Manager manager =new Manager(101, "IT", 60000);
        manager.displayEmployeeDetails();
        manager.setSalary(70000);
        System.out.println("Updated Salary: "+manager.getSalary());
    }
}
