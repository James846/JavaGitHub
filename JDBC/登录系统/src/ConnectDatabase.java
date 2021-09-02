import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    Connection con;
    public final void  connectDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/advertisement","newuser","");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
