package msateam;

import msateam.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_ConfirmReserve(@Payload PaymentApproved paymentApproved){

        if(!paymentApproved.validate()) return;

        System.out.println("\n\n##### listener ConfirmReserve : " + paymentApproved.toJson() + "\n\n");

        
// ddd
        // 
        Reservation reservation = new Reservation();

        reservation.setPayId(paymentApproved.getPayId());
        reservation.setRsvId(paymentApproved.getRsvId());
        reservation.setSeatId(paymentApproved.getSeatId());
        reservation.setStatus(paymentApproved.getStatus());

        reservationRepository.save(reservation);

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCancelled_ConfirmCancel(@Payload PaymentCancelled paymentCancelled){

        if(!paymentCancelled.validate()) return;

        System.out.println("\n\n##### listener ConfirmCancel : " + paymentCancelled.toJson() + "\n\n");

        Reservation reservation = new Reservation();
        
        reservation.setPayId(paymentCancelled.getPayId());
        reservation.setRsvId(paymentCancelled.getRsvId());
        reservation.setSeatId(paymentCancelled.getSeatId());
        reservation.setStatus(paymentCancelled.getStatus());

        reservationRepository.save(reservation);

    }


}


