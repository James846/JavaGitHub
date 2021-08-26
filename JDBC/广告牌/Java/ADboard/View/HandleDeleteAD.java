package ADboard.View;
import java.awt.event.*;
import javax.swing.JOptionPane;
import ADboard.Model.*;
//负责处理删除广告的视图上的ActionEvent事件
public class HandleDeleteAD implements ActionListener {
   DeleteADView view ;          //删除广告的视图
   DeleteAD deleteAD;  //负责删除广告的对象
   public HandleDeleteAD(){
      deleteAD = new DeleteAD();
   }
   public void actionPerformed(ActionEvent e) {
      deleteAD.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String number = view.inputSerialNumber.getText().trim();
      boolean boo = deleteAD.delAdvertisement(number);//删除操作
      if(boo)
         view.hintMess.setText("删除成功");
      else
         view.hintMess.setText("删除失败，没有该广告");
   }
   public void setView(DeleteADView view) {
      this.view = view;
   }
}