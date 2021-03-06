import java.sql.Connection;
import java.util.List;

public class GoodsDAOimpl extends BaseDAO implements GoodsDAO {
    @Override
    public void insert(Connection conn, Goods goods, Object... args) {
        String sql="insert into goods values(?,?)";
        update(conn,sql,goods.getID(),goods.getName());
    }

    @Override
    public void delete(Connection conn, String id) {
        String sql="delete from goods where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, String id, Goods goods) {
        String sql="update goods set id=?,name=? where id=?";
        update(conn,sql,goods.getID(),goods.getName(),id);
    }

    @Override
    public List<Goods> getAll(Connection conn) {
        String sql="select *from goods";
        return getForList(conn,Goods.class,sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from goods";
        return getValue(conn,sql);
    }
}
