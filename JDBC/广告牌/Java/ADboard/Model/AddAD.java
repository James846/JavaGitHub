package ADboard.Model;
import java.sql.*;

public class AddAD extends ConnectDatabase{//负责添加广告
   Login login;
   public void setLogin(Login login){
      this.login = login;
   } 
   public boolean addAdvertisement(Advertisement ad) { //返回值是布尔值 用以判断是否成功添加广告
      connectDatabase();
      if(con == null || login== null) return false;
      if(!login.getLoginSuccess()) return false;
      boolean success=false;
      PreparedStatement preSql;
      String sqlStr ="insert into guanggao values(?,?,?,?)";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,login.getID());     //设置第1个?代表的值
          preSql.setString(2,ad.content);//设置第2个?代表的值文本内容
          preSql.setString(3,login.getID()+ad.getSerialNumber());//设置第3个?代表的值序列号
          preSql.setString(4,ad.contact);
          int isOK = preSql.executeUpdate();
          if(isOK != 0)
             success =true;
          else
             success =false;  
          con.close();
      }
      catch(Exception e) {
          success = false; 
      }
      return success;
   }
}
