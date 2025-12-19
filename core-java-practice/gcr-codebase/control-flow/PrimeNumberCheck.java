import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        boolean flag=true;
        if(number<=1){
            flag=false;
        }else{
            for(int i=2;i<number;i++){
                if(number%i==0){
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(number+" is a Prime Number");
        }else{
            System.out.println(number+" is not a Prime Number");
        }
    }
}
