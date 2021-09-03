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
        else{
            System.out.println("输入非法字符");
        }
    }
    public void TestInsert() throws Exception {
        Connection conn=JDBCTools.getConnection();
        System.out.print("请输入插入用户的ID：");
        Scanner scanner=new Scanner(System.in);
        String ID=scanner.next();
        System.out.print("请输入用户名：");
        String name=scanner.next();
        Goods goods=new Goods(ID,name);
        goodsDAO.insert(conn,goods);
        System.out.println("添加成功");
        JDBCTools.CloseConnection(conn,null);
    }
    public void TestDelete()throws Exception{
        Scanner scanner=new Scanner(System.in);
        Connection conn=JDBCTools.getConnection();
        System.out.print("请输入需要删除的用户ID：");
        String ID=scanner.next();
        goodsDAO.delete(conn,ID);
        System.out.println("删除成功");
        JDBCTools.CloseConnection(conn,null);
    }
    public void TestUpdate()throws Exception{
        Scanner scanner=new Scanner(System.in);
        Connection conn=JDBCTools.getConnection();
        System.out.print("请输入需要更改的用户ID：");
        String originID=scanner.next();
        System.out.print("请输入更改后的用户ID：");
        String updateID=scanner.next();
        System.out.print("请输入更改后的用户名：");
        String updateName=scanner.next();
        Goods goods=new Goods(updateID,updateName);
        goodsDAO.update(conn,originID,goods);
        System.out.println("更改成功");
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
