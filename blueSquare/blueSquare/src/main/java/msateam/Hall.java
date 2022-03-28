package msateam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Hall_table")
public class Hall  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long seatId;

    private String status;

    private String desc;

    private String lastAction;

    private String musicalName;


    @PostPersist
    public void onPostPersist(){
        MusicalRegistered musicalRegistered = new MusicalRegistered();
        BeanUtils.copyProperties(this, musicalRegistered);
        musicalRegistered.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){
        SeatReserved seatReserved = new SeatReserved();
        BeanUtils.copyProperties(this, seatReserved);
        seatReserved.publishAfterCommit();

        SeatCancelled seatCancelled = new SeatCancelled();
        BeanUtils.copyProperties(this, seatCancelled);
        seatCancelled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
        MusicalDeleted musicalDeleted = new MusicalDeleted();
        BeanUtils.copyProperties(this, musicalDeleted);
        musicalDeleted.publishAfterCommit();

    }

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
