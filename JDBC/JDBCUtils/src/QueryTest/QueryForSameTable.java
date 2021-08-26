package QueryTest;

import JDBCTools.JDBCTools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class QueryForSameTable {
    public static void main(String[] args) throws Exception {
        testQuery();
    }
    public static void testQuery() throws Exception {
        String sql="select ID,Password from information where ID=?";
        Information information=queryTest(sql,"吴天雄");
        System.out.println(information);
    }
    public static Information queryTest(String SQL, Object... args)throws Exception{
        //连接数据库，预处理SQL语句
        Connection conn=JDBCTools.getConnection();
        PreparedStatement ps=conn.prepareStatement(SQL);
        //填充通配符
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        //执行SQL语句
        ResultSet rs=ps.executeQuery();
        //获取结果集的元数据
        ResultSetMetaData rsmd=rs.getMetaData();
        //获取列数
        int getColumn= rsmd.getColumnCount();
        if(rs.next()){
            Information information=new Information();
            for(int i=0;i<getColumn;i++){
                //获取每个列的值：通过结果集
                Object columnValue=rs.getObject(i+1);
                //获取每个列的列名字：通过结果集的元数据
                String name=rsmd.getColumnLabel(i+1);
                Field field=Information.class.getDeclaredField(name);
                field.setAccessible(true);
                field.set(information,columnValue);
            }
            return information;
        }
        JDBCTools.CloseConnection(conn,ps);
        return null;
    }
}
