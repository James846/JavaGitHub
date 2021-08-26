import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleQueryPeople implements ActionListener {
    QueryPeopleView queryPeopleView;
    @Override
    public void actionPerformed(ActionEvent e) {
        String ID=queryPeopleView.customer.getText();
        String Password=queryPeopleView.password.getText();
        if(ID.length()==0)return;
        Information information=new Information();
        information.setID(ID);
        information.setPassword(Password);
        QueryPeople qp=new QueryPeople();
        if(qp.queryPeople(information).getQuery()){
        queryPeopleView.ht.setText(qp.queryPeople(information).getId());
        queryPeopleView.password.setText(qp.queryPeople(information).getPassword());
        }
        else {
            queryPeopleView.ht.setText("查无此人");
            queryPeopleView.password.setText("暂无密码");
        }
    }
    public void setView(QueryPeopleView View){
        this.queryPeopleView=View;
    }
}
