package msateam.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="blueSquare", url="http://blueSquare:8080")
public interface HallService {
    @RequestMapping(method= RequestMethod.GET, path="/halls")
    public void checkReservation(@RequestBody Hall hall);

}

