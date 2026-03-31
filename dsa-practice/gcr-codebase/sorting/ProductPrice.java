import java.util.*;
public class ProductPrice {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of products whose prices need to be sorted");
        int n=ob.nextInt();
        double prices[]=new double[n];
        System.out.println("Enter the prices of the products:");
        for(int i=0;i<n;i++){
            prices[i]=ob.nextDouble();
        }
        int low=0,high=prices.length-1;
        sortPrices(prices,low,high);
        System.out.println("Product prices in sorted order:");
        for(int i=0;i<n;i++){
            System.out.print(prices[i]+" ");
        }
    }
    public static void sortPrices(double arr[],int low,int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            sortPrices(arr, low, pi - 1);
            sortPrices(arr, pi + 1, high);
        }
    }
    public static int partition(double arr[], int low, int high) {
        double pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
