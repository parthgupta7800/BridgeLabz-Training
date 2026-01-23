import java.util.*;
class Patient {
    String name;
    int severity;
    Patient(String name,int severity){
        this.name=name;
        this.severity=severity;
    }
}
public class Hospital {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Patient> pq=new PriorityQueue<>(new Comparator<Patient>(){
            public int compare(Patient p1,Patient p2){
                return p2.severity-p1.severity;
            }
        });
        System.out.print("Enter number of patients: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter patient name: ");
            String name=sc.nextLine();
            System.out.print("Enter severity: ");
            int sev=sc.nextInt();
            sc.nextLine();
            pq.add(new Patient(name,sev));
        }
        System.out.println("Treatment Order:");
        while(!pq.isEmpty()){
            Patient p=pq.remove();
            System.out.println(p.name+" (Severity: "+p.severity+")");
        }
    }
}
