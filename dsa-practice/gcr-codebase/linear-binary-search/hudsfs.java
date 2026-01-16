import java.util.*;
public class FirstNegativeSearch {
    public static int findFirstNegative(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        int index=findFirstNegative(arr);
        if(index==-1){
            System.out.println("-1");
        }else{
            System.out.println("First negative number found at index: "+index);
            System.out.println("Value: "+arr[index]);
        }
    }
}
