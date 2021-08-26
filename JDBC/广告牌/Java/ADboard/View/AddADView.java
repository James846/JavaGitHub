package ADboard.View;
import javax.swing.*;
import java.awt.*;
import ADboard.Model.*;
public class AddADView extends JPanel {//添加广告的视图
   public Login login; 
   public JTextField inputSerialNumber;  //输入广告的序列号码
   public JTextArea inputWord;          //输入广告词
   public JTextArea inputInform;
   public JButton submit;               //提交按钮   
   public JTextField hintMess; //提示文本
   HandleAddAD handleAddAD;//负责处理添加广告
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
      inputWord.setFont(new Font("宋体",Font.BOLD,20));
      inputInform = new JTextArea(10,50);
      inputInform.setLineWrap(true);
      inputInform.setWrapStyleWord(true);
      inputInform.setFont(new Font("宋体",Font.BOLD,20));
      submit = new JButton("添加广告");
      pNorth.add(new JLabel("输入广告序列号"));
      pNorth.add(inputSerialNumber);
      pNorth.add(new JLabel("在文本区输入广告词以及公司简介"));
      pNorth.add(new JLabel("吴天雄3200608046"));
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