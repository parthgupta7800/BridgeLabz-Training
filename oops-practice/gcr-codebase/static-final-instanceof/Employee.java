class Employee{
    static String companyName="Capgemini";
    static int totalEmployees=0;
    final int id;
    String name;
    String designation;
    Employee(int id,String name,String designation){
        this.id=id;
        this.name=name;
        this.designation=designation;
        totalEmployees++;
    }
    static void displayTotalEmployees(){
        System.out.println("Total Employees: "+totalEmployees);
    }
    void display(Object obj){
        if(obj instanceof Employee){
            System.out.println("Company Name: "+companyName);
            System.out.println("Employee ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Designation: "+designation);
        }
    }
    public static void main(String[] args){
        Employee e1=new Employee(101,"Parth","Software Engineer");
        Employee e2=new Employee(102,"Aman","Project Manager");
        displayTotalEmployees();
        e1.display(e1);
        e2.display(e2);
    }
}
