package ADboard.Model;
import java.sql.*;
public class DeleteAD extends ConnectDatabase{//负责删除广告
   Login login;
   public void setLogin(Login login){//在登录界面下删除广告
      this.login = login;
   } 
   public boolean delAdvertisement(String serialNumber) {
      boolean success = false;
      connectDatabase();
      PreparedStatement preSql;
      if(con == null || login== null) return false;
      if(!login.getLoginSuccess()) return false;
      connectDatabase();
      String SQL ="delete from guanggao where serialNumber = ? ";
      try { 
          preSql  = con.prepareStatement(SQL);
          preSql.setString(1,login.getID()+serialNumber);
          int isOK =preSql.executeUpdate();
          if(isOK != 0)
             success =true;
          else
             success =false;
          con.close();
      }
      catch(SQLException e) {
          success =false; 
      }
      return success;
   }
}
