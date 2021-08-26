import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Window extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item1,item2;
    JTextArea textShow;
    public Window(String s,int x,int y,int w,int h){
        init(s);
        setLocation(x,y);
        setSize(w,h);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s){
        setTitle(s);
        setLayout(new FlowLayout());
        menuBar=new JMenuBar();
        menu=new JMenu("菜单");
        item1=new JMenuItem("录入");
        menu.add(item1);
        item2=new JMenuItem("显示");
        menu.add(item2);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        textShow=new JTextArea(20,20);
        add(new JScrollPane(textShow),BorderLayout.CENTER);
        try{
        Reader in=new FileReader("通讯录文本.txt");
        BufferedReader bufferRead=new BufferedReader(in);
            String str=null;
            int n=0;
            while((str=bufferRead.readLine())!=null){
                n++;
                if(n%3==1){
                    textShow.append("姓名："+str+"\n");
                }
                if(n%3==2){
                    textShow.append("email："+str+"\n");
                }
                if(n%3==0){
                    textShow.append("手机："+str+"\n");
                }
            }
            bufferRead.close();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
}
}
