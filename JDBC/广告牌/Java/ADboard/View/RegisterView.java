package ADboard.View;
import javax.swing.*;
import java.awt.event.*;
import ADboard.Model.*;
public class RegisterView extends JPanel implements ActionListener {
   Register register;
   JTextField inputID;           //����ID
   JPasswordField inputPassword;//��������
   JPasswordField againPassword;//�ٴ���������
   JButton buttonRegister;
   RegisterView() {
      register = new Register();
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      againPassword = new JPasswordField(12);
      buttonRegister = new JButton("ע��");
      add(new JLabel("����ID:"));
      add(inputID);
      add(new JLabel("��������:"));
      add(inputPassword);
      add(new JLabel("�ٴ���������:"));
      add(againPassword);
      add(buttonRegister); 
      buttonRegister.addActionListener(this);
      add(new JLabel("������3200608046"));
   }
   public void actionPerformed(ActionEvent e) {
      String id = inputID.getText().trim();
      char [] pw =inputPassword.getPassword();
      char [] pw_again =againPassword.getPassword();
      String pwStr = new String(pw).trim();
      if(id.length() == 0 ||pwStr.length()==0 ){
         JOptionPane.showMessageDialog
         (null,"ע��ʧ�ܣ�������û�������Ϊ��","��Ϣ�Ի�ʧ�ܿ�", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String pw_againStr = new String(pw_again).trim();
      if(pwStr.equals(pw_againStr)){ //��������������ͬʱ
        register.setID(id);
        register.setPassword(new String(pw));
        HandleRegister handleRegister = new HandleRegister();
        boolean boo =handleRegister.handleRegister(register);
        if(boo) 
           JOptionPane.showMessageDialog
         (null,"ע��ɹ�","��Ϣ�Ի��ɹ���", JOptionPane.WARNING_MESSAGE);
        else
           JOptionPane.showMessageDialog
         (null,"ע��ʧ�ܣ�����ID","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
      }
      else {
         JOptionPane.showMessageDialog
         (null,"�����������벻ͬ","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
      } 
   }
}
