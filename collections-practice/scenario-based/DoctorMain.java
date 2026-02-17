import java.util.*;

class SlotUnavailableException extends RuntimeException{
    public SlotUnavailableException(String msg){
        super(msg);
    }
}

class Doctor{
    String name;
    String specialization;
    Set<String>bookedSlots=new HashSet<>();

    Doctor(String name,String specialization){
        this.name=name;
        this.specialization=specialization;
    }
}

class Appointment{
    String patientName;
    Doctor doctor;
    String slot;

    Appointment(String patientName,Doctor doctor,String slot){
        this.patientName=patientName;
        this.doctor=doctor;
        this.slot=slot;
    }
}

class ConsultationScheduler{

    Map<String,List<Doctor>>doctorMap=new HashMap<>();
    List<Appointment>history=new ArrayList<>();

    public void addDoctor(Doctor d){
        doctorMap.computeIfAbsent(d.specialization,k->new ArrayList<>()).add(d);
    }

    public void bookAppointment(String specialization,String patient,String slot){
        List<Doctor>list=doctorMap.get(specialization);

        if(list==null) return;

        for(Doctor d:list){
            if(!d.bookedSlots.contains(slot)){
                d.bookedSlots.add(slot);
                history.add(new Appointment(patient,d,slot));
                System.out.println("Booked with Dr."+d.name+" at "+slot);
                return;
            }
        }
        throw new SlotUnavailableException("No slot available");
    }

    public void showHistory(){
        for(Appointment a:history){
            System.out.println(a.patientName+" consulted "+a.doctor.name+" at "+a.slot);
        }
    }
}

public class DoctorMain{
    public static void main(String[] args){
        ConsultationScheduler s=new ConsultationScheduler();

        s.addDoctor(new Doctor("Amit","Cardio"));
        s.addDoctor(new Doctor("Riya","Cardio"));

        s.bookAppointment("Cardio","Rahul","10AM");
        s.bookAppointment("Cardio","Neha","10AM");

        s.showHistory();
    }
}