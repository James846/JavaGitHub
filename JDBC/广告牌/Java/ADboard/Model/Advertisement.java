package ADboard.Model;

public class Advertisement {
    String ID;         //做广告的ID
    String content;   //广告的文本
    String contact;   //公司简介
    String serialNumber;//广告编号
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