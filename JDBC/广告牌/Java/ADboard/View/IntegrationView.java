package ADboard.View;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import ADboard.Model.Login;
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane; //��ѡ��������и�����ͼ
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
        new JTabbedPane(JTabbedPane.LEFT);//������࣬Ĭ����JTabbedPane.TOP 
        tabbedPane.add("��¼",loginView); 
        tabbedPane.add("ע��",regisView);  
        tabbedPane.add("��ӹ��", addADView);
        tabbedPane.add("ɾ�����", deleteADView);
        tabbedPane.add("���ȫ���û����",queryAllUserADView);
        tabbedPane.add("���ĳ���û����",queryOneUserADView);
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER); 
        setBounds(100,100,1400,600);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}