package ADboard.View;
import javax.swing.*;
import java.awt.event.*;
import ADboard.Model.*;
public class HandleADBoard implements ActionListener{
    ADBoardView view;
    Advertisement advertisement;         //��ǰ�Ĺ��
    public void setView(ADBoardView view) {
       this.view = view;
    }
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==view.next){ 
          if(view.ADBoard !=null){
               advertisement = view.ADBoard.nextAdvertisement();
               handleAdvertisement(advertisement);
          }
          else {
             JOptionPane.showMessageDialog
              (view,"û�й��","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);

          }
       } 
       if(e.getSource()==view.previous){
          if(view.ADBoard !=null){
               advertisement = view.ADBoard.previousAdvertisement();
               handleAdvertisement(advertisement);
          }
          else {
            JOptionPane.showMessageDialog
              (view,"û�й��","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
          }
       } 
    }   
    private void handleAdvertisement(Advertisement advertisement) {
          if(advertisement==null) {
              JOptionPane.showMessageDialog
              (view,"û�й��","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
          }
          else {
              view.showID.setText(advertisement.getID());
              view.showNumber.setText(advertisement.getSerialNumber());
              view.showContent.setText(advertisement.getContent());
              view.showContact.setText(advertisement.getContact());
          }
    }
}