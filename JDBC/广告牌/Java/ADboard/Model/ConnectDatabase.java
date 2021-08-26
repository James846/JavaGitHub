package ADboard.Model;
import java.sql.*;
import java.io.*;
public class ConnectDatabase{
   public static String uri="";
   static {
     try{
            File fRead = new File("Java/ip/IP.txt");
            Reader in = new FileReader(fRead);
            BufferedReader bufferRead =new BufferedReader(in);
            uri=bufferRead.readLine();
            System.out.println(uri);//输入输出流显示链接的数据库
      }
      catch(IOException exp){
          System.out.println("不要删除IP文件"+exp);
      }
   }
   Connection con;
   public final void connectDatabase() {
      try{
          Class.forName("com.mysql.jdbc.Driver");//加载JDBC-MySQL驱动
      }
      catch(Exception e){
          System.out.println("未加载驱动");
      }
      try{  
         con =DriverManager.getConnection("jdbc:mysql://localhost:3306/advertisement","root","jimmy1016"); //连接代码
      }
      catch(SQLException e){
          System.out.println("链接数据库错误");
      }
   }
}