import java.util.*;

class ShiftAlreadyAssignedException extends Exception{
    public ShiftAlreadyAssignedException(String message){
        super(message);
    }
}

class Employee{
    int employeeId;
    String employeeName;
    public Employee(int employeeId,String employeeName) {
        this.employeeId=employeeId;
        this.employeeName=employeeName;
    }
}

class AssignShifts{
    ArrayList<Employee> employees=new ArrayList<>();
    HashMap<String, List<Employee>>map=new HashMap<>();
    public AssignShifts(){
        map.put("Day",new ArrayList<>());
        map.put("Night",new ArrayList<>());
    }
    public void addEmployee(Employee e){
        employees.add(e);
    }
    public void shiftAssign(Employee e,String shift)throws ShiftAlreadyAssignedException{
        for(List<Employee> list:map.values()){
            if(list.contains(e)){
                throw new ShiftAlreadyAssignedException("Employee already assigned");
            }
        }
        map.get(shift).add(e);
    }
    public void printSchedule(){
        for(String s:map.keySet()){
            System.out.println(s+" -> "+map.get(s).size()+" employees");
        }
    }
}

public class CourierStaff {
    public static void main(String args[]){
        AssignShifts scheduler=new AssignShifts();

        Employee e1=new Employee(30,"Parth");
        Employee e2=new Employee(3,"Aryan");
        Employee e3=new Employee(29,"Mahima");

        scheduler.addEmployee(e1);
        scheduler.addEmployee(e2);
        scheduler.addEmployee(e3);

        try {
            scheduler.shiftAssign(e1,"Day");
            scheduler.shiftAssign(e2,"Night");
            scheduler.shiftAssign(e1,"Day");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scheduler.printSchedule();
    }
}
