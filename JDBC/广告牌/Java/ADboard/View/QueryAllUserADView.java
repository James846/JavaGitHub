package ADboard.View;
import javax.swing.*;
import java.awt.*;
import ADboard.Model.*;
public class QueryAllUserADView extends JPanel {//��ѯȫ��������ͼ
   public Login login; 
   JButton submit;                              //�ύ��ť 
   public ADBoardView pCenter ;       //��ʾ���
   HandleQueryAllUserAD  handleQueryAllUserAD;  //�����ѯ���й��
   QueryAllUserADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel(); 
      pCenter = new ADBoardView();
      submit = new JButton("���ȫ�����");
      pNorth.add(submit);
      add(pNorth,BorderLayout.NORTH);
      add(pCenter,BorderLayout.CENTER);
   }
   private void registerListener() {
      handleQueryAllUserAD = new HandleQueryAllUserAD();
      handleQueryAllUserAD.setView(this);
      submit.addActionListener(handleQueryAllUserAD);
   }
}