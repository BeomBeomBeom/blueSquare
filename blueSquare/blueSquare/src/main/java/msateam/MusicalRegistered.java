package msateam;


public class MusicalRegistered extends AbstractEvent {

    private String musicalName;
    private String status;
    private String desc;
    private String lastAction;

    public MusicalRegistered(){
        super();
    }

    public String getMusicalName() {
        return musicalName;
    }

    public void setMusicalName(String MusicalName) {
        this.musicalName = musicalName;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String Desc) {
        this.desc = desc;
    }
    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String LastAction) {
        this.lastAction = lastAction;
    }
}
