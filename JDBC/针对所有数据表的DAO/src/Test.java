import JDBCTools.JDBCTools;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Test {
    GoodsDAOimpl goodsDAO=new GoodsDAOimpl();
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入想要执行的操作（增、删、改、查、查看总数据记录）：");
        String operate=scanner.next();
        if(operate.equals("增")) {
            new Test().TestInsert();
        }
        if(operate.equals("删")){
            new Test().TestDelete();
        }
        if(operate.equals("改")){
            new Test().TestUpdate();
        }
        if(operate.equals("查")){
            new Test().TestQuery();
        }
        if(operate.equals("查看总数据记录")){
            new Test().TestAll();
        }
    }
    //满足事务要求示例（仅仅为示例 事务本身并无意义）
    //1.插入数据
    public void TestInsert() throws Exception {
        Connection conn=JDBCTools.getConnection();
        try{
            conn.setAutoCommit(false);
            System.out.print("请输入插入用户的ID：");
            Scanner scanner=new Scanner(System.in);
            String ID=scanner.next();
            System.out.print("请输入用户名：");
            String name=scanner.next();
            Goods goods=new Goods(ID,name);
            goodsDAO.insert(conn,goods);
            System.out.println("添加成功");
            conn.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }
        finally{
            conn.setAutoCommit(true);
        }
        JDBCTools.CloseConnection(conn,null);
    }
    //2.删除某条数据
    public void TestDelete()throws Exception{
        Scanner scanner=new Scanner(System.in);
        Connection conn=JDBCTools.getConnection();
        System.out.print("请输入需要删除的用户ID：");
        String ID=scanner.next();
        goodsDAO.delete(conn,ID);
        System.out.println("删除成功");
        JDBCTools.CloseConnection(conn,null);
    }
    //3.更改某条数据 （运用事务）
    public void TestUpdate()throws Exception{
        Scanner scanner=new Scanner(System.in);
        Connection conn=JDBCTools.getConnection();
        try{
            conn.setAutoCommit(false);
            System.out.print("请输入需要更改的用户ID：");
            String originID=scanner.next();
            System.out.print("请输入更改后的用户ID：");
            String updateID=scanner.next();
            System.out.print("请输入更改后的用户名：");
            String updateName=scanner.next();
            Goods goods=new Goods(updateID,updateName);
            System.out.println("是否确认修改[y/n]?: ");
            String result=scanner.next();
            if(result.equals("y")){
                goodsDAO.update(conn,originID,goods);
                System.out.println("更改成功");
                conn.commit();
            }
            if(result.equals("n")){
                conn.rollback();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            conn.setAutoCommit(true);
        }
        JDBCTools.CloseConnection(conn,null);
    }
    public void TestQuery()throws Exception{
        Connection conn=JDBCTools.getConnection();
        List<Goods> goods=goodsDAO.getAll(conn);
        goods.forEach(System.out::println);
        JDBCTools.CloseResources(conn,null,null);
    }
    public void TestAll()throws Exception{
        Connection conn=JDBCTools.getConnection();
        Long result=goodsDAO.getCount(conn);
        System.out.println("总共有："+result+" 条数据");
        JDBCTools.CloseResources(conn,null,null);
    }
}
