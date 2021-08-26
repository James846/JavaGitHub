package ADboard.View;
import javax.swing.*;
import java.awt.event.*;
import ADboard.Model.*;
public class LoginView extends JPanel implements ActionListener {
   Login login;
   JTextField inputID;
   JPasswordField inputPassword;
   JButton buttonLogin; //��¼
   JButton buttonExit;  //�˳���¼
   public void setLogin(Login login){
      this.login = login;
   }
   LoginView() {
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      buttonLogin = new JButton("��¼");
      buttonExit = new JButton("�˳���¼");
      add(new JLabel("ID:"));
      add(inputID);
      add(new JLabel("����:"));
      add(inputPassword);
      add(buttonLogin);
      add(buttonExit);
      add(new JLabel("������3200608046"));
      buttonExit.addActionListener(new ActionListener(){
                           public void actionPerformed(ActionEvent e){
                             login.setLoginSuccess(false); 
                           }});
      buttonLogin.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e) {
      login.setID(inputID.getText());//����ID
      char [] pw =inputPassword.getPassword();
      login.setPassword(new String(pw));//��������Ϊ����ǰ������
      HandleLogin handleLogin = new HandleLogin();
      login = handleLogin.handleLogin(login);//����handle login������
      if(login.getLoginSuccess()) {
        JOptionPane.showMessageDialog
         (null,"��¼�ɹ�","��Ϣ�Ի��ɹ���", JOptionPane.WARNING_MESSAGE);
      }
      else {
        JOptionPane.showMessageDialog
         (null,"��¼ʧ��","��Ϣ�Ի�ʧ�ܿ�", JOptionPane.WARNING_MESSAGE);
      }
  }
}
