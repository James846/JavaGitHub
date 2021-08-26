package ADboard.View;
import javax.swing.*;
import java.awt.*;
import ADboard.Model.*;
public class QueryOneUserADView extends JPanel {//查询一个用户广告的视图
   public Login login; 
   public JTextField inputID;   //输入用户ID
   JButton submit;              //提交按钮 
   public ADBoardView pCenter ;       //显示广告
   HandleQueryOneUserAD  handleQueryOneUserAD;//负责查询某个用户的广告
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
      submit = new JButton("提交");
      pNorth.add(new JLabel("输入某用户ID，查询该ID做的广告"));
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