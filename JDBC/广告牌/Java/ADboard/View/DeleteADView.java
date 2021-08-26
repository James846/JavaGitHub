package ADboard.View;
import javax.swing.*;

import ADboard.Model.*;
public class DeleteADView extends JPanel {//删除广告的视图
   Login login; 
   JTextField inputSerialNumber;  //输入广告的序列号码
   JButton submit;               //提交按钮   
   JTextField hintMess; 
   HandleDeleteAD handleDeleteAD;//负责删除广告
   DeleteADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      submit = new JButton("删除广告");
      add(new JLabel("输入广告的序列号码"));
      add(inputSerialNumber);
      add(submit);
      add(hintMess);
      add(new JLabel("吴天雄3200608046"));
   }
   private void registerListener() {
      handleDeleteAD = new HandleDeleteAD();
      handleDeleteAD.setView(this);
      submit.addActionListener(handleDeleteAD);
   }
}