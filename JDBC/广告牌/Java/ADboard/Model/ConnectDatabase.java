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
            System.out.println(uri);//�����������ʾ���ӵ����ݿ�
      }
      catch(IOException exp){
          System.out.println("��Ҫɾ��IP�ļ�"+exp);
      }
   }
   Connection con;
   public final void connectDatabase() {
      try{
          Class.forName("com.mysql.jdbc.Driver");//����JDBC-MySQL����
      }
      catch(Exception e){
          System.out.println("δ��������");
      }
      try{  
         con =DriverManager.getConnection("jdbc:mysql://localhost:3306/advertisement","root","jimmy1016"); //���Ӵ���
      }
      catch(SQLException e){
          System.out.println("�������ݿ����");
      }
   }
}