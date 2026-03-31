import java.util.*;
public class SmallestElement {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        System.out.println("Index of smallest element is: "+binarySearch(arr));
    }
    public static int binarySearch(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
            right=mid;
            }
        }   
    return left;
    }
}

    
