
import java.util.*;
public class digitsthatdividenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int num=ob.nextInt();
		int count=0;
        int temp=num;
        while(temp>0){
            int n=temp%10;
            if(num%n==0) count++;
            temp/=10;
        }
        System.out.println(count);
	}

}
