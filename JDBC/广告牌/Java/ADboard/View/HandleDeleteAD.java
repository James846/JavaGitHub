package ADboard.View;
import java.awt.event.*;
import javax.swing.JOptionPane;
import ADboard.Model.*;
//������ɾ��������ͼ�ϵ�ActionEvent�¼�
public class HandleDeleteAD implements ActionListener {
   DeleteADView view ;          //ɾ��������ͼ
   DeleteAD deleteAD;  //����ɾ�����Ķ���
   public HandleDeleteAD(){
      deleteAD = new DeleteAD();
   }
   public void actionPerformed(ActionEvent e) {
      deleteAD.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"���ȵ�¼","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String number = view.inputSerialNumber.getText().trim();
      boolean boo = deleteAD.delAdvertisement(number);//ɾ������
      if(boo)
         view.hintMess.setText("ɾ���ɹ�");
      else
         view.hintMess.setText("ɾ��ʧ�ܣ�û�иù��");
   }
   public void setView(DeleteADView view) {
      this.view = view;
   }
}