import java.sql.PreparedStatement;

public class DeletePeople extends ConnectDatabase{
    int result=0;
    public int deletepeople(Information information){
        connectDatabase();
        PreparedStatement presql;
        String str="delete from information where ID=?";
        try{
            presql= con.prepareStatement(str);
            presql.setString(1,information.getId());
            result= presql.executeUpdate();
            con.close();
            presql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
