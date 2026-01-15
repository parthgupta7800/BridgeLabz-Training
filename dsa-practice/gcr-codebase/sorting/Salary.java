import java.util.*;
public class Salary {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of job applicants:");
        int n=ob.nextInt();
        int salary[]=new int[n];
        System.out.println("Enter expected salary demands:");
        for(int i=0;i<n;i++){
            salary[i]=ob.nextInt();
        }
        buildMaxHeap(salary,n);
        for(int i=n-1;i>0;i--){
            int temp=salary[0];
            salary[0]=salary[i];
            salary[i]=temp;
            heapify(salary,i,0);
        }
        System.out.println("Sorted Salary Demands (Ascending):");
        for(int i=0;i<n;i++){
            System.out.print(salary[i]+" ");
        }
    }
    public static void buildMaxHeap(int arr[],int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    public static void heapify(int arr[],int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest])
            largest=left;
        if(right<n&&arr[right]>arr[largest])
            largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr,n,largest);
        }
    }
}
