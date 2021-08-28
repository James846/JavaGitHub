import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class AddBlobView {
    public static void main(String[] args)throws Exception{
        String SQL="insert into frame values(?,?,?)";
        FileInputStream in=new FileInputStream(new File("Exacubilar.jpg"));
        AddBlob.addblob(SQL,1,"Excalibur",in);
    }
}
