import java.sql.*;
import java.io.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class GenerateJSONReport{
    public static void main(String[]args){
        String url="jdbc:mysql://localhost:3306/training";
        String user="root";
        String password="root";

        String query="SELECT id,name,email,age FROM users";

        JSONArray reportArray=new JSONArray();

        try{
            Connection con=DriverManager.getConnection(url,user,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                JSONObject obj=new JSONObject();
                obj.put("id",rs.getInt("id"));
                obj.put("name",rs.getString("name"));
                obj.put("email",rs.getString("email"));
                obj.put("age",rs.getInt("age"));
                reportArray.put(obj);
            }

            FileWriter writer=new FileWriter("report.json");
            writer.write(reportArray.toString(4));
            writer.close();

            con.close();

            System.out.println("JSON Report Generated: report.json");

        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
