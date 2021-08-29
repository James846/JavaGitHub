package Controller;

import JDBCTools.JDBCTools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class QueryStudents {
    public static <T> List<T> getForList(Class<T> clazz, String SQL, Object... args)throws Exception{
        //连接数据库，预处理SQL语句
        Connection conn= JDBCTools.getConnection();
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
        ArrayList<T> list=new ArrayList<T>();
        while(rs.next()){
            T t=clazz.newInstance();
            for(int i=0;i<getColumn;i++){
                //获取每个列的值：通过结果集
                Object columnValue=rs.getObject(i+1);
                //获取每个列的列名字：通过结果集的元数据
                String name=rsmd.getColumnLabel(i+1);
                Field field=clazz.getDeclaredField(name);
                field.setAccessible(true);
                field.set(t,columnValue);
            }
            list.add(t);
        }
        JDBCTools.CloseConnection(conn,ps);
        return list;
    }
}
