import java.util.*;     
public class BookPrice {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n=ob.nextInt();
        int prices[]=new int[n];
        System.out.println("Enter the prices of the books:");
        for(int i=0;i<n;i++){
            prices[i]=ob.nextInt();
        }
        int left=0,right=prices.length-1;
        sortBookPrices(prices,left,right);
        System.out.println("Book prices in sorted order:");
        for(int i=0;i<n;i++){
            System.out.print(prices[i]+" ");
        }
    }
    public static void sortBookPrices(int prices[],int left,int right){
        
        if(left<right){
            int mid=left+(right-left)/2;
            sortBookPrices(prices,left,mid);
            sortBookPrices(prices,mid+1,right);
            merge(prices,left,mid,right);
        }
        
    }
    public static void merge(int prices[],int left,int mid,int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }
        while (i < n1) prices[k++] = leftArr[i++];
        while (j < n2) prices[k++] = rightArr[j++];
        
    }
}
