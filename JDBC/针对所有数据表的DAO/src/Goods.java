public class Goods {
    String id,name;

    public Goods(String ID, String name) {
        this.id = ID;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "id: "+id+" name: "+name;
    }

}
