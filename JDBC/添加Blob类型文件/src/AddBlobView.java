import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class AddBlobView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        String SQL="insert into frame values(?,?,?)";
        System.out.println("idFrame: ");
        String i= scanner.next();
        System.out.println("frameName: ");
        String name=scanner.next();
        System.out.println("Picture: ");
        String picture=scanner.next();
        FileInputStream in=new FileInputStream(new File(picture));
        AddBlob.addblob(SQL,i,name,in);
    }
}
