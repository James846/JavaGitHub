package ADboard.View;
import javax.swing.*;
import java.awt.*;
import ADboard.Model.*;
public class AddADView extends JPanel {//��ӹ�����ͼ
   public Login login; 
   public JTextField inputSerialNumber;  //����������к���
   public JTextArea inputWord;          //�������
   public JTextArea inputInform;
   public JButton submit;               //�ύ��ť   
   public JTextField hintMess; //��ʾ�ı�
   HandleAddAD handleAddAD;//��������ӹ��
   AddADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      JPanel pSouth = new JPanel();
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      inputWord = new JTextArea(10,50);
      inputWord.setLineWrap(true);
      inputWord.setWrapStyleWord(true);
      inputWord.setFont(new Font("����",Font.BOLD,20));
      inputInform = new JTextArea(10,50);
      inputInform.setLineWrap(true);
      inputInform.setWrapStyleWord(true);
      inputInform.setFont(new Font("����",Font.BOLD,20));
      submit = new JButton("��ӹ��");
      pNorth.add(new JLabel("���������к�"));
      pNorth.add(inputSerialNumber);
      pNorth.add(new JLabel("���ı�����������Լ���˾���"));
      pNorth.add(new JLabel("������3200608046"));
      pSouth.add(submit);
      pSouth.add(hintMess);
      add(pNorth,BorderLayout.NORTH);
      add(pSouth,BorderLayout.SOUTH);
      add(new JScrollPane(inputWord),BorderLayout.WEST);
      add(new JScrollPane(inputInform),BorderLayout.EAST);
   }
   private void registerListener() {
      handleAddAD = new HandleAddAD();
      handleAddAD.setView(this);
      submit.addActionListener(handleAddAD);
   }
}