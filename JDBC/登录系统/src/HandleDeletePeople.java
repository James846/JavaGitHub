import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleDeletePeople implements ActionListener {
    DeletePeopleView delete;
    public void actionPerformed(ActionEvent e){
        String ID=delete.customer.getText();
        if(ID.length()==0)return;
        Information information=new Information();
        information.setID(ID);
        DeletePeople dp=new DeletePeople();
        int result=dp.deletepeople(information);
        if(result!=1){
            delete.ht.setText("删除失败");
        }
        else{
            delete.ht.setText("成功删除");
        }
    }
    public void setView(DeletePeopleView view){
        this.delete=view;
    }
}
