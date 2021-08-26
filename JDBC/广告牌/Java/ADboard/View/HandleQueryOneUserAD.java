package ADboard.View;
import java.awt.event.*;
import javax.swing.*;
import ADboard.Model.*;
//负责处理查询一个用户广告视图上的ActionEvent事件
public class HandleQueryOneUserAD implements ActionListener {
   QueryOneUserADView view ;
   QueryOneUserAD query;
   public HandleQueryOneUserAD(){
      query = new QueryOneUserAD();
   }
   public void actionPerformed(ActionEvent e) {
      query.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"请您先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String id = view.inputID.getText().trim();
      if(id.length() == 0) return;
      Advertisement [] ad = query.queryOneUser(id);
      if(ad == null ) return;
      ADBoard board = new ADBoard(); //创建广告牌
      board.setAdvertisement(ad);                      //广告牌上设置广告
      view.pCenter.setAdvertisingBoard(board);         //视图上显示广告牌
      view.pCenter.next.doClick();
   }
   public void setView(QueryOneUserADView view) {
      this.view = view;
   }
}