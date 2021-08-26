package ADboard.View;
import java.awt.event.*;
import javax.swing.*;
import ADboard.Model.*;
//�������ѯһ���û������ͼ�ϵ�ActionEvent�¼�
public class HandleQueryOneUserAD implements ActionListener {
   QueryOneUserADView view ;
   QueryOneUserAD query;
   public HandleQueryOneUserAD(){
      query = new QueryOneUserAD();
   }
   public void actionPerformed(ActionEvent e) {
      query.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"�����ȵ�¼","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String id = view.inputID.getText().trim();
      if(id.length() == 0) return;
      Advertisement [] ad = query.queryOneUser(id);
      if(ad == null ) return;
      ADBoard board = new ADBoard(); //���������
      board.setAdvertisement(ad);                      //����������ù��
      view.pCenter.setAdvertisingBoard(board);         //��ͼ����ʾ�����
      view.pCenter.next.doClick();
   }
   public void setView(QueryOneUserADView view) {
      this.view = view;
   }
}