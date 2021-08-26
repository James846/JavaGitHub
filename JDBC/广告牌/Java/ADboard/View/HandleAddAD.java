package ADboard.View;
import java.awt.event.*;
import javax.swing.*;

import ADboard.Model.AddAD;
import ADboard.Model.Advertisement;
//��������ӹ����ͼ�ϵ�ActionEvent�¼�
public class HandleAddAD implements ActionListener {
   AddADView view ;
   AddAD addAD;
   Advertisement ad;
   public HandleAddAD(){
      addAD = new AddAD();
      ad = new Advertisement();
   }
   public void actionPerformed(ActionEvent e) {
      addAD.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"���ȵ�¼","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
         return;
      }
      if(e.getSource()==view.submit) {
         String number = view.inputSerialNumber.getText();
         String content = view.inputWord.getText();
         String contact=view.inputInform.getText();
         ad.setContent(content);
         ad.setSerialNumber(number);
         ad.setContactInformation(contact);
         boolean boo = addAD.addAdvertisement(ad);
         if(boo)
             view.hintMess.setText("��ӳɹ�");
         else
             view.hintMess.setText("���ʧ��");
      }
   }
   public void setView(AddADView view) {
      this.view = view;
   }
}