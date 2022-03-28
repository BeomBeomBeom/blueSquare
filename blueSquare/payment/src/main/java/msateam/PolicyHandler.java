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
    @Autowired PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelRequested_CancelPayment(@Payload ReservationCancelRequested reservationCancelRequested){

        if(reservationCancelRequested.isMe()){

            // 취소 요청이 왔을 때 -> status -> cancelled 
            System.out.println("\n\n##### listener CancelPayment : " + reservationCancelRequested.toJson() + "\n\n");
            
            // 취소시킬 payId 추출
            long payId = reservationCancelRequested.getPayId(); // 취소시킬 payId

            Optional<Payment> res = paymentRepository.findById(payId);
            Payment payment = res.get();

            payment.setStatus("cancelled"); // 취소 상태로 

            // DB Update
            paymentRepository.save(payment);

    }


}


