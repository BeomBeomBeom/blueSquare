package msateam;


public class ReservationCancelled extends AbstractEvent {

    private Long rsvId;
    private Long seatId;
    private String status;
    private Long payId;

    public Long getrsvId() {
        return rsvId;
    }

    public void setrsvId(Long rsvId) {
        this.rsvId = rsvId;
    }
    public Long getseatId() {
        return seatId;
    }

    public void setseatId(Long seatId) {
        this.seatId = seatId;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    public Long getpayId() {
        return payId;
    }

    public void setpayId(Long payId) {
        this.payId = payId;
    }
}
