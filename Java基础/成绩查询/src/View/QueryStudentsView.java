package View;

import Controller.QueryStudents;
import Model.Students;

import java.util.List;
import java.util.Scanner;

public class QueryStudentsView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入想要查询用户的ID: ");
        String queryID=scanner.next();
        String sqlquery="select FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where FlowID=?";
        List<Students> students = QueryStudents.getForList(Students.class,sqlquery,queryID);
        students.forEach(System.out::println);
    }
}
