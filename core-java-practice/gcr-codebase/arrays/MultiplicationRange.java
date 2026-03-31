import java.util.*;
public class MultiplicationRange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int[] Result=new int[4];
        int index=0;
        for(int i=6;i<=9;i++){
            Result[index]=number*i;
            index++;
        }
        index=0;
        for(int i=6;i<=9;i++){
            System.out.println(number+" * "+i+" = "+Result[index]);
            index++;
        }
    }
}
