import java.io.*;
import java.util.*;
public class Quiz {
    public static void main(String args[]){
        File QRead=new File("test.txt");
        try {
            Scanner reader=new Scanner(System.in);
            Reader in = new FileReader("test.txt");
            BufferedReader bR = new BufferedReader(in);
            int score = 0;
            String s = null,r = null,answer = null;
            String regex = "[^ABCD]";
            while((s = bR.readLine()) != null) {
                if(!s.startsWith("-")){
                    System.out.println(s);
                }
                else{
                    r=s;
                    r = r.replaceAll(regex, "");
                    System.out.print("输入选择的答案：");
                    answer = reader.next();
                    if(r.charAt(0) == answer.charAt(0)) {
                        score++;
                    }
                }
            }
            System.out.println("最后的得分："+score);
            System.out.println("姓名：吴天雄 学号：3200608046");
            bR.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }
}
