package ADboard.Model;
import java.sql.*;

public class AddAD extends ConnectDatabase{//������ӹ��
   Login login;
   public void setLogin(Login login){
      this.login = login;
   } 
   public boolean addAdvertisement(Advertisement ad) { //����ֵ�ǲ���ֵ �����ж��Ƿ�ɹ���ӹ��
      connectDatabase();
      if(con == null || login== null) return false;
      if(!login.getLoginSuccess()) return false;
      boolean success=false;
      PreparedStatement preSql;
      String sqlStr ="insert into guanggao values(?,?,?,?)";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,login.getID());     //���õ�1��?�����ֵ
          preSql.setString(2,ad.content);//���õ�2��?�����ֵ�ı�����
          preSql.setString(3,login.getID()+ad.getSerialNumber());//���õ�3��?�����ֵ���к�
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
