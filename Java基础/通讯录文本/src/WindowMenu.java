
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import static javax.swing.JFrame.*;
public class WindowMenu extends JFrame{
    JTextField text1,text2,text3;
    JButton button;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item1,item2;
    public WindowMenu(String s,int x,int y,int w,int h){
        init(s);
        setLocation(x,y);
        setSize(w,h);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s){
        button=new JButton("录入");
        setTitle(s);
        setLayout(new FlowLayout());
        menuBar=new JMenuBar();
        menu=new JMenu("菜单");
        item1=new JMenuItem("录入");
        menu.add(item1);
        item2=new JMenuItem("显示");
        menu.add(item2);
        add(new JLabel("输入姓名："));
        text1=new JTextField(10);
        add(text1);
        add(new JLabel("输入email:"));
        text2=new JTextField(10);
        add(text2);
        add(new JLabel("输入电话："));
        text3=new JTextField(10);
        add(text3);
        add(new JLabel("单击录入："));
        add(button);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                File fWrite=new File("通讯录文本.txt");
                try {
                    Writer out = new FileWriter(fWrite, true);
                    BufferedWriter bufferWrite = new BufferedWriter(out);
                    String str1 = text1.getText();
                    String str2=text2.getText();
                    String str3=text3.getText();
                    bufferWrite.write(str1);
                    bufferWrite.write("\n");
                    bufferWrite.write(str2);
                    bufferWrite.write("\n");
                    bufferWrite.write(str3);
                    bufferWrite.write("\n");
                    bufferWrite.close();
                }
                    catch(IOException ep){
                        System.out.println(ep.toString());
                    }

            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window win1=
                        new Window("通讯录显示",500,500,500,500);
            }
        });
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
}

