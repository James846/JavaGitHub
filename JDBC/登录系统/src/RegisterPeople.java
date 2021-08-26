import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterPeople extends ConnectDatabase{
    int rs=0;
    public int registerPeople(Information information){
        connectDatabase();
        PreparedStatement presql;
        String str="insert into information values(?,?)";
        try{
            presql=con.prepareStatement(str);
            presql.setString(1,information.getId());
            presql.setString(2,information.getPassword());
            rs= presql.executeUpdate();
            presql.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

}
