public class Goods {
    String id,name;

    public Goods(){
        super();
    }

    public Goods(String ID, String name) {
        super();
        this.id = ID;
        name = name;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String toString(){
        return "id: "+id+" name: "+name;
    }

}
