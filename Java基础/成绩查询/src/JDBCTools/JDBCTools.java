package JDBCTools;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCTools {
    public static Connection getConnection()throws Exception{
        InputStream in=ClassLoader.getSystemClassLoader().getResourceAsStream("IP.txt");
        Properties prop=new Properties();
        prop.load(in);
        String user=prop.getProperty("user");
        String password=prop.getProperty("password");
        String url=prop.getProperty("url");
        String driverClass=prop.getProperty("driverClass");
        Class.forName(driverClass);
        Connection conn=DriverManager.getConnection(url,user,password);
        return conn;
    }
    public static void CloseConnection(Connection con, Statement ps){
        try{
            if(ps!=null){
                ps.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(con!=null){
                con.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
