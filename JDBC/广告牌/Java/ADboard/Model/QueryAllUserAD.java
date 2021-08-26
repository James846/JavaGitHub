package ADboard.Model;
import java.sql.*;

public class QueryAllUserAD extends ConnectDatabase{//�����ѯȫ�����
   Login login;
   public void setLogin(Login login){
      this.login = login;
   }
   public Advertisement[] queryAllUser() { 
      connectDatabase();
      if(con == null || login== null) return null;
      if(!login.getLoginSuccess()) return null;
      Advertisement [] ad  = null;
      Statement sql; 
      ResultSet rs;
      try { 
        sql=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);// ��������α���������ƶ��������ݿ�仯ʱ����ǰ��������䡣�����ý�����������ݿ��еı�
        rs=sql.executeQuery("select * from guanggao");
        rs.last(); //��ȡ��һ��������Ϣ
        int recordAmount =rs.getRow();//������е�ȫ����¼
        ad = new Advertisement[recordAmount];
        for(int i=0;i<ad.length;i++){
          ad[i] = new Advertisement();
        }
        rs.beforeFirst();// �ѽ�����ļ�¼ָ���Ƶ���һ����¼��ǰ������������������ʱ,���������¶�ȡ�����������ʱ�͵��������
           int i=0;
        while(rs.next()) { 
          String id = rs.getString(1);
          ad[i].setID(id);
          ad[i].setContent(rs.getString(2));
          ad[i].setContactInformation(rs.getString(4));
          String number=rs.getString(3);
          int index = id.length();    //�ҵ�id������λ��
          number = number.substring(index);//�ӹ�����к��ַ�����һ��һ����ȡ�ַ�
          ad[i].setSerialNumber(number);//һ��һ���ַ��ض��������к�
          i++;
        }
        con.close();
      }
      catch(Exception e){}
      return ad;
   }    
}
