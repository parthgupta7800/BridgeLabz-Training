import java.util.*;
public class StudentAge {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n=ob.nextInt();
        int ages[]=new int[n];
        System.out.println("Enter student ages (10 to 18):");
        for(int i=0;i<n;i++){
            ages[i]=ob.nextInt();
        }
        int minAge=10;
        int maxAge=18;
        int range=maxAge-minAge+1;
        int count[]=new int[range];
        int output[]=new int[n];
        for(int i=0;i<n;i++){
            count[ages[i]-minAge]++;
        }
        for(int i=1;i<range;i++){
            count[i]=count[i]+count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            output[count[ages[i]-minAge]-1]=ages[i];
            count[ages[i]-minAge]--;
        }
        System.out.println("Sorted Student Ages:");
        for(int i=0;i<n;i++){
            System.out.print(output[i]+" ");
        }
    }
}
