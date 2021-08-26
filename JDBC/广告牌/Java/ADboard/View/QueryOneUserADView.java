package ADboard.View;
import javax.swing.*;
import java.awt.*;
import ADboard.Model.*;
public class QueryOneUserADView extends JPanel {//��ѯһ���û�������ͼ
   public Login login; 
   public JTextField inputID;   //�����û�ID
   JButton submit;              //�ύ��ť 
   public ADBoardView pCenter ;       //��ʾ���
   HandleQueryOneUserAD  handleQueryOneUserAD;//�����ѯĳ���û��Ĺ��
   QueryOneUserADView() {
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
      inputID = new JTextField(12);
      submit = new JButton("�ύ");
      pNorth.add(new JLabel("����ĳ�û�ID����ѯ��ID���Ĺ��"));
      pNorth.add(inputID);
      pNorth.add(submit);
      add(pNorth,BorderLayout.NORTH);
      add(pCenter,BorderLayout.CENTER);
   }
   private void registerListener() {
      handleQueryOneUserAD = new HandleQueryOneUserAD();
      handleQueryOneUserAD.setView(this);
      submit.addActionListener(handleQueryOneUserAD);
   }
}