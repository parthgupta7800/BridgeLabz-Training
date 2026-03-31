import java.util.*;
public class NoOfHandshake {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        int handshake=(n*(n-1))/2;
        System.out.println("The number of possible hanshake is "+handshake);
    }
}
