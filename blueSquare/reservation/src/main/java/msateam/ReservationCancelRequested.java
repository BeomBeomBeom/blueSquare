package msateam;


public class ReservationCancelRequested extends AbstractEvent {

    private Long rsvId;
    private Long seatId;
    private String status;
    private Long payId;

    public ReservationCancelRequested(){
        super();
    }

    public Long getRsvId() {
        return rsvId;
    }

    public void setRsvId(Long RsvId) {
        this.rsvId = rsvId;
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
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long PayId) {
        this.payId = payId;
    }
}
