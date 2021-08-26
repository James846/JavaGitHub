import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleRegister implements ActionListener {
    IntegrationView view;
    public void actionPerformed(ActionEvent e) {
        String ID=view.name.getText();
        String Password=view.password.getText();
        if(ID.length()==0)return;
        Information information=new Information();
        information.setID(ID);
        information.setPassword(Password);
        RegisterPeople rp=new RegisterPeople();
        int result=rp.registerPeople(information);
        if(result!=1) {
            view.hm.setText("注册失败！ ");
        }
        else{
            view.hm.setText("注册成功！ ");
        }
    }
    public void setView(IntegrationView view){
        this.view=view;
    }
}
