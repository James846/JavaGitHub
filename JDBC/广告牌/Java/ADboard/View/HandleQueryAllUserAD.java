package ADboard.View;
import java.awt.event.*;
import javax.swing.*;
import ADboard.Model.*;
//�������ѯ���й����ͼ�ϵ�ActionEvent�¼�
public class HandleQueryAllUserAD implements ActionListener {
   QueryAllUserAD  queryAll;
   QueryAllUserADView view ;
   public HandleQueryAllUserAD(){
      queryAll = new QueryAllUserAD();
   }
   public void actionPerformed(ActionEvent e) {
      queryAll.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"�����ȵ�¼","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
         return;
      }
      Advertisement [] ad = queryAll.queryAllUser();
      if(ad == null ) return;
      ADBoard board = new ADBoard(); //���������
      board.setAdvertisement(ad);                      //����������ù��
      view.pCenter.setAdvertisingBoard(board);//��ͼ����ʾ�����
      view.pCenter.next.doClick();
   }
   public void setView(QueryAllUserADView view) {
      this.view = view;
   }
}