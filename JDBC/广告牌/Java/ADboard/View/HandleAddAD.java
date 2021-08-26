package ADboard.View;
import java.awt.event.*;
import javax.swing.*;

import ADboard.Model.AddAD;
import ADboard.Model.Advertisement;
//负责处理添加广告视图上的ActionEvent事件
public class HandleAddAD implements ActionListener {
   AddADView view ;
   AddAD addAD;
   Advertisement ad;
   public HandleAddAD(){
      addAD = new AddAD();
      ad = new Advertisement();
   }
   public void actionPerformed(ActionEvent e) {
      addAD.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      if(e.getSource()==view.submit) {
         String number = view.inputSerialNumber.getText();
         String content = view.inputWord.getText();
         String contact=view.inputInform.getText();
         ad.setContent(content);
         ad.setSerialNumber(number);
         ad.setContactInformation(contact);
         boolean boo = addAD.addAdvertisement(ad);
         if(boo)
             view.hintMess.setText("添加成功");
         else
             view.hintMess.setText("添加失败");
      }
   }
   public void setView(AddADView view) {
      this.view = view;
   }
}