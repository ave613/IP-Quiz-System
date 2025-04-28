package Project;
//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.*;
public class ConnectionProvider {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/quiz","root","");
            return con;
        }
        catch(Exception e){
            return null;
        }
    }
}

