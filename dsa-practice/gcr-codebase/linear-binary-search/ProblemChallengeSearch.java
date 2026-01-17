import java.util.*;
public class ProblemChallengeSearch {
    public static int findFirstMissingPositive(int arr[]){
        int n=arr.length;
        boolean present[]=new boolean[n+1];
        for(int i=0;i<n;i++){
            if(arr[i]>0&&arr[i]<=n){
                present[arr[i]]=true;
            }
        }
        for(int i=1;i<=n;i++){
            if(!present[i]){
                return i;
            }
        }
        return n+1;
    }
    public static int binarySearch(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target<arr[mid]){
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
        int missing=findFirstMissingPositive(arr);
        System.out.println("First missing positive number: "+missing);
        Arrays.sort(arr);
        System.out.println("Enter target to search:");
        int target=ob.nextInt();
        int index=binarySearch(arr,target);
        if(index==-1){
            System.out.println("Target not found in array");
        }else{
            System.out.println("Target found at index (after sorting): "+index);
        }
    }
}
