import java.util.*;
public class HandShakeMethod {
    public static void  main(String args[]){
        Scanner ob=new Scanner(System.in);
        HandShakeMethod obj=new HandShakeMethod();
        int n=ob.nextInt();
        int ans=obj.handshake(n);
        System.out.println(ans);
    }
    int handshake(int n){
        int no_of_handshake=(n*(n-1))/2;
        return no_of_handshake;
    }
}
