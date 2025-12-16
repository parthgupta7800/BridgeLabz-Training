

import java.util.*;
public class palindrome{
	public static void main(String args[]){
		Scanner ob=new Scanner(System.in);
		int n=ob.nextInt();
		if(check(n))
		System.out.println("It's a Palindrome");
		else
		System.out.println("It's not a Palindrome");
	}
	public static boolean check(int n) {
        	int d=0,temp=0,rev=0;
        	temp = n;
        	while (n > 0) {
            		d = n % 10;
            		rev = rev * 10 + d;
            		n = n / 10;
        	}
        	if (rev == temp)
                return true;
        	else
           	return false;
        
    	}
}
