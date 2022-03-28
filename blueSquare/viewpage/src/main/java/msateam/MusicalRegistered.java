package msateam;


public class MusicalRegistered extends AbstractEvent {

    private String musicalName;
    private String status;
    private String desc;
    private String lastAction;

    public String getmusicalName() {
        return musicalName;
    }

    public void setmusicalName(String musicalName) {
        this.musicalName = musicalName;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    public String getdesc() {
        return desc;
    }

    public void setdesc(String desc) {
        this.desc = desc;
    }
    public String getlastAction() {
        return lastAction;
    }

    public void setlastAction(String lastAction) {
        this.lastAction = lastAction;
    }
}
