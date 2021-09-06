import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Test {
    public static void main(String[] args)throws Exception{
        new Test().TestConnection();
    }
    public void TestConnection()throws Exception{
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("IP.txt");
        Properties prop=new Properties();
        prop.load(is);
        //先展示MySQL的连接
        String user=prop.getProperty("username");
        String password=prop.getProperty("password");
        String url=prop.getProperty("url");
        String driverClass=prop.getProperty("driverClassName");
        Class.forName(driverClass);
        Connection conn= DriverManager.getConnection(url,user,password);
        System.out.println(conn);
        //对比Druid数据库连接池
        DataSource ds=DruidDataSourceFactory.createDataSource(prop);
        System.out.println(ds.getConnection());
    }
}
