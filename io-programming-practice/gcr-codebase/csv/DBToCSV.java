import java.io.*;
import java.sql.*;

public class DBToCSV {
    public static void main(String[] args)throws Exception{
        String url="jdbc:mysql://localhost:3306/company";
        String user="root";
        String pass="root";
        Connection con=DriverManager.getConnection(url,user,pass);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employees");
        BufferedWriter bw=new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("ID,Name,Department,Salary\n");
        while(rs.next()){
            bw.write(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("department")+","+rs.getDouble("salary")+"\n");
        }
        bw.close();
        con.close();
        System.out.println("CSV Created Successfully");
    }
}
