package View;

import Controller.DeleteStudents;

import java.util.Scanner;

public class StudentsDelView {
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入想要删除用户的ID：");
        String deleteID=scanner.next();
        String SQLdel="delete from examstudent where FlowID=?";
        DeleteStudents.DeleteForStudents(SQLdel,deleteID);
    }
}
