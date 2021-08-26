package ADboard.Model;
import java.sql.*;
public class HandleLogin extends ConnectDatabase {
   public Login handleLogin(Login login) {
      connectDatabase();
      PreparedStatement preSql;
      ResultSet rs; 
      if(con == null) {
         login.setLoginSuccess(false);
         return login;
      } 
      String id = login.getID();
      String pw = login.getPassword();
      String sqlStr ="select id,password from register where "+
                     "id = ? and password = ? ";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,id); 
          pw = Encode.encrypt(pw,"mima");//把用户密码加密
          preSql.setString(2,pw);  
          rs = preSql.executeQuery(); 
          if(rs.next()) { //检查是否是注册的用户
             login.setLoginSuccess(true);
          }
          else {
             login.setLoginSuccess(false);
          }
          con.close();
      }
      catch(SQLException e) {
          login.setLoginSuccess(false);
      }
      return login;
   }
} 
