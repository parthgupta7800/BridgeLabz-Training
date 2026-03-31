import java.util.*;
public class PeakElement {
    public static int findPeak(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if((mid==0||arr[mid]>arr[mid-1])&&(mid==arr.length-1||arr[mid]>arr[mid+1])){
                return mid;
            }else if(arr[mid]<arr[mid-1]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        int index=findPeak(arr);
        if(index==-1){
            System.out.println("No peak element found");
        }else{
            System.out.println("Peak value: "+arr[index]);
        }
    }
}
