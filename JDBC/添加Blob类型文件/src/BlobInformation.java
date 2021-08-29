import com.mysql.cj.jdbc.Blob;

public class BlobInformation {
    String frameName;
    int idframe;
    Blob photo;

    public BlobInformation(int idframe, String framename) {
        this.idframe=idframe;
        this.frameName=framename;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public int getIdframe() {
        return idframe;
    }

    public void setIdframe(int idframe) {
        this.idframe = idframe;
    }

    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    public String toString(){
        return ("idframe: "+idframe+" frameName: "+frameName);
    }
}
