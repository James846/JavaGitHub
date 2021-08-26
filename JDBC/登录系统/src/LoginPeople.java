import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginPeople extends ConnectDatabase{
    public Information loginPeople(Information information){
        connectDatabase();
        Information result = new Information();
        PreparedStatement sql;
        ResultSet rs;
        String str="select ID,Password from information where ID=? and Password=?";
        try{
            sql=con.prepareStatement(str);
            sql.setString(1,information.getId());
            sql.setString(2,information.getPassword());
            rs=sql.executeQuery();
            result.setLogin(rs.next());
            sql.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}