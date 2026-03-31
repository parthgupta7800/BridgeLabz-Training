import java.util.*;
class DuplicateVoteException extends Exception{
    DuplicateVoteException(String message){
        super(message);
    }
}
interface ElectionService{
    void registerCandidate(String name,String party);
    void registerVoter(String name,String voterId);
    void castVote(String voterId,String candidate)throws DuplicateVoteException;
    void showResults();
}
class Candidate{
    String candidateName;
    String partyName;
    Candidate(String candidateName,String partyName){
        this.candidateName=candidateName;
        this.partyName=partyName;
    }
}
class Voter{
    String voterName;
    String voterID;
    boolean hasVoted=false;
    Voter(String voterName,String voterID){
        this.voterName=voterName;
        this.voterID=voterID;
    }
}
class Vote{
    String voterID;
    String candidateName;

    Vote(String voterID,String candidateName){
        this.voterID=voterID;
        this.candidateName=candidateName;
    }
}
class Election implements ElectionService{
    ArrayList<Candidate> candidates=new ArrayList<>();
    ArrayList<Voter> voters=new ArrayList<>();
    ArrayList<Vote> votes=new ArrayList<>();
    public void registerCandidate(String name,String party){
        candidates.add(new Candidate(name,party));
        System.out.println("Candidate registered");
    }
    public void registerVoter(String name,String voterId){
        voters.add(new Voter(name,voterId));
        System.out.println("Voter registered");
    }
    public void castVote(String voterId,String candidate)throws DuplicateVoteException{
        Voter voter=null;
        for(Voter v:voters){
            if(v.voterID.equals(voterId)){
                voter=v;
                break;
            }
        }
        if(voter==null){
            System.out.println("Voter not found");
            return;
        }
        if(voter.hasVoted){
            throw new DuplicateVoteException("Voter has already voted");
        }
        boolean candidateFound=false;
        for(Candidate c:candidates){
            if(c.candidateName.equals(candidate)){
                candidateFound=true;
                break;
            }
        }
        if(!candidateFound){
            System.out.println("Candidate not found");
            return;
        }
        votes.add(new Vote(voterId,candidate));
        voter.hasVoted=true;
        System.out.println("Vote cast successfully");
    }
    public void showResults(){
        if(votes.isEmpty()){
            System.out.println("No votes cast yet");
            return;
        }
        for(Candidate c:candidates){
            int count=0;
            for(Vote v:votes){
                if(v.candidateName.equals(c.candidateName)){
                    count++;
                }
            }
            System.out.println("Candidate:"+c.candidateName+" Votes:"+count);
        }
    }
}
public class VotingSystem{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        Election election=new Election();
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to register candidate");
            System.out.println("Enter 2 to register voter");
            System.out.println("Enter 3 to cast vote");
            System.out.println("Enter 4 to view results");
            System.out.println("Enter 0 to exit");
            int choice=ob.nextInt();
            ob.nextLine();
            try{
                switch(choice){
                    case 1:
                        System.out.println("Enter candidate name:");
                        String cname=ob.nextLine();
                        System.out.println("Enter party name:");
                        String party=ob.nextLine();
                        election.registerCandidate(cname,party);
                        break;
                    case 2:
                        System.out.println("Enter voter name:");
                        String vname=ob.nextLine();
                        System.out.println("Enter voter ID:");
                        String vid=ob.nextLine();
                        election.registerVoter(vname,vid);
                        break;
                    case 3:
                        System.out.println("Enter voter ID:");
                        String voteId=ob.nextLine();
                        System.out.println("Enter candidate name:");
                        String cand=ob.nextLine();
                        election.castVote(voteId,cand);
                        break;
                    case 4:
                        election.showResults();
                        break;
                    case 0:
                        loop=false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }catch(DuplicateVoteException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
