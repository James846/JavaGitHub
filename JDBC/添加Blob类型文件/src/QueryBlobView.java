import java.util.List;
import java.util.Scanner;

public class QueryBlobView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.print("idFrame:");
        int idframe= scanner.nextInt();
        String SQL="select idframe,frameName,framePicture from frame where idframe=?";
        QueryBlob.querybolb(SQL,idframe);
    }
}
