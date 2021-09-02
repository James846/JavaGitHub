import JDBCTools.JDBCTools;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {
    //1.通用增删改查操作
    public int update(Connection conn,String sql,Object...args) {
        PreparedStatement ps=null;
        try{
            ps=conn.prepareStatement(sql);
        for(int i=0;i< args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        return ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            JDBCTools.CloseConnection(null,ps);
        }
        return 0;
    }
    //2.查询数据表中的数据
    public static <T> List<T> getForList(Connection conn,Class<T> clazz, String SQL, Object... args){
        //连接数据库，预处理SQL语句
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = conn.prepareStatement(SQL);
            //填充通配符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行SQL语句
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int getColumn = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < getColumn; i++) {
                    //获取每个列的值：通过结果集
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的列名字：通过结果集的元数据
                    String name = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            JDBCTools.CloseResources(null,ps,rs);
        }
        return null;
    }
    //查询特殊需求 数据表中所有条数据总和
    public <E> E getValue(Connection conn,String sql,Object...args) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
           ps=conn.prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        rs=ps.executeQuery();
        if(rs.next()){
            return (E) rs.getObject(1);
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
        JDBCTools.CloseResources(null,ps,rs);
        }
        return null;
    }
}
