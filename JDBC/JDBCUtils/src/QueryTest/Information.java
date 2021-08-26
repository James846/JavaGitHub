package QueryTest;

public class Information {
    String ID,Password;
    public Information(){
        super();
    }
    public Information(String ID,String Password){
        super();
        this.ID=ID;
        this.Password=Password;
    }
    public void setID(String id){
        this.ID=id;
    }
    public String getID() {
        return ID;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public String getPassword() {
        return Password;
    }
    public String toString(){
        return "Information [ID="+ID+",Password="+Password+"]";
    }
}
