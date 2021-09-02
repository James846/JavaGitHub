import JDBCTools.JDBCTools;

import java.sql.Connection;

public class Test {
    GoodsDAOimpl goodsDAO=new GoodsDAOimpl();
    public static void main(String[] args) throws Exception {
        new Test().TestInsert();
    }
    public void TestInsert() throws Exception {
        Connection conn=JDBCTools.getConnection();
        Goods goods=new Goods("6","张磊");
        goodsDAO.insert(conn,goods);
        System.out.println("添加成功");
        JDBCTools.CloseConnection(conn,null);
    }
}
