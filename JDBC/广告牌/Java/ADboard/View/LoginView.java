package ADboard.View;
import javax.swing.*;
import java.awt.event.*;
import ADboard.Model.*;
public class LoginView extends JPanel implements ActionListener {
   Login login;
   JTextField inputID;
   JPasswordField inputPassword;
   JButton buttonLogin; //登录
   JButton buttonExit;  //退出登录
   public void setLogin(Login login){
      this.login = login;
   }
   LoginView() {
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      buttonLogin = new JButton("登录");
      buttonExit = new JButton("退出登录");
      add(new JLabel("ID:"));
      add(inputID);
      add(new JLabel("密码:"));
      add(inputPassword);
      add(buttonLogin);
      add(buttonExit);
      add(new JLabel("吴天雄3200608046"));
      buttonExit.addActionListener(new ActionListener(){
                           public void actionPerformed(ActionEvent e){
                             login.setLoginSuccess(false); 
                           }});
      buttonLogin.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e) {
      login.setID(inputID.getText());//设置ID
      char [] pw =inputPassword.getPassword();
      login.setPassword(new String(pw));//设置密码为加密前的密码
      HandleLogin handleLogin = new HandleLogin();
      login = handleLogin.handleLogin(login);//交给handle login控制器
      if(login.getLoginSuccess()) {
        JOptionPane.showMessageDialog
         (null,"登录成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
      }
      else {
        JOptionPane.showMessageDialog
         (null,"登录失败","消息对话失败框", JOptionPane.WARNING_MESSAGE);
      }
  }
}
