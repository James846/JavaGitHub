package ADboard.Model;
import java.sql.*;
public class HandleRegister extends ConnectDatabase {
   public boolean handleRegister(Register register){
      connectDatabase();
      boolean isSuccess = false;
      if(con == null) return false;
      PreparedStatement preSql; 
      String sqlStr ="insert into register values(?,?)";
      int ok=0;
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,register.getID());
          String pw = register.getPassword();
          pw = Encode.encrypt(pw,"mima");//把用户密码加密
          preSql.setString(2,pw);  
          ok = preSql.executeUpdate();
          con.close();
      }
      catch(SQLException e) {}
      if(ok!=0) {
         isSuccess = true;
      }
      return isSuccess;
   }
}
