package Insert;

import JDBCTools.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
    public static void main(String[] args)throws Exception{
        testInsert();
    }
    public static void testInsert()throws Exception{
        Long start=System.currentTimeMillis();
        Connection conn= JDBCTools.getConnection();
        String sql="insert into goods(name) values(?)";
        PreparedStatement ps= conn.prepareStatement(sql);
        for(int i=0;i<=200;i++){
            ps.setObject(1,"name "+i);
            ps.addBatch();
            if(i%100==0){
                ps.executeBatch();
                ps.clearBatch();
            }
            ps.execute();
        }
        Long end=System.currentTimeMillis();
        System.out.println("time: "+(end-start));
        JDBCTools.CloseConnection(conn,ps);

    }
}
