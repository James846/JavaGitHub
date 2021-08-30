package View;

import Controller.AddStudents;
import Controller.DeleteStudents;
import Controller.QueryStudents;
import Model.Students;

import java.util.List;
import java.util.Scanner;

public class AddStudentsView {
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
        String sqladd="insert into examstudent values(?,?,?,?,?,?,?)";
        AddStudents.AddForStudents(sqladd,ID,Type,IDCard,ExamCard,StudentName,Location,Grade);
    }
}
