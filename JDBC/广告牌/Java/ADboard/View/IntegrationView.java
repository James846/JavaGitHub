package ADboard.View;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import ADboard.Model.Login;
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane; //用选项卡集成下列各个视图
    RegisterView  regisView;
    LoginView loginView;
    AddADView addADView;
    DeleteADView deleteADView;
    QueryAllUserADView  queryAllUserADView;
    QueryOneUserADView queryOneUserADView;
    Login login;
    public IntegrationView(){
        regisView = new RegisterView();
        login = new Login();
        loginView = new LoginView();
        addADView = new AddADView();
        deleteADView = new DeleteADView();
        queryAllUserADView = new QueryAllUserADView();
        queryOneUserADView = new QueryOneUserADView();
        loginView.setLogin(login);
        addADView.setLogin(login);
        deleteADView.setLogin(login);
        queryAllUserADView.setLogin(login);
        queryOneUserADView.setLogin(login);
        tabbedPane=
        new JTabbedPane(JTabbedPane.LEFT);//卡在左侧，默认是JTabbedPane.TOP 
        tabbedPane.add("登录",loginView); 
        tabbedPane.add("注册",regisView);  
        tabbedPane.add("添加广告", addADView);
        tabbedPane.add("删除广告", deleteADView);
        tabbedPane.add("浏览全部用户广告",queryAllUserADView);
        tabbedPane.add("浏览某个用户广告",queryOneUserADView);
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER); 
        setBounds(100,100,1400,600);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}