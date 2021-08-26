package ADboard.View;
import javax.swing.*;
import java.awt.*;

import ADboard.Model.*;
public class ADBoardView extends JPanel {
   ADBoard ADBoard;   //本视图需要显示的广告牌
   public JTextArea showContent;        //显示广告内容//显示广告的图像
   public JTextArea showContact;        //公司简介
   public JButton next,previous;       //选择上一广告，下一广告的按钮
   public JLabel showID   ;                  //显示广告发布者id
   public JLabel showNumber ;                //显示广告的序列号
   HandleADBoard handleADBoard; //负责处理广告牌中的广告
   public ADBoardView() {
      initView();
      registerListener();
   } 
   public void initView() {
      setLayout(new BorderLayout());
      showContent = new JTextArea(5,20);
      showContent.setForeground(Color.red);
      showContent.setWrapStyleWord(true);
      showContent.setLineWrap(true); //回行自动
      showContent.setFont(new Font("黑体",Font.BOLD,40));
      showContact=new JTextArea(5,20);
      showContact.setForeground(Color.red);
      showContact.setWrapStyleWord(true);
      showContact.setLineWrap(true);
      showContact.setFont(new Font("黑体",Font.BOLD,40));
      next = new JButton("下一广告");
      previous = new JButton("上一广告");
      JPanel pNorth = new JPanel();
      pNorth.setBackground(Color.orange) ;
      showID = new JLabel();
      showNumber = new JLabel();
      pNorth.add(new JLabel("发布者的ID:"));
      pNorth.add(showID);
      pNorth.add(new JLabel("广告的序列号:"));
      pNorth.add(showNumber);
      pNorth.add(new JLabel("吴天雄 3200608046"));
      add(pNorth,BorderLayout.NORTH);
      JPanel pCenter = new JPanel();
      pCenter.setLayout(new GridLayout(1,2));//网格布局
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
