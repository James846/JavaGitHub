package ADboard.View;
import java.awt.event.*;
import javax.swing.*;
import ADboard.Model.*;
//负责处理查询所有广告视图上的ActionEvent事件
public class HandleQueryAllUserAD implements ActionListener {
   QueryAllUserAD  queryAll;
   QueryAllUserADView view ;
   public HandleQueryAllUserAD(){
      queryAll = new QueryAllUserAD();
   }
   public void actionPerformed(ActionEvent e) {
      queryAll.setLogin(view.login);
      if(!view.login.getLoginSuccess()){
        JOptionPane.showMessageDialog
        (null,"请您先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      Advertisement [] ad = queryAll.queryAllUser();
      if(ad == null ) return;
      ADBoard board = new ADBoard(); //创建广告牌
      board.setAdvertisement(ad);                      //广告牌上设置广告
      view.pCenter.setAdvertisingBoard(board);//视图上显示广告牌
      view.pCenter.next.doClick();
   }
   public void setView(QueryAllUserADView view) {
      this.view = view;
   }
}