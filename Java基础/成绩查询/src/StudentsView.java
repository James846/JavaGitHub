import java.util.List;
import java.util.Scanner;

public class StudentsView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入想要添加用户的ID：");
        int ID=scanner.nextInt();
        System.out.println("Type:");
        int Type= scanner.nextInt();
        System.out.println("IDCard:");
        String IDCard=scanner.next();
        System.out.println("ExamCard:");
        String ExamCard=scanner.next();
        System.out.println("StudentName:");
        String StudentName=scanner.next();
        System.out.println("Location:");
        String Location=scanner.next();
        System.out.println("Grade:");
        int Grade=scanner.nextInt();
        System.out.println("请输入想要删除用户的ID：");
        String deleteID=scanner.next();
        System.out.println("请输入想要查询用户的ID: ");
        String queryID=scanner.next();
        String sqladd="insert into examstudent values(?,?,?,?,?,?,?)";
        AddStudents.AddForStudents(sqladd,ID,Type,IDCard,ExamCard,StudentName,Location,Grade);
        String SQLdel="delete from examstudent where FlowID=?";
        DeleteStudents.DeleteForStudents(SQLdel,deleteID);
        String sqlquery="select FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where FlowID=?";
        List<Students> students =QueryStudents.getForList(Students.class,sqlquery,queryID);
        students.forEach(System.out::println);
    }
}
