import java.util.*;

class LateSubmissionException extends RuntimeException{
    public LateSubmissionException(String message){
        super(message);
    }
}

class Participant{
    int participantId;
    String participantName;
    Map<Integer,Boolean>submit=new HashMap<>();
    Participant(int participant,String participantName,Map<Integer,Boolean>submit){
        this.participantId=participantId;
        this.participantName=participantName;
        this.submit=submit;
    }
}

class Submission{

    List<Participant>participants=new ArrayList<>();
    Map<Integer,Boolean>result=new HashMap<>(); 

    Submission(){
        result.put(1,true);
        result.put(2,false);
        result.put(3,true);
        result.put(4,true);
        result.put(5,false);
    }

    public int calculateScore(Participant p){
        int score=0;

        for(Map.Entry<Integer,Boolean>entry:result.entrySet()){
            int qId=entry.getKey();
            Boolean correctAns=entry.getValue();

            Boolean participantAns=p.submit.get(qId);

            if(participantAns!=null && participantAns.equals(correctAns)){
                score+=10;
            }
        }
        return score;
    }

    public void display(){

        participants.sort((a,b)->calculateScore(b)-calculateScore(a));

        System.out.println("Leaderboard:");
        for(Participant p:participants){
            System.out.println(p.participantName+" Score:"+calculateScore(p));
        }
    }
}


public class OnlineHackathon {
    public static void main(String args[]){
        Submission submission=new Submission();

        Map<Integer,Boolean>ans1=new HashMap<>();
        ans1.put(1,true);
        ans1.put(2,false);
        ans1.put(3,true);
        ans1.put(4,true);
        ans1.put(5,true);

        Map<Integer,Boolean>ans2=new HashMap<>();
        ans2.put(1,true);
        ans2.put(2,true);
        ans2.put(3,true);
        ans2.put(4,false);
        ans2.put(5,false);

        Participant p1=new Participant(1,"Aman",ans1);
        Participant p2=new Participant(2,"Riya",ans2);

        submission.participants.add(p1);
        submission.participants.add(p2);

        submission.display();
    }
}
