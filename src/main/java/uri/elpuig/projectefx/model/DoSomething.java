package uri.elpuig.projectefx.model;

public class DoSomething {

    public String activity,type,link;
public int participants,key;
public double price,accessibility;

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setParticipants(Number participants) {
        this.participants = (int)participants;
    }

    public void setPrice(Number price) {
        this.price = price.doubleValue();
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setKey(Number key) {

        this.key = (int)key;
    }

    public void setAccessibility(Number accessibility) {
        this.accessibility =accessibility.doubleValue();
    }

    @Override
    public String toString() {
        return "DoSomething{\n" +
                "activitat=" + activity + '\n' +
                ", tipus=" + type + '\n' +
                ", participants=" + participants + '\n' +
                ", preu=" + price + '\n' +
                ", id=" + key + '\n' +
                ", Accessible=" + accessibility ;
    }
}
