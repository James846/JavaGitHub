package ADboard.Model;

public class Advertisement {
    String ID;         //������ID
    String content;   //�����ı�
    String contact;   //��˾���
    String serialNumber;//�����
    public void setID(String id){
       ID = id;
    }
    public String getID(){
       return ID;
    }
    public void setContent(String s) {
       content = s;
    }
    public String getContent() {
       return content;
    }
    public void setSerialNumber(String serialNumber){
       this.serialNumber = serialNumber;
    }
    public String getSerialNumber(){
       return serialNumber;
    }
    public void setContactInformation(String s){
        contact=s;
    }
    public String getContact(){
        return contact;
    }
}