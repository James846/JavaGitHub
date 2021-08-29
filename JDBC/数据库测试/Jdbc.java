package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/regist","root","********");
        String sql="INSERT INTO register VALUES('123','123456')";
        Statement sta=conn.createStatement();
        boolean count=sta.execute(sql);
        System.out.println(count);
        sta.close();
        conn.close();
    }
}
