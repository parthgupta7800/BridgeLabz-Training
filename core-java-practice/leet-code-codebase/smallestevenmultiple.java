

import java.util.Scanner;

public class smallestevenmultiple {
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		int n=ob.nextInt();
		if(n%2!=0)
		System.out.println(n*2);
        else System.out.println(n);
	}

}
