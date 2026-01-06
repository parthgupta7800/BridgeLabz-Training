import java.util.*;
class InvalidQuizSubmissionException extends Exception{
    InvalidQuizSubmissionException(String message){
        super(message);
    }
}
public class QuizResult{
    static int calculateScore(String[] correct,String[] user)throws InvalidQuizSubmissionException{
        if(correct.length!=user.length){
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }
        int score=0;
        for(int i=0;i<correct.length;i++){
            if(correct[i].equalsIgnoreCase(user[i])){
                score++;
            }
        }
        return score;
    }
    static char getGrade(int score,int total){
        double percent=(double)score/total*100;
        if(percent>=80)
            return 'A';
        else if(percent>=60)
            return 'B';
        else if(percent>=40)
            return 'C';
        else
            return 'F';
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        String[] correctAnswers={"A","B","C","D","A"};
        ArrayList<Integer> allScores=new ArrayList<>();
        try{
            System.out.print("Enter number of users:");
            int users=ob.nextInt();
            for(int u=1;u<=users;u++){
                System.out.println("User "+u+" answers:");
                String[] userAnswers=new String[correctAnswers.length];
                for(int i=0;i<correctAnswers.length;i++){
                    System.out.print("Q"+(i+1)+":");
                    userAnswers[i]=ob.nextLine();
                }
                int score=calculateScore(correctAnswers,userAnswers);
                allScores.add(score);
                char grade=getGrade(score,correctAnswers.length);
                System.out.println("Score:"+score+"/"+correctAnswers.length);
                System.out.println("Grade:"+grade);
            }
            System.out.println("All User Scores:"+allScores);
        }catch(InvalidQuizSubmissionException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
