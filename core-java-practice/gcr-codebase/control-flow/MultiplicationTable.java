import java.util.*;
public class MultiplicationTable {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int number=ob.nextInt();
        for(int i=6;i<=9;i++)
        {
            System.out.println(number+" * "+i+" = "+(number*i));
        }
    }
}
