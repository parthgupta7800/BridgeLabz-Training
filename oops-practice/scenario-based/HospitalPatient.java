import java.util.*;
interface IPayable{
    double calculateBill();
}
class Doctor{
    private String doctorName;
    private int id;
    private String department;
    Doctor(String doctorName,int id,String department){
        this.doctorName=doctorName;
        this.id=id;
        this.department=department;
    }
    void displayDoctor(){
        System.out.println("Doctor Name:"+doctorName);
        System.out.println("Doctor ID:"+id);
        System.out.println("Department:"+department);
    }
}
abstract class Patient{
    private static int counter=1;
    private int patientId;
    private String patientName;
    private int age;
    protected Doctor doctor;
    Patient(String patientName,int age,Doctor doctor){
        this.patientId=counter++;
        this.patientName=patientName;
        this.age=age;
        this.doctor=doctor;
    }
    public int getPatientId(){
        return patientId;
    }
    public String getPatientName(){
        return patientName;
    }
    public int getAge(){
        return age;
    }
    abstract void displayInfo();
}
class InPatient extends Patient implements IPayable{
    private int admittedDays;
    private double dailyCharge;
    InPatient(String patientName,int age,Doctor doctor,int admittedDays,double dailyCharge){
        super(patientName,age,doctor);
        this.admittedDays=admittedDays;
        this.dailyCharge=dailyCharge;
    }
    public double calculateBill(){
        return admittedDays*dailyCharge;
    }
    void displayInfo(){
        System.out.println("In-Patient");
        System.out.println("Patient ID:"+getPatientId());
        System.out.println("Patient Name:"+getPatientName());
        System.out.println("Age:"+getAge());
        doctor.displayDoctor();
        System.out.println("Total Bill:"+calculateBill());
    }
}
class OutPatient extends Patient implements IPayable{
    private double consultationFee;
    OutPatient(String patientName,int age,Doctor doctor,double consultationFee){
        super(patientName,age,doctor);
        this.consultationFee=consultationFee;
    }
    public double calculateBill(){
        return consultationFee;
    }
    void displayInfo(){
        System.out.println("Out-Patient");
        System.out.println("Patient ID:"+getPatientId());
        System.out.println("Patient Name:"+getPatientName());
        System.out.println("Age:"+getAge());
        doctor.displayDoctor();
        System.out.println("Total Bill:"+calculateBill());
    }
}
class Hospital{
    ArrayList<Patient> patients=new ArrayList<>();
    void addPatient(Patient p){
        patients.add(p);
        System.out.println("Patient registered successfully");
    }
    void displayPatients(){
        if(patients.isEmpty()){
            System.out.println("No patients available");
            return;
        }
        for(Patient p:patients){
            p.displayInfo();
        }
    }
    void deletePatient(int id){
        Iterator<Patient> it=patients.iterator();
        while(it.hasNext()){
            Patient p=it.next();
            if(p.getPatientId()==id){
                it.remove();
                System.out.println("Patient discharged");
                return;
            }
        }
        System.out.println("Patient not found");
    }
}
public class HospitalPatient{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        Hospital hospital=new Hospital();
        Doctor d1=new Doctor("Dr.Sharma",101,"Cardiology");
        Doctor d2=new Doctor("Dr.Mehta",102,"Orthopedic");
        boolean loop=true;
        while(loop){
            System.out.println("1.Register In-Patient");
            System.out.println("2.Register Out-Patient");
            System.out.println("3.Display Patients");
            System.out.println("4.Discharge Patient");
            System.out.println("0.Exit");
            int choice=ob.nextInt();
            switch(choice){
                case 1:
                    ob.nextLine();
                    System.out.println("Enter patient name");
                    String inName=ob.nextLine();
                    System.out.println("Enter age");
                    int inAge=ob.nextInt();
                    System.out.println("Enter admitted days");
                    int days=ob.nextInt();
                    hospital.addPatient(new InPatient(inName,inAge,d1,days,1500));
                    break;
                case 2:
                    ob.nextLine();
                    System.out.println("Enter patient name");
                    String outName=ob.nextLine();
                    System.out.println("Enter age");
                    int outAge=ob.nextInt();
                    hospital.addPatient(new OutPatient(outName,outAge,d2,800));
                    break;
                case 3:
                    hospital.displayPatients();
                    break;
                case 4:
                    System.out.println("Enter patient ID");
                    hospital.deletePatient(ob.nextInt());
                    break;
                case 0:
                    loop=false;
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
