package QueryTest;

public class People {
    String Name,Password;
    public People(){
        super();
    }
    public People(String Name,String Password){
        super();
        this.Name=Name;
        this.Password=Password;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getName() {
        return Name;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public String getPassword() {
        return Password;
    }
    public String toString(){
        return "People [ID="+Name+",Password="+Password+"]";
    }
}
