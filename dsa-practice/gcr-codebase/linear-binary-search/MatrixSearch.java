import java.util.*;
public class MatrixSearch {
    public static boolean searchMatrix(int matrix[][],int target){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0;
        int right=rows*cols-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/cols;
            int col=mid%cols;
            if(matrix[row][col]==target){
                return true;
            }else if(target<matrix[row][col]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int r=ob.nextInt();
        System.out.println("Enter number of columns:");
        int c=ob.nextInt();
        int matrix[][]=new int[r][c];
        System.out.println("Enter matrix elements row-wise:");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=ob.nextInt();
            }
        }
        System.out.println("Enter target value:");
        int target=ob.nextInt();
        boolean found=searchMatrix(matrix,target);
        if(found){
            System.out.println("Target found in matrix");
        }else{
            System.out.println("Target not found in matrix");
        }
    }
}
