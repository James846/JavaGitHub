import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HandleLogin implements ActionListener {
    IntegrationView login;
    public void actionPerformed(ActionEvent e){
        String ID=login.name.getText();
        String code=login.password.getText();
        if(ID.length()==0)return;
        Information information=new Information();
        information.setID(ID);
        information.setPassword(code);
        LoginPeople lp=new LoginPeople();
        Information result=lp.loginPeople(information);
        if(!result.getLogin()) {
            login.hintmess.setText("登陆失败！ ");
        }
        else{
            login.hintmess.setText("登录成功！ ");
        }
    }
    public void setView(IntegrationView login){
        this.login=login;
    }
}