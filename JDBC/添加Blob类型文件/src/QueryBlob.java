import JDBCTools.JDBCTools;

import java.io.FileInputStream;
import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryBlob {
    public static void querybolb(String SQL,Object...args)throws Exception{
        Connection conn=JDBCTools.getConnection();
        PreparedStatement ps=conn.prepareStatement(SQL);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        int idframe=rs.getInt("idframe");
        String framename=rs.getString("frameName");
        BlobInformation bi=new BlobInformation(idframe,framename);
        System.out.println(bi);
        Blob photo=rs.getBlob("framePicture");
        InputStream is=photo.getBinaryStream();
        FileOutputStream fos=new FileOutputStream("下载图片\\a.JPG");
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        is.close();
        fos.close();
        }
        JDBCTools.CloseConnection(conn,ps);
    }
}
