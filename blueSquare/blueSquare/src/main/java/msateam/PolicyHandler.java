package msateam;

import msateam.config.kafka.KafkaProcessor;

import java.util.Optional;

//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
//import java.util.*;

@Service
public class PolicyHandler{
    
    @Autowired
    private HallRepository hallRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_ConfirmReserve(@Payload ReservationConfirmed reservationConfirmed){
        
        if(reservationConfirmed.isMe()){

            ////////////////////////////////////////////////////////////////////
            // 예약 확정 시 -> Seat의 status => reserved, lastAction => reserved
            ////////////////////////////////////////////////////////////////////

            System.out.println("##### listener ConfirmReserve : " + reservationConfirmed.toJson());

            long seatId = reservationConfirmed.getSeatId(); // 삭제된 리뷰의 SeatID

            updateSeatStatus(seatId, "reserved", "reserved"); // Status Update

        }

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(reservationCancelled.isMe()){

            // 예약 취소 시 -> seat의 status => available, lastAction => cancelled
            System.out.println("##### listener Cancel : " + reservationCancelled.toJson());

            long seatId = reservationCancelled.getSeatId(); // 삭제된 리뷰의 SeatID

            updateSeatStatus(seatId, "available", "cancelled"); // Status Update
        }


    }
    
    private void updateSeatStatus(long seatId, String status, String lastAction)     {

        // seatId 데이터의 status, lastAction 수정

        // Seat 테이블에서 seatId의 Data 조회 -> seat
        Optional<Hall> res = hallRepository.findById(seatId);
        Hall hall = res.get();

        System.out.println("seatId      : " + hall.getSeatId());
        System.out.println("status      : " + hall.getStatus());
        System.out.println("lastAction  : " + hall.getLastAction());

        // seat 값 수정
        hall.setStatus(status); // status 수정 
        hall.setLastAction(lastAction);  // lastAction 값 셋팅

        System.out.println("Edited status     : " + hall.getStatus());
        System.out.println("Edited lastAction : " + hall.getLastAction());

        // DB Update
        hallRepository.save(hall);

    }


}


