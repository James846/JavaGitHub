package ADboard.View;
import javax.swing.*;
import java.awt.*;

import ADboard.Model.*;
public class ADBoardView extends JPanel {
   ADBoard ADBoard;   //����ͼ��Ҫ��ʾ�Ĺ����
   public JTextArea showContent;        //��ʾ�������//��ʾ����ͼ��
   public JTextArea showContact;        //��˾���
   public JButton next,previous;       //ѡ����һ��棬��һ���İ�ť
   public JLabel showID   ;                  //��ʾ��淢����id
   public JLabel showNumber ;                //��ʾ�������к�
   HandleADBoard handleADBoard; //�����������еĹ��
   public ADBoardView() {
      initView();
      registerListener();
   } 
   public void initView() {
      setLayout(new BorderLayout());
      showContent = new JTextArea(5,20);
      showContent.setForeground(Color.red);
      showContent.setWrapStyleWord(true);
      showContent.setLineWrap(true); //�����Զ�
      showContent.setFont(new Font("����",Font.BOLD,40));
      showContact=new JTextArea(5,20);
      showContact.setForeground(Color.red);
      showContact.setWrapStyleWord(true);
      showContact.setLineWrap(true);
      showContact.setFont(new Font("����",Font.BOLD,40));
      next = new JButton("��һ���");
      previous = new JButton("��һ���");
      JPanel pNorth = new JPanel();
      pNorth.setBackground(Color.orange) ;
      showID = new JLabel();
      showNumber = new JLabel();
      pNorth.add(new JLabel("�����ߵ�ID:"));
      pNorth.add(showID);
      pNorth.add(new JLabel("�������к�:"));
      pNorth.add(showNumber);
      pNorth.add(new JLabel("������ 3200608046"));
      add(pNorth,BorderLayout.NORTH);
      JPanel pCenter = new JPanel();
      pCenter.setLayout(new GridLayout(1,2));//���񲼾�
      pCenter.add(new JScrollPane(showContent));
      pCenter.add(new JScrollPane(showContact));
      add(pCenter,BorderLayout.CENTER);
      JPanel pSouth = new JPanel();
      pSouth.add(next);
      pSouth.add(previous);
      add(pSouth,BorderLayout.SOUTH);
      validate();
   }
   public void registerListener(){
      handleADBoard = new HandleADBoard();
      next.addActionListener(handleADBoard);
      previous.addActionListener(handleADBoard);
      handleADBoard.setView(this);
   }
   public void setAdvertisingBoard(ADBoard ADBoard) {
      this.ADBoard = ADBoard;
   }
}
