import javax.swing.*;
import java.awt.*;

public class DeletePeopleView extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem delete,query;
    JTextField customer,ht;
    JButton button;
    HandleDeletePeople handleDeletePeople;
    DeletePeopleView(){
        setVisible(true);
        setLayout(new FlowLayout());
        menuBar=new JMenuBar();
        menu=new JMenu("菜单");
        delete=new JMenuItem("删除");
        menu.add(delete);
        query=new JMenuItem("查询");
        menu.add(query);
        add(new JLabel("输入需要删除的用户名："));
        customer=new JTextField(10);
        add(customer);
        button=new JButton("确认删除");
        add(button);
        ht=new JTextField(10);
        ht.setEditable(false);
        add(ht);
        handleDeletePeople=new HandleDeletePeople();
        handleDeletePeople.setView(this);
        button.addActionListener(handleDeletePeople);
        setBounds(400,600,800,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
