class Patient{
    static String hospitalName="Apollo Hospital";
    static int totalPatients=0;
    final String patientID;
    String name;
    int age;
    String ailment;
    Patient(String patientID,String name,int age,String ailment){
        this.patientID=patientID;
        this.name=name;
        this.age=age;
        this.ailment=ailment;
        totalPatients++;
    }
    static void getTotalPatients(){
        System.out.println("Total Patients Admitted: "+totalPatients);
    }
    void display(Object obj){
        if(obj instanceof Patient){
            System.out.println("Hospital Name: "+hospitalName);
            System.out.println("Patient ID: "+patientID);
            System.out.println("Name: "+name);
            System.out.println("Age: "+age);
            System.out.println("Ailment: "+ailment);
        }
    }
    public static void main(String[] args){
        Patient p1=new Patient("P001","Rahul",30,"Flu");
        Patient p2=new Patient("P002","Rohit",45,"Fracture");
        getTotalPatients();
        p1.display(p1);
        p2.display(p2);
    }
}
