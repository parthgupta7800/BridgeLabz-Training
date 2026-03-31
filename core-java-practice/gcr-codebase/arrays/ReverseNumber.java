import java.util.*;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int temp=number;
        int count=0;
        while(temp!=0){
            count++;
            temp=temp/10;
        }
        int[] digits=new int[count];
        int index=0;
        while(number!=0){
            digits[index]=number%10;
            number=number/10;
            index++;
        }
        int[] reverse=new int[count];
        int revIndex=0;
        for(int i=digits.length-1;i>=0;i--){
            reverse[revIndex]=digits[i];
            revIndex++;
        }
        for(int i=0;i<reverse.length;i++){
            System.out.print(reverse[i]);
        }
    }
}
