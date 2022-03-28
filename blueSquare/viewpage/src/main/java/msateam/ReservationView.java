package msateam;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="ReservationView_table")
public class ReservationView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long seatId;
        private String desc;
        private String seatStatus;
        private Long rsvId;
        private String rsvStatus;
        private Long payId;
        private String payStatus;


        public Long getSeatId() {
            return seatId;
        }

        public void setSeatId(Long seatId) {
            this.seatId = seatId;
        }
        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getSeatStatus() {
            return seatStatus;
        }

        public void setSeatStatus(String seatStatus) {
            this.seatStatus = seatStatus;
        }
        public Long getRsvId() {
            return rsvId;
        }

        public void setRsvId(Long rsvId) {
            this.rsvId = rsvId;
        }
        public String getRsvStatus() {
            return rsvStatus;
        }

        public void setRsvStatus(String rsvStatus) {
            this.rsvStatus = rsvStatus;
        }
        public Long getPayId() {
            return payId;
        }

        public void setPayId(Long payId) {
            this.payId = payId;
        }
        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

}