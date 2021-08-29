package Model;

public class Students {
    int FlowID,Type,Grade;
    String IDCard,ExamCard,StudentName,Location;

    public void setFlowID(int a){
        this.FlowID=a;
    }
    public int getFlowID(){
        return FlowID;
    }
    public void setType(int b){
        this.Type=b;
    }
    public int getType(){
        return Type;
    }
    public void setGrade(int c){
        this.Grade=c;
    }
    public int getGrade(){
        return Grade;
    }
    public void setIDCard(String a){
        this.IDCard=a;
    }
    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }
    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public String getIDCard() {
        return IDCard;
    }
    public String getExamCard() {
        return ExamCard;
    }
    public String getStudentName() {
        return StudentName;
    }
    public String getLocation() {
        return Location;
    }
    public String toString(){
        return "Model.Students ID:"+FlowID+" Type: "+Type+" Grade: "+Grade+" IDCard: "+IDCard+" ExamCard: "+ExamCard+" StudentsName: "+StudentName+" Location: "+Location;
    }
}
