package msateam.external;

public class Hall {

    private Long seatId;
    private String status;
    private String desc;
    private String lastAction;
    private String musicalName;

    public Long getSeatId() {
        return seatId;
    }
    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getLastAction() {
        return lastAction;
    }
    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }
    public String getMusicalName() {
        return musicalName;
    }
    public void setMusicalName(String musicalName) {
        this.musicalName = musicalName;
    }

}
