import java.util.*;
public class FirstLast{
    public static int findFirst(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int result=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                result=mid;
                right=mid-1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    public static int findLast(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int result=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                result=mid;
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter sorted array elements:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        System.out.println("Enter target element:");
        int target=ob.nextInt();
        int first=findFirst(arr,target);
        int last=findLast(arr,target);
        if(first==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("First occurrence index: "+first);
            System.out.println("Last occurrence index: "+last);
        }
    }
}
