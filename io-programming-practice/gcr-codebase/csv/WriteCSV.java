import java.io.*;
public class WriteCSV {
    public static void main(String[] args)throws Exception{
        BufferedWriter bw=new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("ID,Name,Department,Salary\n");
        bw.write("1,Parth,IT,50000\n");
        bw.write("2,Amit,HR,40000\n");
        bw.write("3,Neha,IT,55000\n");
        bw.write("4,Ravi,Sales,45000\n");
        bw.write("5,Kiran,IT,60000\n");
        bw.close();
        System.out.println("CSV Created Successfully");
    }
}
