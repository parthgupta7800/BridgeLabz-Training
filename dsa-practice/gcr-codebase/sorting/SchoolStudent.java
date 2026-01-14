import java.util.*;
public class SchoolStudent {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of students who's marks need to be sorted");
        int n=ob.nextInt();
        int marks[]=new int[n];
        System.out.println("Enter the marks of the students:");
        for(int i=0;i<n;i++){
            marks[i]=ob.nextInt();
        }
        sortMarks(marks);
        System.out.println("Marks of students in sorted order:");
        for(int i=0;i<n;i++){
            System.out.print(marks[i]+" ");
        }
    }
    public static int[] sortMarks(int marks[]){
        boolean swapped=false;
        for(int i=0;i<marks.length-1;i++){
            swapped=false;
            for(int j=0;j<marks.length-i-1;j++){
                if(marks[j]>marks[j+1]){
                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped==false)
            break;
        }
        return marks;
    }
}
