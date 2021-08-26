import javax.swing.*;
import java.awt.*;

public class QueryPeopleView extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem delete,query;
    JTextField customer,ht,password;
    JButton button;
    HandleQueryPeople handleQueryPeople;
    QueryPeopleView(){
        setVisible(true);
        setLayout(new FlowLayout());
        menuBar=new JMenuBar();
        menu=new JMenu("菜单");
        delete=new JMenuItem("删除");
        menu.add(delete);
        query=new JMenuItem("查询");
        menu.add(query);
        add(new JLabel("输入需要查询的用户名："));
        customer=new JTextField(10);
        add(customer);
        button=new JButton("查询");
        add(button);
        ht=new JTextField(10);
        ht.setEditable(false);
        add(ht);
        password=new JTextField(10);
        password.setEditable(false);
        add(password);
        handleQueryPeople=new HandleQueryPeople();
        handleQueryPeople.setView(this);
        button.addActionListener(handleQueryPeople);
        setBounds(400,600,800,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
