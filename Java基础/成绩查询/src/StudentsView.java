import java.util.Scanner;

public class StudentsView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        String sqldel="";
        String sqlquery="";
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
        String sqladd="insert into examstudent values(?,?,?,?,?,?,?)";
        AddStudents.AddForStudents(sqladd,ID,Type,IDCard,ExamCard,StudentName,Location,Grade);
    }
}
