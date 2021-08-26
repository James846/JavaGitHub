package ADboard.Model;
import java.sql.*;

public class QueryOneUserAD extends ConnectDatabase{//�����ѯĳ�û��Ĺ��
   Login login;
   public void setLogin(Login login){
      this.login = login;
   }
   public Advertisement[] queryOneUser(String id) { 
      connectDatabase();
      if(con == null || login== null) return null;
      if(!login.getLoginSuccess()) return null;
      Advertisement [] ad  = null;
      Statement sql; 
      ResultSet rs;
      try { 
         sql=con.createStatement
         (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=sql.executeQuery
        ("select * from guanggao where id = '"+id+"'");
        rs.last(); 
        int recordAmount =rs.getRow();//������е�ȫ����¼
        ad = new Advertisement[recordAmount];
        for(int i=0;i<ad.length;i++){
          ad[i] = new Advertisement();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next()) { 
          ad[i].setID(id);
          ad[i].setContent(rs.getString("content"));
          ad[i].setContactInformation(rs.getString("contact"));
          String number=rs.getString("serialNumber");
          int index = id.length();    //�ҵ�id������λ��
          number = number.substring(index);
          ad[i].setSerialNumber(number);
          i++;
        }
        con.close();
      }
      catch(Exception e){}
      return ad;
   }   
}
