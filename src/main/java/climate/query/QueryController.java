package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/listAirline")
    public List<String> listAirline(@RequestParam("code") String code){
        return queryService.listAirline(code);
    }

    @RequestMapping("/listFlightDest")
    public List<Object[]> listFlight(@RequestParam("dest") String dest){
        return queryService.findFlight(dest);
    }
    @RequestMapping("/listFlightOriDest")
    public List<Object[]> listFlight(@RequestParam("ori") String origin, @RequestParam("dest") String dest){
        return queryService.findFlight(origin, dest);
    }


//    @RequestMapping("/listAirlineByCode")
//    public List<String> listFlight(@RequestParam("code") String code){
//        return queryService.findFlight(code);
//    }
}
