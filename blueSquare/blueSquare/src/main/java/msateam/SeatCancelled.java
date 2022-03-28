package msateam;


public class SeatCancelled extends AbstractEvent {

    private Long seatId;
    private String status;
    private String desc;
    private String lastAction;

    public SeatCancelled(){
        super();
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long SeatId) {
        this.seatId = seatId;
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
