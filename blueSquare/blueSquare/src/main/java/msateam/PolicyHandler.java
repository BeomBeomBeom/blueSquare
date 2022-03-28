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
    @Autowired HallRepository hallRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_ConfirmReserve(@Payload ReservationConfirmed reservationConfirmed){

        if(!reservationConfirmed.validate()) return;

        System.out.println("\n\n##### listener ConfirmReserve : " + reservationConfirmed.toJson() + "\n\n");


        Hall hall = new Hall();
        hall.setSeatId(reservationConfirmed.getSeatId());
        hall.setStatus(reservationConfirmed.getStatus());
        hall.setLastAction(reservationConfirmed.getTimestamp().toString());
        hallRepository.save(hall);

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener Cancel : " + reservationCancelled.toJson() + "\n\n");


        Hall hall = new Hall();
        hall.setSeatId(reservationCancelled.getSeatId());
        hall.setStatus(reservationCancelled.getStatus());
        hall.setLastAction(reservationCancelled.getTimestamp().toString());
        hallRepository.save(hall);


    }


}


