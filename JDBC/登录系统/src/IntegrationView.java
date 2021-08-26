import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegrationView extends JFrame {
    JTextField name, password;
    JButton button, bu;
    JTextField hintmess, hm;
    HandleLogin handleLogin;
    HandleRegister register;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem delete, query;
    IntegrationView() {
        setLayout(new FlowLayout());
        menuBar = new JMenuBar();
        menu = new JMenu("菜单");
        delete = new JMenuItem("删除");
        menu.add(delete);
        query = new JMenuItem("查询");
        menu.add(query);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        add(new JLabel("用户名: "));
        name = new JTextField(10);
        add(name);
        add(new JLabel("密码： "));
        password = new JTextField(10);
        add(password);
        button = new JButton("登录");
        bu = new JButton("注册");
        add(button);
        add(bu);
        hintmess = new JTextField(10);
        hintmess.setEditable(false);
        add(hintmess);
        hm = new JTextField(10);
        hm.setEditable(false);
        setVisible(true);
        add(hm);
        setBounds(400, 600, 800, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        handleLogin = new HandleLogin();
        handleLogin.setView(this);
        button.addActionListener(handleLogin);
        register = new HandleRegister();
        register.setView(this);
        bu.addActionListener(register);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletePeopleView deletePeopleView = new DeletePeopleView();
            }
        }
        );
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryPeopleView queryPeopleView= new QueryPeopleView();
            }
        }
    );
    }
}