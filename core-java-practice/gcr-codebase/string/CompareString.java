import java.util.*;
public class CompareString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		System.out.println("Enter the first String");
		String str1=ob.next();
		System.out.println("Enter the second String");
		String str2=ob.next();
		if(str1.length()!=str2.length())
		{
			System.out.println("String is not same");
			return ;
		}
		boolean flag=true;
		for(int i=0;i<str1.length();i++) 
		{
			if(str1.charAt(i)!=str2.charAt(i))
			{
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("String is same");
		else
			System.out.println("String is not same");
	}

}
