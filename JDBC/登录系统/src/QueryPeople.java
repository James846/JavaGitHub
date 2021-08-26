import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryPeople extends ConnectDatabase{
    public Information queryPeople(Information information){
        connectDatabase();
        Information result=new Information();
        PreparedStatement ps;
        ResultSet rs;
        String str="select ID,Password from information where ID=?";
        try{
            ps=con.prepareStatement(str);
            ps.setString(1,information.getId());
            rs=ps.executeQuery();
            if(rs.next()){
                result.setQuery(true);
                String id=rs.getString(1);
                String password=rs.getString(2);
                result.setID(id);
                result.setPassword(password);
            }
            else{
                result.setQuery(false);
            }
            ps.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
