package msateam;


public class PaymentCancelled extends AbstractEvent {

    private Long payId;
    private Long rsvId;
    private Long seatId;
    private String status;

    public Long getpayId() {
        return payId;
    }

    public void setpayId(Long payId) {
        this.payId = payId;
    }
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
}
