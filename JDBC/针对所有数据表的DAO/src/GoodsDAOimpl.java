import java.sql.Connection;
import java.util.List;

public class GoodsDAOimpl extends BaseDAO implements GoodsDAO {
    @Override
    public void insert(Connection conn, Goods goods, Object... args) {
        String sql="insert into goods values(?,?)";
        update(conn,sql,goods.getID(),goods.getName());
    }

    @Override
    public void delete(Connection conn, int id) {
        String sql="delete from goods where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, int id, Goods goods) {
        String sql="update goods set name=? where id=?";
        update(conn,sql,goods.getName(),goods.getID());
    }

    @Override
    public List<Goods> getAll(Connection conn) {
        String sql="select *from goods where id=?";
        List<Goods> list=getForList(conn,Goods.class,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from goods";
        return getValue(conn,sql);
    }
}
