package Controller;

import JDBCTools.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudents {
    public static <T> void DeleteForStudents(String SQL, Object... args)throws Exception{
        Connection conn= JDBCTools.getConnection();
        PreparedStatement ps= conn.prepareStatement(SQL);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        if(ps.executeUpdate()>0){
            System.out.println("成功删除用户");
        }
        else{
            System.out.println("删除用户失败");
        }
        JDBCTools.CloseConnection(conn,ps);
    }
}
