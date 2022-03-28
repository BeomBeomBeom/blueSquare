package msateam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationViewRepository extends CrudRepository<ReservationView, Long> {

    List<ReservationView> findByRsvId(Long rsvId);
    List<ReservationView> findByRsvId(Long rsvId);
    List<ReservationView> findByPayId(Long payId);

}