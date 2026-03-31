import java.util.*;;
public class BoothManager {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
        System.out.println("Welcome to Polling Booth System");
        System.out.println("There are 3 Candidate :\n 1)BJP\n2)Congress\n3)BSP");
        System.out.println("Enter 1 for BJP, 2 for Congress and 3 for BSP to vote");
        System.out.println("When no one is left to vote enter -1");
        int bjp=0,congress=0,bsp=0;
        boolean flag=true;
        while(flag){
            System.out.println("Enter the age");
            int age=ob.nextInt();
            if(age>=18){
                System.out.println("Enter the number to vote");
                int vote=ob.nextInt();
                if(vote==1||vote==2||vote==3){
                    if(vote==1)bjp++;
                    if(vote==2)congress++;
                    if(vote==3)bsp++;
                }
                else{
                    System.out.println("Enter the correct Candidate number");
                }
            }
            if(age==-1)flag=false;
            else{
                System.out.println("You are not eligible to vote");
            }
        }
        System.out.println("Let's display this result");
        System.out.println("BJP : "+bjp);
        System.out.println("Congress : "+congress);
        System.out.println("BSP : "+bsp);
    }
}
