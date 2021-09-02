import java.sql.Connection;
import java.util.List;

public interface GoodsDAO {
    //插入表数据
    void insert(Connection conn,Goods goods,Object...args);
    //删除表数据
    void delete(Connection conn,int id);
    //更改表数据
    void update(Connection conn,int id,Goods goods);
    //查询所有表数据
    List<Goods> getAll(Connection conn);
    Long getCount(Connection conn);
}
