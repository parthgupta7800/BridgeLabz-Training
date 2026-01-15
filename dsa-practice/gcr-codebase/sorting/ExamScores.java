import java.util.*;
public class ExamScores {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of exam scores to be sorted");
        int n=ob.nextInt();
        int scores[]=new int[n];
        System.out.println("Enter the exam scores:");
        for(int i=0;i<n;i++){
            scores[i]=ob.nextInt();
        }
        sortScores(scores);
    }
    public static void sortScores(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
