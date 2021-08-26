package ADboard.Model;
import java.sql.*;

public class QueryAllUserAD extends ConnectDatabase{//负责查询全部广告
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
        sql=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);// 结果集的游标可以上下移动，当数据库变化时，当前结果集不变。不能用结果集更新数据库中的表
        rs=sql.executeQuery("select * from guanggao");
        rs.last(); //获取下一条数据信息
        int recordAmount =rs.getRow();//结果集中的全部记录
        ad = new Advertisement[recordAmount];
        for(int i=0;i<ad.length;i++){
          ad[i] = new Advertisement();
        }
        rs.beforeFirst();// 把结果集的纪录指针移到第一条纪录的前面结果集被滚动到后面时,当你想重新读取结果集的数据时就调用这个！
           int i=0;
        while(rs.next()) { 
          String id = rs.getString(1);
          ad[i].setID(id);
          ad[i].setContent(rs.getString(2));
          ad[i].setContactInformation(rs.getString(4));
          String number=rs.getString(3);
          int index = id.length();    //找到id结束的位置
          number = number.substring(index);//从广告序列号字符串中一个一个提取字符
          ad[i].setSerialNumber(number);//一个一个字符地读入广告序列号
          i++;
        }
        con.close();
      }
      catch(Exception e){}
      return ad;
   }    
}
