package QueryTest;

import JDBCTools.JDBCTools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

//不同表的通用查询方法

public class QueryForDifferentTable {
    public static void getForListInstance()throws Exception{
        String sql="select ID,Password from information where ID=?";
        List<Information>list =getForList(Information.class,sql,"吴天雄1");
        list.forEach(System.out::println);
    }
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
    //测试结果
    public static void main(String[] args)throws Exception{
        getInstance();
        getForListInstance();
    }
    public static void getInstance()throws Exception{
        String sql="select ID,Password from information where ID=?";
        String sql1="select Name,Password from people where Name=?";
        Information information=getInstance(Information.class,sql,"吴天雄");
        System.out.println(information);
        People people=getInstance(People.class,sql1,"handsome");
        System.out.println(people);
    }
    public static <T> T getInstance(Class<T> clazz, String SQL, Object... args)throws Exception{
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
        if(rs.next()){
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
            return t;
        }
        JDBCTools.CloseConnection(conn,ps);
        return null;
    }
}
