import JDBCTools.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AddStudents {
    public void addStudents()throws Exception{
        String sql="insert into examstudent values(?,?)";
    }
    public static <T> List<T> AddForStudents(Class<T> clazz, String SQL, Object... args)throws Exception{
        Connection conn= JDBCTools.getConnection();
        PreparedStatement ps= conn.prepareStatement(SQL);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        JDBCTools.CloseConnection(conn,ps);
        ArrayList<T> list=new ArrayList<T>();
        return list;
    }
}
