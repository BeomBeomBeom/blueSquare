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
        

        //////////////////////////////
        // Musical 테이블 Insert 후 수행
        //////////////////////////////

        // 기본값 셋팅
        lastAction = "register";    // Insert는 항상 register
        status = "available";       // 최초 등록시 항상 이용가능

        // MusicalRegistered Event 발생
        MusicalRegistered musicalRegistered = new MusicalRegistered();
        BeanUtils.copyProperties(this, musicalRegistered);
        musicalRegistered.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){

        
        /////////////////////////////
        // Musical 테이블 Update 후 수행
        /////////////////////////////

        System.out.println("lastAction : " + lastAction);

        // SeatReserved Event 발생
        if(lastAction.equals("reserved")) {
            SeatReserved seatReserved = new SeatReserved();
            BeanUtils.copyProperties(this, seatReserved);
            seatReserved.publishAfterCommit();
        }

        // RoomCancelled Event 발생
        if(lastAction.equals("cancelled")) {
            SeatCancelled seatCancelled = new SeatCancelled();
            BeanUtils.copyProperties(this, seatCancelled);
            seatCancelled.publishAfterCommit();
        }

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
