package msateam;

import msateam.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationViewViewHandler {


    @Autowired
    private ReservationViewRepository reservationViewRepository;

    
    //////////////////////////////////////////
    // 좌석이 예약되었을 때 Insert -> ReservationViewView TABLE
    //////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMusicalRegistered_then_CREATE_1 (@Payload MusicalRegistered musicalRegistered) {
        try {

            if (!musicalRegistered.validate()) return;

            // view 객체 생성
            ReservationView reservationView = new ReservationView();
            // view 객체에 이벤트의 Value 를 set 함
            reservationView.setId(musicalRegistered.getSeatId());
            reservationView.setDesc(musicalRegistered.getDesc());
            reservationView.setReviewCnt(musicalRegistered.getReviewCnt());
            reservationView.setSeatStatus(musicalRegistered.getStatus());
            // view 레파지 토리에 save
            reservationViewRepository.save(reservationView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    
    //////////////////////////////////////////////////
    // 예약이 확정되었을 때 Update -> ReservationView TABLE
    //////////////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_1(@Payload ReservationConfirmed reservationConfirmed) {
        try {
            if (!reservationConfirmed.validate()) return;
                // view 객체 조회
            Optional<ReservationView> reservationViewOptional = reservationViewRepository.findById(reservationConfirmed.getSeatId());

            if( reservationViewOptional.isPresent()) {
                 ReservationView reservationView = reservationViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 reservationView.setRsvId(reservationConfirmed.getRsvId());
                 reservationView.setRsvStatus(reservationConfirmed.getStatus());
                // view 레파지 토리에 save
                 reservationViewRepository.save(reservationView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    
    //////////////////////////////////////////////////
    // 결제가 승인 되었을 때 Update -> ReservationView TABLE
    //////////////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_2(@Payload PaymentApproved paymentApproved) {
        try {
                
            // SeatId로 변경
            Optional<Reservationview> reservationViewOptional = reservationViewRepository.findById(paymentApproved.getSeatId());
            if( reservationViewOptional.isPresent()) {
                ReservationView reservationView = reservationViewOptional.get();
                reservationView.setPayId(paymentApproved.getPayId());
                reservationView.setPayStatus(paymentApproved.getStatus());
                reservationViewRepository.save(reservationView);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //////////////////////////////////////////////////
    // 예약이 취소 되었을 때 Update -> ReservationView TABLE
    //////////////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_3(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
                // view 객체 조회

                    List<ReservationView> reservationViewList = reservationViewRepository.findByRsvId(reservationCancelled.getRsvId());
                    for(ReservationView reservationView : reservationViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationView.setRsvStatus(reservationCancelled.getStatus());
                // view 레파지 토리에 save
                reservationViewRepository.save(reservationView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //////////////////////////////////////////////////
    // 결제가 취소 되었을 때 Update -> ReservationView TABLE
    //////////////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_4(@Payload PaymentCancelled paymentCancelled) {
        try {
            if (!paymentCancelled.validate()) return;
                // view 객체 조회

                    List<ReservationView> reservationViewList = reservationViewRepository.findByPayId(paymentCancelled.getPayId());
                    for(ReservationView reservationView : reservationViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationView.setPayStatus(paymentCancelled.getStatus());
                // view 레파지 토리에 save
                reservationViewRepository.save(reservationView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    
    //////////////////////////////////////////////////
    // 공연이 취소 되었을 때 Delete -> ReservationView TABLE
    //////////////////////////////////////////////////
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMusicalDeleted_then_DELETE_1(@Payload MusicalDeleted musicalDeleted) {
        try {
            if (!musicalDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            reservationViewRepository.deleteById(musicalDeleted.getSeatId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

