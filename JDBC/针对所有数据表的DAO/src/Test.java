import JDBCTools.JDBCTools;

import java.sql.Connection;
import java.util.Scanner;

public class Test {
    GoodsDAOimpl goodsDAO=new GoodsDAOimpl();
    public static void main(String[] args) throws Exception {
        new Test().TestInsert();
        new Test().TestDelete();
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
        System.out.println("请输入需要删除的用户ID：");
        String ID=scanner.next();
        goodsDAO.delete(conn,ID);
        System.out.println("删除成功");
        JDBCTools.CloseConnection(conn,null);
    }
}
