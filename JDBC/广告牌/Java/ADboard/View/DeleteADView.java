package ADboard.View;
import javax.swing.*;

import ADboard.Model.*;
public class DeleteADView extends JPanel {//ɾ��������ͼ
   Login login; 
   JTextField inputSerialNumber;  //����������к���
   JButton submit;               //�ύ��ť   
   JTextField hintMess; 
   HandleDeleteAD handleDeleteAD;//����ɾ�����
   DeleteADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      submit = new JButton("ɾ�����");
      add(new JLabel("����������к���"));
      add(inputSerialNumber);
      add(submit);
      add(hintMess);
      add(new JLabel("������3200608046"));
   }
   private void registerListener() {
      handleDeleteAD = new HandleDeleteAD();
      handleDeleteAD.setView(this);
      submit.addActionListener(handleDeleteAD);
   }
}